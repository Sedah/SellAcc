-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: practice
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `accessories`
--

DROP TABLE IF EXISTS `accessories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accessories` (
  `acc_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` mediumtext NOT NULL,
  `price` float NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `cate_cate_id` int(11) NOT NULL,
  PRIMARY KEY (`acc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessories`
--

LOCK TABLES `accessories` WRITE;
/*!40000 ALTER TABLE `accessories` DISABLE KEYS */;
INSERT INTO `accessories` VALUES (1,'abcd','efg',150,'xxx',1),(2,'bnk','cmd',48,'zzz',2),(3,'ttt','yyy',145,'rrr',1);
/*!40000 ALTER TABLE `accessories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `add_id` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(100) NOT NULL,
  `district` varchar(100) NOT NULL,
  `house_num` varchar(100) NOT NULL,
  `street` varchar(100) NOT NULL,
  `area` varchar(100) NOT NULL,
  `postcode` char(5) NOT NULL,
  `status` enum('valid','invalid') NOT NULL DEFAULT 'valid',
  `member_cus_id` int(11) NOT NULL,
  PRIMARY KEY (`add_id`,`member_cus_id`),
  KEY `member_cus_id_idx` (`member_cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'','','','','','','valid',24);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `cate_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`cate_id`),
  UNIQUE KEY `cate_id_UNIQUE` (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'as'),(2,'aaa'),(3,'ttt');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `com_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `review` longtext NOT NULL,
  `date` datetime NOT NULL,
  `cus_cus_id` int(11) NOT NULL,
  `acc_acc_id` int(11) NOT NULL,
  PRIMARY KEY (`com_id`),
  KEY `cus_cus_id_idx` (`cus_cus_id`),
  KEY `acc_acc_id_fk_idx` (`acc_acc_id`),
  CONSTRAINT `acc_acc_id_fk` FOREIGN KEY (`acc_acc_id`) REFERENCES `accessories` (`acc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cus_cus_id_fk` FOREIGN KEY (`cus_cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `user_type` enum('mem','non') NOT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (24,'ss','ss','mem'),(25,'ss','ss','non'),(26,'-','-','non'),(27,'-','--','non'),(28,'dddd','qwerty','non'),(29,'xxxx','xx','non');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `position` enum('send','order') DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'ad','ad','min','order');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `cus_cus_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `point` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`cus_cus_id`),
  CONSTRAINT `cus_cus_id` FOREIGN KEY (`cus_cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (24,'ss','ss',131);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `buy_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status_order` enum('wait_verify','verify_pass','verify_not_pass','send','cancle') NOT NULL DEFAULT 'wait_verify',
  `use_point` int(11) DEFAULT NULL,
  `recieve_point` int(11) DEFAULT NULL,
  `total_price` float(8,2) NOT NULL,
  `address` text NOT NULL,
  `cus_cus_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_cus_cus_id_idx` (`cus_cus_id`),
  CONSTRAINT `order_cus_cus_id` FOREIGN KEY (`cus_cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'2018-04-15 22:35:30','wait_verify',NULL,NULL,150.00,'----',26),(2,'2018-04-16 11:30:09','wait_verify',NULL,4,450.00,'',24),(3,'2018-04-16 11:34:07','wait_verify',NULL,6,600.00,'',24),(4,'2018-04-16 11:35:04','wait_verify',NULL,1,150.00,'',24),(5,'2018-04-16 11:36:41','wait_verify',NULL,7,750.00,'',24),(6,'2018-04-16 11:40:19','wait_verify',NULL,3,300.00,'',24),(7,'2018-04-16 11:41:27','wait_verify',NULL,6,600.00,'',24),(8,'2018-04-16 11:43:22','wait_verify',NULL,1,150.00,'',24),(9,'2018-04-16 11:43:51','wait_verify',NULL,6,600.00,'',24),(10,'2018-04-16 11:44:17','wait_verify',NULL,4,450.00,'',24),(11,'2018-04-16 11:45:34','wait_verify',NULL,1,150.00,'',24),(12,'2018-04-16 11:47:25','wait_verify',NULL,7,750.00,'',24),(13,'2018-04-16 11:48:36','wait_verify',NULL,NULL,300.00,'------',26),(14,'2018-04-16 12:14:01','wait_verify',NULL,15,149.00,'',24),(15,'2018-04-16 12:16:17','wait_verify',10,15,140.00,'',24),(16,'2018-04-16 12:23:01','wait_verify',0,15,150.00,'',24),(17,'2018-04-16 12:45:37','wait_verify',10,15,140.00,'',24),(18,'2018-04-16 12:48:16','wait_verify',0,15,150.00,'',24),(19,'2018-04-16 12:56:14','wait_verify',0,4,48.00,'',24),(20,'2018-04-20 13:05:58','wait_verify',NULL,NULL,3750.00,'yyyyiiiillllhhhhgggg45678',28),(21,'2018-04-20 13:50:18','wait_verify',NULL,NULL,1500.00,'xxxxxxxxxxxxxxx',29);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
  `price` double NOT NULL,
  `quentity` int(11) NOT NULL,
  `acc_acc_id` int(11) NOT NULL,
  `item_num` int(11) NOT NULL,
  `order_order_id` int(11) NOT NULL,
  PRIMARY KEY (`acc_acc_id`,`item_num`,`order_order_id`),
  CONSTRAINT `odi_acc_acc_id_fk` FOREIGN KEY (`acc_acc_id`) REFERENCES `accessories` (`acc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (150,1,1,1,1),(150,3,1,1,2),(150,4,1,1,3),(150,1,1,1,4),(150,5,1,1,5),(150,2,1,1,6),(150,4,1,1,7),(150,1,1,1,8),(150,4,1,1,9),(150,3,1,1,10),(150,1,1,1,11),(150,5,1,1,12),(150,2,1,1,13),(150,1,1,1,14),(150,1,1,1,15),(150,1,1,1,16),(150,1,1,1,17),(150,1,1,1,18),(150,25,1,1,20),(150,10,1,1,21),(48,1,2,1,19);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `amount` float NOT NULL,
  `type` enum('credit','money-trans') NOT NULL,
  `image` varchar(255) NOT NULL,
  `order_order_id` int(11) NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `payment_order_order_id_idx` (`order_order_id`),
  CONSTRAINT `payment_order_order_id` FOREIGN KEY (`order_order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'2017-12-31 15:18:00',120,'money-trans','qw',1);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-20 19:51:38
