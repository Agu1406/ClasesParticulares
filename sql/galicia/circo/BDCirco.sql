-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: circo
-- ------------------------------------------------------
-- Server version	9.0.1

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
-- Table structure for table `animales`
--

DROP TABLE IF EXISTS `animales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animales` (
  `nombre_animal` varchar(50) NOT NULL,
  `tipo` char(15) DEFAULT NULL,
  `anhos` tinyint unsigned DEFAULT NULL,
  `peso` tinyint unsigned DEFAULT NULL,
  `estatura` double DEFAULT NULL,
  `nombre_pista` char(10) DEFAULT NULL,
  `nombre_atraccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nombre_animal`),
  KEY `FK_Animales_Atracciones` (`nombre_atraccion`),
  KEY `FK_Animales_Pistas` (`nombre_pista`),
  CONSTRAINT `FK_Animales_Atracciones` FOREIGN KEY (`nombre_atraccion`) REFERENCES `atracciones` (`Nombre`),
  CONSTRAINT `FK_Animales_Pistas` FOREIGN KEY (`nombre_pista`) REFERENCES `pistas` (`Nombre_pista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animales`
--

LOCK TABLES `animales` WRITE;
/*!40000 ALTER TABLE `animales` DISABLE KEYS */;
INSERT INTO `animales` VALUES ('',NULL,NULL,NULL,NULL,NULL,NULL),('Caiman','Cocodrilo',1,70,1.1,'LATERAL2','El devorador'),('Leo','León',3,120,1.1,'CENTRAL','El gran felino'),('pepito','grillo',1,1,1,NULL,NULL),('Peter','Mono',1,30,0.7,NULL,NULL),('Princesa1','Jirafa',2,100,2.2,'LATERAL1','Las jirafas'),('Princesa2','Jirafa',3,110,2.3,'LATERAL1','Las jirafas');
/*!40000 ALTER TABLE `animales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artista_animal`
--

DROP TABLE IF EXISTS `artista_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artista_animal` (
  `nif` char(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`nif`,`nombre`),
  KEY `FK_Artista_animal_Animales` (`nombre`),
  CONSTRAINT `FK_Artista_animal_Animales` FOREIGN KEY (`nombre`) REFERENCES `animales` (`nombre_animal`),
  CONSTRAINT `FK_Artista_animal_Artistas` FOREIGN KEY (`nif`) REFERENCES `artistas` (`Nif`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista_animal`
--

LOCK TABLES `artista_animal` WRITE;
/*!40000 ALTER TABLE `artista_animal` DISABLE KEYS */;
INSERT INTO `artista_animal` VALUES ('11111111A','Caiman'),('22222222B','Caiman'),('11111111A','Leo'),('11111111A','Princesa1'),('22222222B','Princesa2');
/*!40000 ALTER TABLE `artista_animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artista_atraccion`
--

DROP TABLE IF EXISTS `artista_atraccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artista_atraccion` (
  `nif` char(9) NOT NULL,
  `nombre_atraccion` varchar(50) NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `fecha_fin` datetime DEFAULT NULL,
  PRIMARY KEY (`nif`,`nombre_atraccion`,`fecha_inicio`),
  KEY `FK_Artista_atraccion_Atracciones` (`nombre_atraccion`),
  CONSTRAINT `FK_Artista_atraccion_Artistas` FOREIGN KEY (`nif`) REFERENCES `artistas` (`Nif`),
  CONSTRAINT `FK_Artista_atraccion_Atracciones` FOREIGN KEY (`nombre_atraccion`) REFERENCES `atracciones` (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista_atraccion`
--

LOCK TABLES `artista_atraccion` WRITE;
/*!40000 ALTER TABLE `artista_atraccion` DISABLE KEYS */;
INSERT INTO `artista_atraccion` VALUES ('11111111A','El gran felino','2000-01-01 00:00:00','2000-03-01 00:00:00'),('11111111A','Las jirafas','2000-04-01 00:00:00',NULL),('22222222B','El gran felino','1999-11-01 00:00:00',NULL),('33333333C','El devorador','2001-04-01 00:00:00',NULL),('77777e','Las jirafas','2017-01-09 13:33:00',NULL);
/*!40000 ALTER TABLE `artista_atraccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artistas`
--

DROP TABLE IF EXISTS `artistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artistas` (
  `Nif` char(9) NOT NULL,
  `apellidos` char(30) DEFAULT NULL,
  `nombre` char(15) DEFAULT NULL,
  `nif_jefe` char(9) DEFAULT NULL,
  PRIMARY KEY (`Nif`),
  KEY `FK_Artistas_Artistas` (`nif_jefe`),
  CONSTRAINT `FK_Artistas_Artistas` FOREIGN KEY (`nif_jefe`) REFERENCES `artistas` (`Nif`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistas`
--

LOCK TABLES `artistas` WRITE;
/*!40000 ALTER TABLE `artistas` DISABLE KEYS */;
INSERT INTO `artistas` VALUES ('11111111A','Lopez','Juan','22222222B'),('22222222B','Sanchez','Luis',NULL),('33333333C','Perez','Carlos','22222222B'),('55555E','Flórez','Juan','11111111A'),('6655555E','otro','Juan','11111111A'),('77777e','Flórez','Juan','11111111A');
/*!40000 ALTER TABLE `artistas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atraccion_dia`
--

DROP TABLE IF EXISTS `atraccion_dia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atraccion_dia` (
  `nombre_atraccion` varchar(50) NOT NULL,
  `fecha` datetime NOT NULL,
  `num_espectadores` int DEFAULT NULL,
  `ganancia` int DEFAULT NULL,
  PRIMARY KEY (`nombre_atraccion`,`fecha`),
  CONSTRAINT `FK_atraccion_dia_Atracciones` FOREIGN KEY (`nombre_atraccion`) REFERENCES `atracciones` (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atraccion_dia`
--

LOCK TABLES `atraccion_dia` WRITE;
/*!40000 ALTER TABLE `atraccion_dia` DISABLE KEYS */;
INSERT INTO `atraccion_dia` VALUES ('El devorador','2001-04-01 00:00:00',400,430123),('El gran felino','1999-11-01 00:00:00',100,111212),('El gran felino','2000-01-01 00:00:00',230,100000),('El gran felino','2000-04-01 00:00:00',330,300000),('Las jirafas','2000-04-01 00:00:00',110,140300),('Las jirafas','2000-08-01 00:00:00',323,300000);
/*!40000 ALTER TABLE `atraccion_dia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atracciones`
--

DROP TABLE IF EXISTS `atracciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atracciones` (
  `Nombre` varchar(50) NOT NULL,
  `F_inicio` datetime DEFAULT NULL,
  `ganancias` int DEFAULT NULL,
  PRIMARY KEY (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atracciones`
--

LOCK TABLES `atracciones` WRITE;
/*!40000 ALTER TABLE `atracciones` DISABLE KEYS */;
INSERT INTO `atracciones` VALUES ('El devorador','2001-04-01 00:00:00',430123),('El gran felino','1999-11-01 00:00:00',511212),('El orangután',NULL,NULL),('Las jirafas','2000-04-01 00:00:00',440300);
/*!40000 ALTER TABLE `atracciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pistas`
--

DROP TABLE IF EXISTS `pistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pistas` (
  `Nombre_pista` char(10) NOT NULL,
  `Aforo` int DEFAULT NULL,
  PRIMARY KEY (`Nombre_pista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pistas`
--

LOCK TABLES `pistas` WRITE;
/*!40000 ALTER TABLE `pistas` DISABLE KEYS */;
INSERT INTO `pistas` VALUES ('CENTRAL',1000),('LATERAL1',300),('LATERAL2',400);
/*!40000 ALTER TABLE `pistas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-21 18:47:17
