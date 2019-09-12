-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema empadronamiento
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empadronamiento
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empadronamiento` DEFAULT CHARACTER SET utf8 ;
USE `empadronamiento` ;

-- -----------------------------------------------------
-- Table `empadronamiento`.`personas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`personas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(10) NOT NULL,
  `nombres` VARCHAR(40) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento`.`municipios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`municipios` (
  `id` INT(5) NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(15) NOT NULL,
  `nombre` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento`.`viviendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`viviendas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(15) NOT NULL,
  `datoscalle` VARCHAR(150) NOT NULL,
  `numero` INT(10) NOT NULL,
  `dueno_id` INT(11) NULL,
  `municipio_id` INT(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC),
  INDEX `fk_viviendas_personas1_idx` (`dueno_id` ASC),
  INDEX `fk_viviendas_municipios1_idx` (`municipio_id` ASC),
  CONSTRAINT `fk_viviendas_personas1`
    FOREIGN KEY (`dueno_id`)
    REFERENCES `empadronamiento`.`personas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_viviendas_municipios1`
    FOREIGN KEY (`municipio_id`)
    REFERENCES `empadronamiento`.`municipios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento`.`padron`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`padron` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `persona_id` INT(11) NOT NULL,
  `vivienda_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_personas_viviendas_municipios_personas_idx` (`persona_id` ASC),
  INDEX `fk_personas_viviendas_municipios_viviendas1_idx` (`vivienda_id` ASC),
  UNIQUE INDEX `persona_id_UNIQUE` (`persona_id` ASC),
  CONSTRAINT `fk_personas_viviendas_municipios_personas`
    FOREIGN KEY (`persona_id`)
    REFERENCES `empadronamiento`.`personas` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_personas_viviendas_municipios_viviendas1`
    FOREIGN KEY (`vivienda_id`)
    REFERENCES `empadronamiento`.`viviendas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
INSERT INTO `empadronamiento`.`viviendas` (`codigo`, `datoscalle`, `numero`, `dueno_id`, `municipio_id`) VALUES ('QWE', 'calle 1 nuevo  N5 2A', '122323242', '1', '1');
INSERT INTO `empadronamiento`.`viviendas` (`codigo`, `datoscalle`, `numero`, `dueno_id`, `municipio_id`) VALUES ('QASD', 'calle 2 viejo N2 1B', '12455223', '1', '2');
INSERT INTO `empadronamiento`.`viviendas` (`codigo`, `datoscalle`, `numero`, `dueno_id`, `municipio_id`) VALUES ('ZXCZ', 'calle 3 Nuevo N 3 4A', '4412221', '1', '1');
INSERT INTO `empadronamiento`.`viviendas` (`id`) VALUES ('AZXS');
