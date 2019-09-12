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
-- Table structure for table `zxcv_mensajesprivados`
--

DROP TABLE IF EXISTS `zxcv_mensajesprivados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zxcv_mensajesprivados` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `mensaje` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `id_creado` int(11) NOT NULL,
  `id_recibido` int(11) NOT NULL,
  `fecha` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_recibido_idx` (`id_recibido`),
  KEY `id_creado` (`id_creado`),
  CONSTRAINT `id_creado` FOREIGN KEY (`id_creado`) REFERENCES `zxcv_usuarios` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `id_recibido` FOREIGN KEY (`id_recibido`) REFERENCES `zxcv_usuarios` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zxcv_mensajesprivados`
--

LOCK TABLES `zxcv_mensajesprivados` WRITE;
/*!40000 ALTER TABLE `zxcv_mensajesprivados` DISABLE KEYS */;
INSERT INTO `zxcv_mensajesprivados` VALUES (1,'hola',1,2,'2019-09-10 11:49:36.552000'),(2,'hola',2,1,'2019-09-10 11:55:36.552000'),(3,'hola javi',1,3,'2019-09-12 07:58:30.598000'),(4,'como estas?',1,3,'2019-09-12 07:58:46.605000'),(5,'asdadsa',1,2,'2019-09-12 07:59:25.980000'),(6,'jose q tal',1,4,'2019-09-12 08:04:06.181000'),(7,'wwww',1,3,'2019-09-12 08:07:15.018000'),(8,'ewewew',1,2,'2019-09-12 08:11:05.653000'),(9,'qqqqqqq',1,2,'2019-09-12 08:13:00.152000'),(10,'232322',1,2,'2019-09-12 08:13:45.722000'),(11,'32232',1,2,'2019-09-12 08:15:51.479000'),(12,'wqwwewww',1,2,'2019-09-12 08:18:51.106000'),(13,'weqwq',1,2,'2019-09-12 08:20:27.989000'),(14,'hi',1,7,'2019-09-12 08:23:38.375000'),(15,'how are you',1,7,'2019-09-12 08:24:00.871000'),(16,'weweww',1,7,'2019-09-12 08:25:21.444000'),(17,'wewew\n',1,3,'2019-09-12 08:30:35.343000'),(18,'si',1,3,'2019-09-12 08:30:39.159000'),(19,'ewew',1,3,'2019-09-12 08:32:51.866000'),(20,'ronal',1,6,'2019-09-12 08:32:57.672000'),(21,'qqqq',1,2,'2019-09-12 08:36:39.159000');
/*!40000 ALTER TABLE `zxcv_mensajesprivados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-12 10:40:15
