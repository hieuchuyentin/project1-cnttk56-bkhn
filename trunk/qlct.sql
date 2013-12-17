CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `borrow_lend_type`
--

DROP TABLE IF EXISTS `borrow_lend_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow_lend_type` (
  `id` int(11) NOT NULL,
  `cycle` int(11) DEFAULT NULL COMMENT 'Chu kỳ lãi suất',
  `type` tinyint(1) NOT NULL COMMENT '(0) : Lãi mẹ đẻ lãi con \n(1) : Lãi xuất từ số tiền ban đầu',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_lend_type`
--

LOCK TABLES `borrow_lend_type` WRITE;
/*!40000 ALTER TABLE `borrow_lend_type` DISABLE KEYS */;
INSERT INTO `borrow_lend_type` VALUES (1,1,1);
/*!40000 ALTER TABLE `borrow_lend_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `export_type`
--

DROP TABLE IF EXISTS `export_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `export_type` (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `export_type`
--

LOCK TABLES `export_type` WRITE;
/*!40000 ALTER TABLE `export_type` DISABLE KEYS */;
INSERT INTO `export_type` VALUES (1,'Ăn uống'),(2,'Giải trí'),(3,'Du lịch'),(4,'Giáo dục'),(5,'Di chuyển'),(6,'Bạn bè & tình yêu'),(7,'Gia đình'),(8,'Sức khỏe'),(9,'Mua sắm'),(10,'Đầu tư'),(11,'Khác');
/*!40000 ALTER TABLE `export_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exporting`
--

DROP TABLE IF EXISTS `exporting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exporting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `value` int(11) NOT NULL,
  `project_id` int(11) DEFAULT '0',
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT ' ',
  `user_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `info` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `share` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`,`user_id`,`category_id`),
  KEY `fk_exporting_user1_idx` (`user_id`),
  KEY `fk_exporting_export_type1_idx` (`category_id`),
  CONSTRAINT `fk_exporting_export_type1` FOREIGN KEY (`category_id`) REFERENCES `export_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_exporting_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exporting`
--

