-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: private_chat
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `zxcv_mensajespublicos`
--

DROP TABLE IF EXISTS `zxcv_mensajespublicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zxcv_mensajespublicos` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `mensaje` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario_idx` (`id_usuario`),
  CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `zxcv_usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zxcv_mensajespublicos`
--

LOCK TABLES `zxcv_mensajespublicos` WRITE;
/*!40000 ALTER TABLE `zxcv_mensajespublicos` DISABLE KEYS */;
INSERT INTO `zxcv_mensajespublicos` VALUES (1,'Hola',1,'2019-09-10 09:12:00.000000'),(2,'Hola',2,'2019-09-10 09:13:00.000000'),(3,'Como estan',1,'2019-09-10 09:12:00.000000'),(4,'que tal todos?',4,'2019-09-10 11:42:30.897000'),(5,'soy yo',1,'2019-09-10 11:49:22.209000'),(6,'sda',1,'2019-09-10 11:49:36.552000'),(7,'sdsadsa',1,'2019-09-10 11:49:55.071000'),(8,'fran',2,'2019-09-10 11:51:19.682000'),(9,'aasda',2,'2019-09-10 11:57:06.309000'),(10,'dwdwda',1,'2019-09-10 11:58:01.766000'),(11,'wewew',1,'2019-09-10 11:59:50.414000'),(12,'soy nuevo',7,'2019-09-10 12:09:58.693000'),(13,'asdasda',7,'2019-09-10 12:15:44.157000'),(14,'si',1,'2019-09-10 12:16:10.405000'),(15,'sdsds',1,'2019-09-10 12:17:42.622000'),(16,'wewew',1,'2019-09-10 12:18:50.498000'),(17,'dsadad',1,'2019-09-10 12:22:27.193000'),(18,'dsadada',1,'2019-09-11 07:04:09.440000'),(19,'eeeqqeqeqeqeq',1,'2019-09-11 07:05:26.333000'),(20,'dadsadaa',1,'2019-09-11 07:15:30.825000'),(21,'sisi',1,'2019-09-11 07:56:58.645000'),(22,'ewewew',2,'2019-09-11 07:59:10.778000'),(23,'dwwdw',1,'2019-09-11 08:07:45.608000'),(24,'sdasda',2,'2019-09-11 08:08:42.263000'),(25,'SI',1,'2019-09-11 08:10:15.016000'),(26,'NONO',1,'2019-09-11 08:13:24.106000'),(27,'como esta todo?',1,'2019-09-11 08:17:28.725000'),(28,'como esta todo?',1,'2019-09-11 08:17:28.731000'),(29,'wewessd',1,'2019-09-11 08:18:49.853000'),(30,'admin',1,'2019-09-11 08:25:00.228000'),(31,'YO',1,'2019-09-11 08:26:26.600000'),(32,'buenos dias',6,'2019-09-11 08:31:02.372000'),(33,'buenos dias',6,'2019-09-11 08:31:02.379000'),(34,'que tal\n',6,'2019-09-11 08:32:19.941000'),(35,'la vida es dura',3,'2019-09-11 09:31:02.379000'),(36,'ewewew',1,'2019-09-12 07:59:33.670000'),(37,'adwdawdwa',1,'2019-09-12 08:03:26.889000');
/*!40000 ALTER TABLE `zxcv_mensajespublicos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-12 10:40:16
