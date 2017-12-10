CREATE DATABASE  IF NOT EXISTS `braxsi1` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `braxsi1`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: braxsi1
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `estates`
--

DROP TABLE IF EXISTS `districts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `districts` (
  `district_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`district_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `districts`
--

LOCK TABLES `districts` WRITE;
UNLOCK TABLES;


--
-- Table structure for table `estates`
--

DROP TABLE IF EXISTS `estates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estates` (
  `estate_id` int(11) NOT NULL AUTO_INCREMENT,
  `district_id` int(11) NOT NULL,
  `total_area` DECIMAL(10,1) NOT NULL,
  `living_area` DECIMAL(10,1) NOT NULL,
  `kitchen_area` DECIMAL(10,1) NOT NULL,
  `floor` INT(11) NOT NULL,
  `floors` INT(11) NOT NULL,
  `distance_to_metro` INT(11),
  `description` varchar(512) DEFAULT NULL,
  `rooms` INT(11) NOT NULL,
  `contacts` varchar(255) NOT NULL,
  `user_id` int(16) NOT NULL,
  PRIMARY KEY (`estate_id`),
  KEY `fk_estates_users_idx` (`user_id`),
  KEY `fk_estates_districts_idx` (`district_id`),
  CONSTRAINT `fk_estates_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_estates_districts` FOREIGN KEY (`district_id`) REFERENCES `districts` (`district_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estates`
--

LOCK TABLES `estates` WRITE;
/*!40000 ALTER TABLE `estates` DISABLE KEYS */;
/*!40000 ALTER TABLE `estates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(16) NOT NULL AUTO_INCREMENT,
  `login` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(64) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-03 23:31:21

INSERT INTO users (user_id, login, password, email) VALUES (1, 'admin', 'password', 'admin');

INSERT INTO districts (district_id, name) VALUES (1, 'Центральный район');
INSERT INTO districts (district_id, name) VALUES (2, 'Советский район');
INSERT INTO districts (district_id, name) VALUES (3, 'Первомайский район');
INSERT INTO districts (district_id, name) VALUES (4, 'Партизанский район');
INSERT INTO districts (district_id, name) VALUES (5, 'Заводской район');
INSERT INTO districts (district_id, name) VALUES (6, 'Ленинский район');
INSERT INTO districts (district_id, name) VALUES (7, 'Октябрьский район');
INSERT INTO districts (district_id, name) VALUES (8, 'Московский район');
INSERT INTO districts (district_id, name) VALUES (9, 'Фрунзенский район');