LOCK TABLES `exporting` WRITE;
/*!40000 ALTER TABLE `exporting` DISABLE KEYS */;
INSERT INTO `exporting` VALUES (1,'2013-12-25',124,NULL,'nhậu',1,1,NULL,NULL),(2,'2013-11-12',50,NULL,'Choi GamE',1,2,NULL,NULL),(3,'2013-10-12',600,NULL,'Di bien ha long',1,3,NULL,NULL),(4,'2013-09-05',200,NULL,'Mua sach Lap Trinh',1,4,NULL,NULL),(5,'2013-08-05',50,NULL,'Do xang xe may',1,5,NULL,NULL),(6,'2013-03-08',120,NULL,'Mua hoa tang nguoi yeu',1,6,NULL,NULL),(7,'2013-05-06',240,NULL,'Mua den treo phong',1,7,NULL,NULL),(8,'2013-06-06',360,NULL,'Di kham suc khoe dinh ky',1,8,NULL,NULL),(9,'2013-12-06',830,NULL,'Mua ram Laptop 4gb Kingtom',1,9,NULL,NULL),(10,'2013-07-06',20,NULL,'Mua suat com trua',2,1,NULL,NULL),(11,'2013-07-06',60,NULL,'Choi xo so',2,2,NULL,NULL),(12,'2013-07-06',60,NULL,'Dap xe ve que',2,3,NULL,NULL),(13,'2013-07-06',14000,NULL,'Mua LapTop',2,9,NULL,NULL),(14,'2013-09-05',240,NULL,'Mua Sach giao trinh',2,4,NULL,NULL),(15,'2013-11-20',50,NULL,'Dua nguoi yeu di dao pho',2,5,NULL,NULL),(16,'2013-11-20',10,NULL,'Mua keo mut cho nguoi yeu',2,6,NULL,NULL),(17,'2012-04-09',10,NULL,'An bat xoi sang',3,1,NULL,NULL),(18,'2013-11-09',50,NULL,'',3,2,NULL,NULL),(19,'2013-11-09',10000,NULL,'Di sang USA',3,3,NULL,NULL),(20,'2013-12-09',50,NULL,'Mua slide',3,4,NULL,NULL),(21,'2013-11-10',5,NULL,'Di xe buyt',3,5,NULL,NULL),(22,'2013-12-10',100,NULL,'Mua bupbe  tang nguoi yeu',3,6,NULL,NULL),(23,'2013-09-10',200,NULL,'Mua chieu',3,7,NULL,NULL),(46,'2013-07-06',14000,NULL,'Mua LapTop',1,9,NULL,NULL),(50,'2013-09-04',1300,NULL,'học tiếng anh',1,4,NULL,NULL),(51,'2013-01-04',50,NULL,'Qùa cho em',1,7,NULL,NULL),(52,'2013-02-04',25,NULL,'Sách ',1,4,NULL,NULL),(53,'2013-02-04',100,NULL,'Xăng',1,5,NULL,NULL),(54,'2013-02-04',220,NULL,'Khám sức khỏe',1,8,NULL,NULL),(55,'2013-03-24',3200,NULL,'Mua hàng dự trữ',1,10,NULL,NULL),(56,'2013-03-20',300,NULL,'Quà tặng bạn gái',1,6,NULL,NULL),(57,'2013-03-02',431,NULL,'Quần áo',1,9,NULL,NULL),(59,'2013-04-27',24,NULL,'Đi chợ',1,7,NULL,NULL),(60,'2013-04-25',95,NULL,'kfc',1,1,NULL,NULL),(61,'2013-04-30',205,NULL,'xem phim',1,2,NULL,NULL),(62,'2013-05-30',5,NULL,'xe buyt',1,5,NULL,NULL),(63,'2013-05-04',46,NULL,'mua thuoc',1,8,NULL,NULL),(64,'2013-05-08',20,NULL,'mua tài liệu',1,4,NULL,NULL),(65,'2013-06-19',25,NULL,'mua tài liệu',1,4,NULL,NULL),(66,'2013-06-11',500,NULL,'mua quạt',1,9,NULL,NULL),(67,'2013-08-03',65,NULL,'áo mới',1,9,NULL,NULL),(68,'2013-01-04',20,NULL,'bút viết',1,9,NULL,NULL),(69,'2013-09-30',1000,NULL,'Đi Đồ Sơn',1,3,NULL,NULL),(70,'2013-09-22',100,NULL,'Mua quà cho bạn gái',1,6,NULL,NULL),(71,'2013-02-22',450,NULL,'tien an thang',1,1,NULL,NULL),(72,'2013-06-22',430,NULL,'tien an thang',1,1,NULL,NULL),(73,'2013-10-22',540,NULL,'tien an thang',1,1,NULL,NULL),(74,'2013-08-22',500,NULL,'tien an thang',1,1,NULL,NULL),(75,'2013-04-22',430,NULL,'tien an thang',1,1,NULL,NULL),(76,'2013-09-22',500,NULL,'tien an thang',1,1,NULL,NULL),(77,'2013-05-22',300,NULL,'tien an thang',1,1,NULL,NULL),(78,'2013-11-22',620,NULL,'tien an thang',1,1,NULL,NULL),(79,'2013-06-22',500,NULL,'tien an thang',1,1,NULL,NULL),(80,'2013-10-22',500,NULL,'tien an thang',1,1,NULL,NULL),(81,'2013-10-22',500,NULL,'tien an thang',1,1,NULL,NULL),(82,'2013-01-22',350,NULL,'tien an thang',1,1,NULL,NULL),(83,'2013-01-22',350,NULL,'tien an thang',1,1,NULL,NULL),(84,'2013-03-22',350,NULL,'tien an thang',1,1,NULL,NULL),(85,'2013-03-22',350,NULL,'xem ca nhac',1,2,NULL,NULL),(86,'2013-09-05',240,NULL,'Mua Sach giao trinh',1,4,NULL,NULL),(87,'2013-12-04',120,NULL,'ghi chu',1,1,NULL,NULL);
/*!40000 ALTER TABLE `exporting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_type`
--

DROP TABLE IF EXISTS `import_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `import_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_type`
--

LOCK TABLES `import_type` WRITE;
/*!40000 ALTER TABLE `import_type` DISABLE KEYS */;
INSERT INTO `import_type` VALUES (1,'Lương'),(2,'Thưởng'),(3,'Bán đồ'),(4,'Được tặng'),(5,'Tiền lãi'),(6,'Khác');
/*!40000 ALTER TABLE `import_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `importing`
--

DROP TABLE IF EXISTS `importing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `importing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `value` int(11) NOT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT ' ',
  `user_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `project_id` int(11) DEFAULT '0',
  `info` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `share` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`,`user_id`,`category_id`),
  KEY `fk_importing_user_idx` (`user_id`),
  KEY `fk_importing_import_type1_idx` (`category_id`),
  CONSTRAINT `fk_importing_import_type1` FOREIGN KEY (`category_id`) REFERENCES `import_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_importing_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `importing`
--

LOCK TABLES `importing` WRITE;
/*!40000 ALTER TABLE `importing` DISABLE KEYS */;
INSERT INTO `importing` VALUES (1,'2013-03-23',15,'khong note',1,2,0,NULL,NULL),(2,'2013-03-24',14,'',3,1,0,NULL,NULL),(3,'2013-03-23',16,'123',2,3,0,NULL,NULL),(4,'2013-12-24',121,'giáng sinh',2,2,0,NULL,NULL),(5,'2013-11-25',501,'ban het tat ca moi thu,hien',1,1,0,NULL,NULL),(6,'2013-11-12',1000,'Ban Giay Dep',1,5,0,NULL,NULL),(7,'2012-03-09',6000,'Ban phan mem',3,5,0,NULL,NULL),(8,'2012-02-09',200,'Tien mung tuoi',3,4,0,NULL,NULL),(9,'2012-04-02',40,'Ban sach cu',3,3,0,NULL,NULL),(11,'2013-11-11',500,'',1,4,0,NULL,NULL),(12,'2012-12-03',670,'',2,1,0,NULL,NULL),(13,'2012-11-13',102,'no notE',1,1,0,NULL,NULL),(14,'2013-11-26',9,'note',1,1,0,NULL,NULL),(20,'2013-01-06',50,'Ban may tinh cu',2,3,0,NULL,NULL),(21,'2013-01-06',2000,'Hoc bong',2,4,0,NULL,NULL),(22,'2013-02-06',10,'ko biet',2,5,0,NULL,NULL),(23,'2013-02-06',10,'ko biet',2,5,0,NULL,NULL),(24,'2013-02-06',10,'ko biet',2,5,0,NULL,NULL),(25,'2012-12-03',5000,'Nhan luong thang dau tien',3,1,0,NULL,NULL),(26,'2012-11-03',2,'Nhat duoc cua roi tra lai nguoi mat',3,2,0,NULL,NULL),(30,'2013-11-30',2000,'lam thue',1,1,0,NULL,NULL),(31,'2013-03-17',0,'',1,1,0,NULL,NULL),(32,'2013-01-17',0,'',1,1,0,NULL,NULL),(33,'2013-01-17',1000,'Tiền dự án 1',1,1,0,NULL,NULL),(34,'2013-01-17',0,'',1,1,0,NULL,NULL),(35,'2013-01-17',0,'',1,1,0,NULL,NULL),(36,'2013-01-17',0,'',1,1,0,NULL,NULL),(37,'2013-01-17',0,'',1,1,0,NULL,NULL),(40,'2013-02-15',2220,'Tăng lương',1,1,0,NULL,NULL),(41,'2013-01-17',0,'',1,1,0,NULL,NULL),(42,'2013-01-17',0,'',1,1,0,NULL,NULL),(43,'2013-01-17',0,'',1,1,0,NULL,NULL),(44,'2013-01-15',122,'học bổng',2,2,0,NULL,NULL),(45,'2012-12-24',112,'giáng sinh',2,2,0,NULL,NULL),(46,'2013-06-23',1500,'sổ xố',2,2,0,NULL,NULL),(47,'2013-08-06',224,'Ban phan mem',2,3,0,NULL,NULL),(48,'2013-09-16',350,'Bán phần mềm',2,3,0,NULL,NULL),(49,'2013-03-23',224,'Sinh nhật',2,4,0,NULL,NULL),(50,'2013-07-08',100,'Chị gái đi làm',2,4,0,NULL,NULL),(51,'2012-01-01',100,'Mừng tuổi',2,4,0,NULL,NULL),(52,'2012-01-01',250,'Bố cho',2,4,0,NULL,NULL),(53,'2012-05-09',1000,'',2,4,0,NULL,NULL),(54,'2012-07-08',100,'',2,4,0,NULL,NULL),(55,'2012-05-09',700,'',2,4,0,NULL,NULL),(56,'2012-09-05',10,'',2,4,0,NULL,NULL),(57,'2012-05-09',20,'',2,4,0,NULL,NULL),(58,'2012-09-05',10,'',2,1,0,NULL,NULL),(59,'2012-04-05',560,'',2,1,0,NULL,NULL),(60,'2012-09-05',10,'',2,1,0,NULL,NULL),(61,'2012-09-05',1032,'',2,1,0,NULL,NULL),(62,'2012-03-06',450,'',2,1,0,NULL,NULL),(63,'2012-08-05',1000,'',2,1,0,NULL,NULL),(64,'2012-11-04',753,'',2,1,0,NULL,NULL),(65,'2012-09-05',10,'',2,1,0,NULL,NULL),(66,'2012-01-05',1440,'',2,1,0,NULL,NULL),(67,'2012-09-05',10,'',2,1,0,NULL,NULL),(68,'2012-10-06',1500,'',2,1,0,NULL,NULL),(69,'2012-09-05',10,'',2,1,0,NULL,NULL),(70,'2012-07-05',800,'',2,1,0,NULL,NULL),(71,'2013-12-13',132,'ko co gi',1,1,0,NULL,NULL),(72,'2013-02-15',220,'Tăng lương',1,1,0,NULL,NULL);
/*!40000 ALTER TABLE `importing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `present_id`
--

DROP TABLE IF EXISTS `present_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `present_id` (
  `user` int(11) NOT NULL,
  `project` int(11) DEFAULT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `present_id`
--

LOCK TABLES `present_id` WRITE;
/*!40000 ALTER TABLE `present_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `present_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_id` int(11) NOT NULL COMMENT 'Id người tác động',
  `to_id` int(11) NOT NULL COMMENT 'Id người bị tác động',
  `type_id` int(11) NOT NULL COMMENT 'Loại nguồn tác động lên ( imprort, export, lend , borrow)',
  `subType_id` int(11) DEFAULT NULL COMMENT 'loại nguồn tác động con ( chi tiêu, ăn uống....)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (37,1,2,1,4),(38,1,2,4,0),(50,3,2,1,1),(51,3,2,1,5),(52,3,2,2,1),(53,3,2,2,2),(54,3,2,2,5),(55,3,1,1,1),(56,3,1,1,4),(57,3,1,2,4),(58,3,1,2,6),(59,3,1,2,8),(60,2,1,1,1),(61,2,1,1,2),(62,2,1,1,3),(63,2,1,1,4),(64,2,1,2,1),(65,2,1,2,2),(66,2,1,2,3),(67,2,1,2,4),(68,2,1,2,5),(69,2,1,2,6);
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `sub_type_id` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `start_day` date DEFAULT NULL,
  `end_day` date DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  `info` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stateid_idx` (`state_id`),
  KEY `owner_id_idx` (`owner_id`),
  CONSTRAINT `owner_id` FOREIGN KEY (`owner_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `stateid` FOREIGN KEY (`state_id`) REFERENCES `state_project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_contribute`
--

DROP TABLE IF EXISTS `project_contribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_contribute` (
  `project_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `contribute` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  PRIMARY KEY (`project_id`,`user_id`),
  CONSTRAINT `projectid-id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_contribute`
--

LOCK TABLES `project_contribute` WRITE;
/*!40000 ALTER TABLE `project_contribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_contribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `share`
--

DROP TABLE IF EXISTS `share`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `share` (
  `transaction_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`transaction_id`,`type_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `share`
--

LOCK TABLES `share` WRITE;
/*!40000 ALTER TABLE `share` DISABLE KEYS */;
INSERT INTO `share` VALUES (1,1,1),(1,1,2),(2,1,1),(2,1,3),(3,1,2),(3,1,3),(4,1,1),(4,1,2),(4,1,3),(5,1,1),(5,1,2),(5,1,3),(6,1,1),(6,1,2),(7,1,1),(7,1,3),(8,1,1),(8,1,2),(8,1,3);
/*!40000 ALTER TABLE `share` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_project`
--

DROP TABLE IF EXISTS `state_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_project`
--

LOCK TABLES `state_project` WRITE;
/*!40000 ALTER TABLE `state_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `state_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `passWord` varchar(45) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL COMMENT '(0) : female\n(1) : male',
  `birthDay` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hien','hien',1,'2008-10-06','20',NULL),(2,'hieu','hieu',1,'1993-04-20','20',NULL),(3,'dai','dai',1,'1993-01-14','20',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-15 23:32:30
