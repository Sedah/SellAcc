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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessories`
--

LOCK TABLES `accessories` WRITE;
/*!40000 ALTER TABLE `accessories` DISABLE KEYS */;
INSERT INTO `accessories` VALUES (1,'แหวนไม้ handmade ดอกยิปโซ','แหวนไม้ handmade\r\nข้างในเป็นดอกยิปโซ\r\nสื่อถึงความบริสุทธิ์จริงใจ อ่อนหวาน ดอกไม้แห่งรักแรก\r\n\r\nมี 2 สี : สีธรรมชาติ(สีไม้) สีดำ\r\nมี 2 ขนาด \r\n\r\nแหวนปรับขนาดไซด์ได้',100,'https://i.imgur.com/c6UHmfR.jpg',2),(2,'สร้อยโหลแก้วจิ๋ว ดาว ดอกไม้ หัวใจ','สร้อยโหลแก้วจิ๋ว\r\n\r\nมีสามแบบ\r\n: ดาว : หัวใจ : ดอกไม้\r\n\r\nข้างในเป็นดอกไม้แห้งธรรมชาติ ดอกไม้ไม่เหี่ยว เก๋ไก๋ ใส่ได้กับทุกชุด',200,'https://i.imgur.com/A5WoqNx.jpg',1),(3,'เซทกำไลข้อมือไม้ handmade 2 ชิ้น','เซทกำไลข้อมือไม้ handmade\r\nกำไลไม้ + กำไลโหลแก้วจิ๋ว\r\nสามารถเลือกดอกไม้ได้',200,'https://i.imgur.com/xX5SmvN.jpg',4),(4,'สร้อยคอโหลแก้วจิ๋ว','สร้อยคอโหลแก้วจิ๋ว\r\n- ข้างในเป็นขนแกะ สามารถเลือกสีผสมสีเองได้',120,'https://i.imgur.com/XHL8tdE.jpg',1),(5,'สร้อยคอโหลแก้วจิ๋ว เซ็ท 2','สร้อยคอโหลแก้วจิ๋ว - ข้างในเป็นดอกหญ้าแห้งธรรมชาติ ดอกไม้ไม่เหี่ยว',120,'https://i.imgur.com/CiYryCE.jpg',1),(6,'สร้อยไม้ handmade','สร้อยไม้ handmade พร้อมส่ง',150,'https://i.imgur.com/sp2Ha8k.jpg',1),(7,'กำไลข้อมือไม้ handmade','กำไลข้อมือไม้ handmade - ข้างในเป็นดอกไม้ต่างๆ',150,'https://i.imgur.com/HUqY5Vk.jpg',4),(8,'สร้อยคอโหลแก้วจิ๋ว ดอกยิปโซ','สร้อยคอโหลแก้วจิ๋ว - ข้างในเป็นดอกยิปโซ ความหมาย : สื่อถึงความบริสุทธิ์ จริงใจ อ่อนหวาน เป็นดอกไม้แห่งรักแรก',120,'https://i.imgur.com/poUUKZq.jpg',1),(9,'แหวนไม้ handmade','แหวนไม้ handmade ข้างในเป็นดอกไม้แห้งธรรมชาติ ไม่เหี่ยว เข้ากับธรรมชาติ มี 2 สี : สีธรรมชาติ(สีไม้) สีดำ',100,'https://i.imgur.com/78pdlIv.jpg',2),(10,'เข็มกลัดไม้ Handmade','เข็มกลัดไม้ handmade ข้างในเป็นดอกไม้แห้งธรรมชาติ ไม่เหี่ยว เข้ากับธรรมชาติ มี 2 สี : สีธรรมชาติ(สีไม้) สีดำ  น่ารัก เก๋ๆ ติดได้ทั้งเสื้อ กระเป๋า หมวก รีบจับจองกันเลย',129,'https://i.imgur.com/OMc0DXZ.jpg',3);
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
  `member_cus_id` int(11) NOT NULL,
  PRIMARY KEY (`add_id`,`member_cus_id`),
  KEY `member_cus_id_idx` (`member_cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'กรุงเทพ','บางกะปิ','102','ถนนลาดพร้าว','คลองจั่น','10240',1),(2,'กรุงเทพ','บางกะปิ','506','ถนนลาดพร้าว','คลองจั่น','10240',1),(3,'กรุงเทพ','มักกะสัน','405','ถนนเพชรบุรีตัดใหม่','ราชเทวี','10400',3),(4,'ปทุมธานี','เมืองปทุมธานี','608','-','บ้านกลาง','12000',2),(5,'ฉะเชิงเทรา','บางปะกง','51','-','บางปะกง','24130',4),(6,'กรุงเทพ','บางแค','605/265','ถ.เพชรเกษม','บางแคเหนือ','10160',5),(7,'กรุงเทพ','บางแค','621/203','ถ.เพชรเกษม','บางแคเหนือ','10160',5),(8,'กรุงเทพ','บางหว้า','203','ถ.เพชรเกษม','ภาษีเจริญ','10160',6),(9,'ปทุมธานี ','พืชอุดม','10','-','ลำลูกกา','12150',7),(10,'บุรีรัมย์','สะเดา','35','-','พลับพลาชัย','31250',8);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'สร้อยคอ'),(2,'แหวน'),(3,'เข็มกลัด'),(4,'กำไลข้อมือ');
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
INSERT INTO `customer` VALUES (1,'alicia@gmail.com','Alice','mem'),(2,'alyssa@hotmail.com','Alyssa','mem'),(3,'aki123@gmail.com','Akira ','mem'),(4,'bonnie@gmail.com','Bonita ','mem'),(5,'gzchrise@gmail.com','Chris','mem'),(6,'danny@hotmail.com','Dan ','mem'),(7,'derekkk@hotmail.com','Derek ','mem'),(8,'jadey@hotmail.com','Jade','mem'),(9,'johnny@gmail.com','John ','mem'),(10,'jake124@gmail.com','Jake','mem'),(11,'kenttis@hotmail.com','Kent','non'),(20,'clair25@hotmail.com','Claris','non'),(21,'ploycute@hotmail.com','ploy','non'),(22,'ploywince@gmail.com','ploy','non'),(23,'alissa14@gmail.com','Alissa','non'),(24,'dgdg','dsf','non'),(25,'hfghf','fghfg','non'),(26,'fgf','gfh','non'),(27,'hjkh',';jlhj','non'),(28,'fhf','ghfgh','non'),(29,'ere','etet','non');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliverie`
--

DROP TABLE IF EXISTS `deliverie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliverie` (
  `type` enum('ems','normal','register') NOT NULL,
  `send_date` date NOT NULL,
  `tracking_number` char(13) DEFAULT NULL,
  `order_order_id` int(11) NOT NULL,
  PRIMARY KEY (`order_order_id`),
  CONSTRAINT `deliverie_order_order_id` FOREIGN KEY (`order_order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliverie`
--

LOCK TABLES `deliverie` WRITE;
/*!40000 ALTER TABLE `deliverie` DISABLE KEYS */;
INSERT INTO `deliverie` VALUES ('ems','2017-12-31','1234567890123',1),('normal','2012-12-30','165161611',2);
/*!40000 ALTER TABLE `deliverie` ENABLE KEYS */;
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
INSERT INTO `employee` VALUES (1,'Aileen','Ail','Ail123','order'),(2,'Alisha ','Aisha','aisha54','order'),(3,'Benjamin','Benj','ben546','order'),(4,'Chana','chan','cha145','order'),(5,'Chandra','Moon','moon112','order'),(6,'Davin','Dev','devvv','order'),(7,'Finn','Fione','finn578','order'),(8,'Gavin','grape','guine45','order'),(9,'Harley','Haley','hi365','send'),(10,'Ira','ira','ira310','send');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_order`
--

