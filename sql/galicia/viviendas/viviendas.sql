CREATE DATABASE  IF NOT EXISTS `viviendas` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `viviendas`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: viviendas
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `habitar`
--

DROP TABLE IF EXISTS `habitar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habitar` (
  `dni` char(10) NOT NULL,
  `cod_vivienda` char(10) NOT NULL,
  `fecha_inicio` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`dni`,`cod_vivienda`),
  KEY `FK_HABITAR_VIVIENDAS` (`cod_vivienda`),
  CONSTRAINT `FK_HABITAR_PERSONAS` FOREIGN KEY (`dni`) REFERENCES `personas` (`dni`),
  CONSTRAINT `FK_HABITAR_VIVIENDAS` FOREIGN KEY (`cod_vivienda`) REFERENCES `viviendas` (`cod_vivienda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitar`
--

LOCK TABLES `habitar` WRITE;
/*!40000 ALTER TABLE `habitar` DISABLE KEYS */;
INSERT INTO `habitar` VALUES ('33456789C','10003','1987-10-30 00:00:00.000000'),('34561232D','30000','1990-12-12 00:00:00.000000'),('50123456X','10003','2000-12-12 00:00:00.000000'),('50123456X','10004','1987-10-30 00:00:00.000000'),('50123456Z','40000','1985-12-11 00:00:00.000000'),('50123457A','50000','1990-12-10 00:00:00.000000');
/*!40000 ALTER TABLE `habitar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `dni` char(10) NOT NULL,
  `apellidos` char(20) DEFAULT NULL,
  `nombre` char(20) DEFAULT NULL,
  `dni_padre` char(10) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `FK_PERSONAS_PERSONAS` (`dni_padre`),
  CONSTRAINT `FK_PERSONAS_PERSONAS` FOREIGN KEY (`dni_padre`) REFERENCES `personas` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES ('33456123A','Perez F','Rodrigo',NULL),('33456789C','Rodriguez B','Marcos',NULL),('34561232D','Duran','Carlos','33456123A'),('50123456X','Gil','Juan','33456123A'),('50123456Z','Lopez B','Mario','33456789C'),('50123457A','Hernandez','Elena','50123456Z');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viviendas`
--

DROP TABLE IF EXISTS `viviendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viviendas` (
  `cod_vivienda` char(10) NOT NULL,
  `calle` char(20) DEFAULT NULL,
  `numero` char(10) DEFAULT NULL,
  `piso` char(10) DEFAULT NULL,
  `puerta` char(10) DEFAULT NULL,
  `metros` double DEFAULT NULL,
  `fecha_construccion` datetime(6) DEFAULT NULL,
  `nombre_zona` char(20) DEFAULT NULL,
  PRIMARY KEY (`cod_vivienda`),
  KEY `FK_VIVIENDAS_ZONAS` (`nombre_zona`),
  CONSTRAINT `FK_VIVIENDAS_ZONAS` FOREIGN KEY (`nombre_zona`) REFERENCES `zonas` (`nombre_zona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viviendas`
--

LOCK TABLES `viviendas` WRITE;
/*!40000 ALTER TABLE `viviendas` DISABLE KEYS */;
INSERT INTO `viviendas` VALUES ('10000','Cernadas','45','1','A',50,'1987-10-25 00:00:00.000000','Sector Sur'),('10001','Cernadas','45','1','B',65,'1987-10-25 00:00:00.000000','Sector Sur'),('10002','Cernadas','45','2','A',78,'1987-10-25 00:00:00.000000','Sector Sur'),('10003','Cernadas','45','2','B',80,'1987-10-25 00:00:00.000000','Sector Sur'),('10004','Cernadas','45','3','A',78,'1987-10-25 00:00:00.000000','Sector Sur'),('10005','Cernadas','45','3','B',80,'1987-10-25 00:00:00.000000','Sector Sur'),('20000','Barcelona','20','1','A',80,'1974-10-22 00:00:00.000000','Sector Norte'),('20001','Barcelona','20','1','B',80,'1984-10-22 00:00:00.000000','Sector Norte'),('30000','Juan Florez','35','1','A',90,'1990-10-12 00:00:00.000000','Centro'),('30001','Juan Florez','35','1','B',88,'1990-10-12 00:00:00.000000','Centro'),('40000','Juan Florez','40','1','A',61,'1985-10-11 00:00:00.000000','Centro'),('50000','Barcelona','78','2','C',90,'1990-10-10 00:00:00.000000','Sector Norte');
/*!40000 ALTER TABLE `viviendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zonas`
--

DROP TABLE IF EXISTS `zonas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zonas` (
  `nombre_zona` char(20) NOT NULL,
  `descripcion` char(30) DEFAULT NULL,
  PRIMARY KEY (`nombre_zona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zonas`
--

LOCK TABLES `zonas` WRITE;
/*!40000 ALTER TABLE `zonas` DISABLE KEYS */;
INSERT INTO `zonas` VALUES ('Centro','Zona central'),('Sector Este','Al este'),('Sector Norte','Al norte de la ciudad'),('Sector Oeste','Al west'),('Sector Sur','Al sur');
/*!40000 ALTER TABLE `zonas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-30 12:49:20
