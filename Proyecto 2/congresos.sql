-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: congresos
-- ------------------------------------------------------
-- Server version	5.6.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `congreso`
--

DROP TABLE IF EXISTS `congreso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `congreso` (
  `cod_congreso` int(11) NOT NULL AUTO_INCREMENT,
  `cod_loc` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `titulo` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_congreso`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `congreso`
--

LOCK TABLES `congreso` WRITE;
/*!40000 ALTER TABLE `congreso` DISABLE KEYS */;
INSERT INTO `congreso` VALUES (9,10,'2015-01-01','Actualizacion General'),(10,11,'2015-01-16','Metodos Anestesia'),(11,12,'2014-10-01','Congreso de la CCSS'),(12,13,'2014-06-10','Congreso de Privadas');
/*!40000 ALTER TABLE `congreso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidad` (
  `cod_especialidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidad`
--

LOCK TABLES `especialidad` WRITE;
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
INSERT INTO `especialidad` VALUES (1,'Alergología'),(2,'Anestesiología y reanimación'),(3,'Cardiología'),(4,'Gastroenterología'),(5,'Endocrinología'),(6,'Geriatría'),(7,'Hematología y hemoterapia'),(8,'Hidrología médica'),(9,'Infectología'),(10,'Medicina aeroespacial'),(11,'Medicina del deporte'),(12,'Medicina del trabajo'),(13,'Medicina de urgencias'),(14,'Medicina familiar y comunitaria'),(15,'Medicina intensiva'),(16,'Medicina interna'),(17,'Medicina legal y forense'),(18,'Medicina preventiva y salud pública'),(19,'Nefrología'),(20,'Neumología'),(21,'Neurología'),(22,'Nutriología'),(23,'Odontología'),(24,'Oftalmología'),(25,'Oncología médica'),(26,'Oncología radioterápica'),(27,'Otorrinolaringología'),(28,'Pediatría'),(29,'Proctología'),(30,'Psiquiatría'),(31,'Rehabilitación'),(32,'Reumatología'),(33,'Traumatología'),(34,'Toxicología'),(35,'Urología');
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital` (
  `cod_hospital` int(11) NOT NULL AUTO_INCREMENT,
  `cod_loc` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_hospital`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (2,10,'Catolica'),(4,11,'Clinica Biblica'),(5,12,'Jerusalem'),(6,13,'Mexico'),(7,14,'Calderón'),(8,15,'San Juan de Dios');
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localizacion`
--

DROP TABLE IF EXISTS `localizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localizacion` (
  `cod_loc` int(11) NOT NULL AUTO_INCREMENT,
  `cod_pais` int(11) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `provincia` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_loc`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localizacion`
--

LOCK TABLES `localizacion` WRITE;
/*!40000 ALTER TABLE `localizacion` DISABLE KEYS */;
INSERT INTO `localizacion` VALUES (10,187,'Albania','New York'),(11,187,'New York','New York'),(12,41,'San Jose','San Jose'),(13,41,'Montes de Oca','San Jose'),(14,41,'Barreal','Heredia'),(15,192,'Maracaibo','Maracaibo');
/*!40000 ALTER TABLE `localizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico` (
  `cod_medico` int(11) NOT NULL AUTO_INCREMENT,
  `cod_especialidad` int(11) NOT NULL,
  `cod_loc` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_medico`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES (1,15,10,'DANIEL','GARCIA','DANIELGARcIA@hotmailcom'),(2,28,11,'ALEJANDRO','GONZALEZ','ALEJANDROGONZALEZ@hotmailcom'),(3,31,13,'PABLO','RODRIGUEZ','PABLORODRIGUEZ@hotmailcom'),(4,19,10,'HUGO','FERNANDEZ','HUGOFERNANDEZ@hotmailcom'),(5,28,11,'ALVARO','LOPEZ','ALVAROLOPEZ@hotmailcom'),(6,1,12,'ADRIAN','MARTINEZ','ADRIANMARTINEZ@hotmailcom'),(7,14,11,'DAVID','SANCHEZ','DAVIDSANCHEZ@hotmailcom'),(8,7,14,'JAVIER','PEREZ','JAVIERPEREZ@hotmailcom'),(9,9,14,'SERGIO','GOMEZ','SERGIOGOMEZ@hotmailcom'),(10,18,15,'DIEGO','MARTIN','DIEGOMARTIN@hotmailcom'),(11,23,15,'IVAN','JIMENEZ','IVANJIMENEZ@hotmailcom'),(12,29,12,'MARIO','RUIZ','MARIORUIZ@hotmailcom'),(13,29,12,'MARCOS','HERNANDEZ','MARCOSHERNANDEZ@hotmailcom'),(14,20,11,'IKER','DIAZ','IKERDIAZ@hotmailcom'),(15,17,10,'MANUEL','MORENO','MANUELMORENO@hotmailcom'),(16,8,11,'CARLOS','ALVAREZ','CARLOSALVAREZ@hotmailcom'),(17,22,15,'JORGE','MUÑOZ','JORGEMUÑOZ@hotmailcom'),(18,18,12,'MIGUEL','ROMERO','MIGUELROMERO@hotmailcom'),(19,20,13,'SAMUEL','ALONSO','SAMUELALONSO@hotmailcom'),(20,35,12,'LUCAS','GUTIERREZ','LUCASGUTIERREZ@hotmailcom'),(21,10,15,'RUBEN','NAVARRO','RUBENNAVARRO@hotmailcom'),(22,3,11,'ANTONIO','TORRES','ANTONIOTORRES@hotmailcom'),(23,27,10,'NICOLAS','DOMINGUEZ','NICOLASDOMINGUEZ@hotmailcom'),(24,16,12,'AITOR','VAZQUEZ','AITORVAZQUEZ@hotmailcom'),(25,24,14,'MARC','RAMOS','MARCRAMOS@hotmailcom'),(26,31,11,'VICTOR','GIL','VICTORGIL@hotmailcom'),(27,6,13,'RAUL','RAMIREZ','RAULRAMIREZ@hotmailcom'),(28,35,15,'JUAN','SERRANO','JUANSERRANO@hotmailcom'),(29,26,11,'HECTOR','BLANCO','HECTORBLANCO@hotmailcom'),(30,15,10,'ALEX','SUAREZ','ALEXSUAREZ@hotmailcom'),(31,20,14,'ANGEL','MOLINA','ANGELMOLINA@hotmailcom'),(32,7,13,'IZAN','MORALES','IZANMORALES@hotmailcom'),(33,2,13,'GONZALO','ORTEGA','GONZALOORTEGA@hotmailcom'),(34,2,15,'RODRIGO','DELGADO','RODRIGODELGADO@hotmailcom'),(35,31,15,'GUILLERMO','CASTRO','GUILLERMOCASTRO@hotmailcom'),(36,21,11,'JESUS','ORTIZ','JESUSORTIZ@hotmailcom'),(37,8,10,'GABRIEL','RUBIO','GABRIELRUBIO@hotmailcom'),(38,4,11,'JOSE','MARIN','JOSEMARIN@hotmailcom'),(39,29,15,'ALBERTO','SANZ','ALBERTOSANZ@hotmailcom'),(40,25,10,'FRANCISCO','IGLESIAS','FRANCISCOIGLESIAS@hotmailcom'),(41,7,15,'ADAM','NUÑEZ','ADAMNUÑEZ@hotmailcom'),(42,3,14,'PAU','MEDINA','PAUMEDINA@hotmailcom'),(43,1,15,'AARON','GARRIDO','AARONGARRIDO@hotmailcom'),(44,17,13,'MATEO','SANTOS','MATEOSANTOS@hotmailcom'),(45,27,15,'JAIME','CASTILLO','JAIMECASTILLO@hotmailcom'),(46,13,12,'MARTIN','CORTES','MARTINCORTES@hotmailcom'),(47,5,15,'PEDRO','LOZANO','PEDROLOZANO@hotmailcom'),(48,34,15,'OSCAR','GUERRERO','OSCARGUERRERO@hotmailcom'),(49,10,13,'LUIS','CANO','LUISCANO@hotmailcom'),(50,33,15,'ISMAEL','PRIETO','ISMAELPRIETO@hotmailcom'),(51,24,10,'RAFAEL','MENDEZ','RAFAELMENDEZ@hotmailcom'),(52,1,12,'MOHAMED','CALVO','MOHAMEDCALVO@hotmailcom'),(53,13,10,'ERIC','GALLEGO','ERICGALLEGO@hotmailcom'),(54,3,15,'UNAI','VIDAL','UNAIVIDAL@hotmailcom'),(55,3,11,'DARIO','CRUZ','DARIOCRUZ@hotmailcom'),(56,10,12,'FERNANDO','LEON','FERNANDOLEON@hotmailcom'),(57,25,12,'IGNACIO','HERRERA','IGNACIOHERRERA@hotmailcom'),(58,13,14,'POL','MARQUEZ','POLMARQUEZ@hotmailcom'),(59,11,13,'BRUNO','PEÑA','BRUNOPEÑA@hotmailcom'),(60,22,13,'JOEL','CABRERA','JOELCABRERA@hotmailcom'),(61,20,11,'MIGUEL','FLORES','MIGUELFLORES@hotmailcom'),(62,34,11,'CRISTIAN','CAMPOS','CRISTIANCAMPOS@hotmailcom'),(63,19,15,'ARNAU','VEGA','ARNAUVEGA@hotmailcom'),(64,6,11,'ANDRES','DIEZ','ANDRESDIEZ@hotmailcom'),(65,6,12,'ASIER','FUENTES','ASIERFUENTES@hotmailcom'),(66,23,14,'MARCO','CARRASCO','MARCOCARRASCO@hotmailcom'),(67,29,11,'JOAN','CABALLERO','JOANCABALLERO@hotmailcom'),(68,8,10,'ERIK','NIETO','ERIKNIETO@hotmailcom'),(69,22,12,'FRANCISCO','AGUILAR','FRANCISCOAGUILAR@hotmailcom'),(70,18,14,'SANTIAGO','PASCUAL','SANTIAGOPASCUAL@hotmailcom'),(71,16,15,'JOSE','REYES','JOSEREYES@hotmailcom'),(72,2,11,'RAYAN','HERRERO','RAYANHERRERO@hotmailcom'),(73,1,15,'ENRIQUE','SANTANA','ENRIQUESANTANA@hotmailcom'),(74,11,14,'BIEL','LORENZO','BIELLORENZO@hotmailcom'),(75,7,14,'JOSE','HIDALGO','JOSEHIDALGO@hotmailcom'),(76,7,15,'MARTI','MONTERO','MARTIMONTERO@hotmailcom'),(77,2,12,'SAUL','IBAÑEZ','SAULIBAÑEZ@hotmailcom'),(78,1,12,'EDUARDO','GIMENEZ','EDUARDOGIMENEZ@hotmailcom'),(79,2,15,'ISAAC','FERRER','ISAACFERRER@hotmailcom'),(80,15,12,'JAN','DURAN','JANDURAN@hotmailcom'),(81,17,12,'JORDI','VICENTE','JORDIVICENTE@hotmailcom'),(82,11,12,'ROBERTO','BENITEZ','ROBERTOBENITEZ@hotmailcom'),(83,33,15,'ADRIA','MORA','ADRIAMORA@hotmailcom'),(84,17,13,'ORIOL','ARIAS','ORIOLARIAS@hotmailcom'),(85,10,13,'GERARD','SANTIAGO','GERARDSANTIAGO@hotmailcom'),(86,18,13,'JUAN','VARGAS','JUANVARGAS@hotmailcom'),(87,14,13,'GUILLEM','CARMONA','GUILLEMCARMONA@hotmailcom'),(88,13,10,'OMAR','CRESPO','OMARCRESPO@hotmailcom'),(89,17,13,'CHRISTIAN','PASTOR','CHRISTIANPASTOR@hotmailcom'),(90,32,12,'LEO','ROMAN','LEOROMAN@hotmailcom'),(91,26,11,'JUAN','SOTO','JUANSOTO@hotmailcom'),(92,28,12,'ALEIX','SAEZ','ALEIXSAEZ@hotmailcom'),(93,32,12,'CESAR','VELASCO','CESARVELASCO@hotmailcom'),(94,1,12,'ROGER','SOLER','ROGERSOLER@hotmailcom'),(95,33,13,'JOSE','MOYA','JOSEMOYA@hotmailcom'),(96,20,13,'YERAY','ESTEBAN','YERAYESTEBAN@hotmailcom'),(97,25,10,'JOSE','PARRA','JOSEPARRA@hotmailcom'),(98,34,14,'SERGI','BRAVO','SERGIBRAVO@hotmailcom'),(99,27,11,'MIKEL','GALLARDO','MIKELGALLARDO@hotmailcom'),(100,34,11,'KEVIN','ROJAS','KEVINROJAS@hotmailcom');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `cod_pais` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Afghanistan'),(2,'Albania'),(3,'Algeria'),(4,'Andorra'),(5,'Angola'),(6,'Antigua & Deps'),(7,'Argentina'),(8,'Armenia'),(9,'Australia'),(10,'Austria'),(11,'Azerbaijan'),(12,'Bahamas'),(13,'Bahrain'),(14,'Bangladesh'),(15,'Barbados'),(16,'Belarus'),(17,'Belgium'),(18,'Belize'),(19,'Benin'),(20,'Bhutan'),(21,'Bolivia'),(22,'Bosnia Herzegovina'),(23,'Botswana'),(24,'Brazil'),(25,'Brunei'),(26,'Bulgaria'),(27,'Burkina'),(28,'Burundi'),(29,'Cambodia'),(30,'Cameroon'),(31,'Canada'),(32,'Cape Verde'),(33,'Central African Rep'),(34,'Chad'),(35,'Chile'),(36,'China'),(37,'Colombia'),(38,'Comoros'),(39,'Congo'),(40,'Congo {Democratic Rep}'),(41,'Costa Rica'),(42,'Croatia'),(43,'Cuba'),(44,'Cyprus'),(45,'Czech Republic'),(46,'Denmark'),(47,'Djibouti'),(48,'Dominica'),(49,'Dominican Republic'),(50,'East Timor'),(51,'Ecuador'),(52,'Egypt'),(53,'El Salvador'),(54,'Equatorial Guinea'),(55,'Eritrea'),(56,'Estonia'),(57,'Ethiopia'),(58,'Fiji'),(59,'Finland'),(60,'France'),(61,'Gabon'),(62,'Gambia'),(63,'Georgia'),(64,'Germany'),(65,'Ghana'),(66,'Greece'),(67,'Grenada'),(68,'Guatemala'),(69,'Guinea'),(70,'Guinea-Bissau'),(71,'Guyana'),(72,'Haiti'),(73,'Honduras'),(74,'Hungary'),(75,'Iceland'),(76,'India'),(77,'Indonesia'),(78,'Iran'),(79,'Iraq'),(80,'Ireland {Republic}'),(81,'Israel'),(82,'Italy'),(83,'Ivory Coast'),(84,'Jamaica'),(85,'Japan'),(86,'Jordan'),(87,'Kazakhstan'),(88,'Kenya'),(89,'Kiribati'),(90,'Korea North'),(91,'Korea South'),(92,'Kosovo'),(93,'Kuwait'),(94,'Kyrgyzstan'),(95,'Laos'),(96,'Latvia'),(97,'Lebanon'),(98,'Lesotho'),(99,'Liberia'),(100,'Libya'),(101,'Liechtenstein'),(102,'Lithuania'),(103,'Luxembourg'),(104,'Macedonia'),(105,'Madagascar'),(106,'Malawi'),(107,'Malaysia'),(108,'Maldives'),(109,'Mali'),(110,'Malta'),(111,'Marshall Islands'),(112,'Mauritania'),(113,'Mauritius'),(114,'Mexico'),(115,'Micronesia'),(116,'Moldova'),(117,'Monaco'),(118,'Mongolia'),(119,'Montenegro'),(120,'Morocco'),(121,'Mozambique'),(122,'Myanmar, {Burma}'),(123,'Namibia'),(124,'Nauru'),(125,'Nepal'),(126,'Netherlands'),(127,'New Zealand'),(128,'Nicaragua'),(129,'Niger'),(130,'Nigeria'),(131,'Norway'),(132,'Oman'),(133,'Pakistan'),(134,'Palau'),(135,'Panama'),(136,'Papua New Guinea'),(137,'Paraguay'),(138,'Peru'),(139,'Philippines'),(140,'Poland'),(141,'Portugal'),(142,'Qatar'),(143,'Romania'),(144,'Russian Federation'),(145,'Rwanda'),(146,'St Kitts & Nevis'),(147,'St Lucia'),(148,'Saint Vincent & the Grenadines'),(149,'Samoa'),(150,'San Marino'),(151,'Sao Tome & Principe'),(152,'Saudi Arabia'),(153,'Senegal'),(154,'Serbia'),(155,'Seychelles'),(156,'Sierra Leone'),(157,'Singapore'),(158,'Slovakia'),(159,'Slovenia'),(160,'Solomon Islands'),(161,'Somalia'),(162,'South Africa'),(163,'South Sudan'),(164,'Spain'),(165,'Sri Lanka'),(166,'Sudan'),(167,'Suriname'),(168,'Swaziland'),(169,'Sweden'),(170,'Switzerland'),(171,'Syria'),(172,'Taiwan'),(173,'Tajikistan'),(174,'Tanzania'),(175,'Thailand'),(176,'Togo'),(177,'Tonga'),(178,'Trinidad & Tobago'),(179,'Tunisia'),(180,'Turkey'),(181,'Turkmenistan'),(182,'Tuvalu'),(183,'Uganda'),(184,'Ukraine'),(185,'United Arab Emirates'),(186,'United Kingdom'),(187,'United States'),(188,'Uruguay'),(189,'Uzbekistan'),(190,'Vanuatu'),(191,'Vatican City'),(192,'Venezuela'),(193,'Vietnam'),(194,'Yemen'),(195,'Zambia'),(196,'Zimbabwe');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participacion`
--

DROP TABLE IF EXISTS `participacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participacion` (
  `cod_participacion` int(11) NOT NULL AUTO_INCREMENT,
  `cod_medico` int(11) NOT NULL,
  `cod_congreso` int(11) NOT NULL,
  `cod_hospital` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_participacion`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participacion`
--

LOCK TABLES `participacion` WRITE;
/*!40000 ALTER TABLE `participacion` DISABLE KEYS */;
INSERT INTO `participacion` VALUES (1,7,9,2),(3,11,9,4),(4,13,9,5),(5,21,10,6),(7,32,10,7),(8,45,11,8),(9,62,12,0),(11,84,12,0);
/*!40000 ALTER TABLE `participacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ponencia`
--

DROP TABLE IF EXISTS `ponencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ponencia` (
  `cod_ponencia` int(11) NOT NULL AUTO_INCREMENT,
  `cod_congreso` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_ponencia`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ponencia`
--

LOCK TABLES `ponencia` WRITE;
/*!40000 ALTER TABLE `ponencia` DISABLE KEYS */;
INSERT INTO `ponencia` VALUES (5,9,'Tratamiento del Metabolismo'),(6,9,'Adolescencia y Alimentacion'),(7,9,'Bulimia'),(8,9,'Metabolismo de Adultos'),(9,9,'Errores Congenitos del Metabolismo'),(10,10,'Terapia Fisica'),(11,10,'Funcionamiento del BH4'),(12,10,'Hombro Doloroso'),(13,10,'Estrategias Nutricionales del Deporte'),(14,11,'Beneficios del Ejercicio Fisico'),(15,11,'Ejercicio como prevención');
/*!40000 ALTER TABLE `ponencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ponencia_medico`
--

DROP TABLE IF EXISTS `ponencia_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ponencia_medico` (
  `cod_pm` int(11) NOT NULL AUTO_INCREMENT,
  `cod_medico` int(11) NOT NULL,
  `cod_ponencia` int(11) NOT NULL,
  PRIMARY KEY (`cod_pm`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ponencia_medico`
--

LOCK TABLES `ponencia_medico` WRITE;
/*!40000 ALTER TABLE `ponencia_medico` DISABLE KEYS */;
INSERT INTO `ponencia_medico` VALUES (5,22,1),(6,23,1),(7,32,1),(8,56,1),(9,11,2),(10,12,2),(11,16,2),(12,85,2),(13,65,2),(14,65,5),(15,75,5),(16,89,5),(17,92,5),(18,55,5),(19,66,5),(20,77,6),(21,78,6),(22,79,6),(23,80,6),(24,12,7),(25,13,7),(26,14,7),(27,15,7),(28,16,7),(29,17,7),(30,10,8),(31,22,8),(32,23,8),(33,24,8),(34,25,8),(35,26,8);
/*!40000 ALTER TABLE `ponencia_medico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-29 22:47:40