DROP TABLE IF EXISTS `employee_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_order` (
  `date` date NOT NULL,
  `what_do` text NOT NULL,
  `emp_emp_id` int(11) NOT NULL,
  `order_order_id` int(11) NOT NULL,
  PRIMARY KEY (`emp_emp_id`,`order_order_id`),
  KEY `employee_order_id_idx` (`order_order_id`),
  CONSTRAINT `employee_emp_id` FOREIGN KEY (`emp_emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `employee_order_id` FOREIGN KEY (`order_order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_order`
--

LOCK TABLES `employee_order` WRITE;
/*!40000 ALTER TABLE `employee_order` DISABLE KEYS */;
INSERT INTO `employee_order` VALUES ('2018-04-28','Change order 1 status from wait_verify to verify_pass',3,1);
/*!40000 ALTER TABLE `employee_order` ENABLE KEYS */;
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
INSERT INTO `member` VALUES (1,'Alicia','alice123',0),(2,'alyse','lovely12',50),(3,'aki125','akiaki1',79),(4,'bonnie','rabbit50',3),(5,'chrissi','god32',20),(6,'Dannn','dannyja55',55),(7,'Derk','derv12',0),(8,'jedzzz','jedzy1',2),(9,'johnson','johnny89',200),(10,'jake','cherry23',7);
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'2018-04-28 12:26:09','verify_pass',NULL,NULL,1000.00,'102/103 ถ.เพชรบุรีตัดใหม่ มักกะสัน ราชเทวี กรุงเทพฯ 10400',20),(2,'2018-04-21 18:59:32','wait_verify',NULL,NULL,840.00,'503 ถนนลาดพร้าว บางกะปิ คลองจั่น กรุงเทพมหานคร 10240',21),(3,'2018-04-21 19:06:07','wait_verify',NULL,NULL,940.00,'503 ถนนลาดพร้าว บางกะปิ คลองจั่น  กรุงเทพมหานคร 10240',22),(4,'2018-04-21 19:23:32','wait_verify',0,25,258.00,'506 ถนนลาดพร้าว คลองจั่น บางกะปิ กรุงเทพ 10240',1),(5,'2018-04-21 19:23:32','wait_verify',0,84,840.00,'10 ลำลูกกา พืชอุดม ปทุมธานี 12150',7),(6,'2018-04-21 19:25:40','wait_verify',1,10,99.00,'405 ถนนเพชรบุรีตัดใหม่ ราชเทวี มักกะสัน กรุงเทพ 10400',3),(7,'2018-04-21 19:26:42','wait_verify',45,24,195.00,'405 ถนนเพชรบุรีตัดใหม่ ราชเทวี มักกะสัน กรุงเทพ 10400',3),(8,'2018-04-21 19:29:03','wait_verify',4,39,386.00,'405 ถนนเพชรบุรีตัดใหม่ ราชเทวี มักกะสัน กรุงเทพ 10400',3),(9,'2018-04-21 19:30:41','wait_verify',NULL,NULL,600.00,'412 ถ.เพชรเกษม ภาษีเจริญ บางหว้า กรุงเทพมหานคร 10160',23),(10,'2018-04-21 19:31:54','wait_verify',10,120,1190.00,'35 - พลับพลาชัย สะเดา บุรีรัมย์ 31250',8),(11,'2018-04-27 15:41:39','wait_verify',5,52,515.00,'405 ถนนเพชรบุรีตัดใหม่ ราชเทวี มักกะสัน กรุงเทพ 10400',3),(12,'2018-04-28 14:07:47','wait_verify',NULL,NULL,200.00,'dgdg fhfg hgdgd vdg wrwe 12142',24),(18,'2018-04-28 14:21:08','wait_verify',NULL,NULL,600.00,'hkhk jhjkh khjj jkhjkhj kkh gfghf',27),(19,'2018-04-28 14:23:40','wait_verify',NULL,NULL,600.00,'hkhk jhjkh khjj jkhjkhj kkh gfghf',27),(20,'2018-04-28 14:24:11','wait_verify',NULL,NULL,600.00,'hkhk jhjkh khjj jkhjkhj kkh gfghf',27),(21,'2018-04-28 14:26:18','wait_verify',NULL,NULL,600.00,'hkhk jhjkh khjj jkhjkhj kkh gfghf',27),(22,'2018-04-28 14:27:42','wait_verify',NULL,NULL,600.00,'hkhk jhjkh khjj jkhjkhj kkh gfghf',27),(23,'2018-04-28 14:27:58','wait_verify',NULL,NULL,600.00,'hkhk jhjkh khjj jkhjkhj kkh gfghf',27),(24,'2018-04-28 14:28:26','wait_verify',NULL,NULL,600.00,'hkhk jhjkh khjj jkhjkhj kkh gfghf',27),(25,'2018-04-28 14:49:44','wait_verify',NULL,NULL,516.00,'hfh g ghfghf fghfhgf ghfgh ghfghf',28),(26,'2018-04-28 15:02:07','verify_pass',NULL,NULL,350.00,'trerte rtetert ertet eter tert eterte',29);
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
INSERT INTO `order_item` VALUES (100,1,1,1,3),(100,1,1,1,6),(200,5,2,1,1),(200,2,2,1,13),(200,2,2,1,14),(200,2,2,1,15),(200,2,2,1,16),(200,2,2,1,17),(200,1,2,1,26),(200,3,3,1,2),(200,2,3,1,11),(200,1,3,1,12),(200,3,3,2,3),(120,7,4,1,5),(120,1,4,1,8),(120,5,4,1,18),(120,5,4,1,19),(120,5,4,1,20),(120,5,4,1,21),(120,5,4,1,22),(120,5,4,1,23),(120,5,4,1,24),(120,2,4,2,2),(120,2,4,3,3),(120,1,5,2,8),(120,1,5,2,11),(150,1,6,3,8),(150,1,7,1,26),(120,2,8,1,7),(120,5,8,1,9),(100,12,9,1,10),(129,2,10,1,4),(129,4,10,1,25);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'2018-04-28 15:02:08',350,'credit',' ',26);
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

-- Dump completed on 2018-04-28 15:15:50
