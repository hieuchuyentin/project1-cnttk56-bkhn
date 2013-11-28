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
-- Table structure for table `borrowing`
--

DROP TABLE IF EXISTS `borrowing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrowing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(11) DEFAULT NULL,
  `interestRate` int(11) DEFAULT NULL,
  `dateBorrow` date DEFAULT NULL,
  `expiryDate` date DEFAULT NULL,
  `infoLender` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `borrow_lend_type_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`borrow_lend_type_id`,`user_id`),
  KEY `fk_borrowing_borrow_lend_type1_idx` (`borrow_lend_type_id`),
  KEY `fk_borrowing_user1_idx` (`user_id`),
  CONSTRAINT `fk_borrowing_borrow_lend_type1` FOREIGN KEY (`borrow_lend_type_id`) REFERENCES `borrow_lend_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_borrowing_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowing`
--

LOCK TABLES `borrowing` WRITE;
/*!40000 ALTER TABLE `borrowing` DISABLE KEYS */;
INSERT INTO `borrowing` VALUES (3,1,5,'2007-02-03','2010-02-12','bb',1,1),(5,1,5,'2007-02-03','2010-02-12','bb',1,1),(6,1,5,'2007-02-03','2010-02-12','bb',1,1);
/*!40000 ALTER TABLE `borrowing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `export_type`
--

DROP TABLE IF EXISTS `export_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `export_type` (
  `id` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  `image` varchar(400) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `export_type`
--

LOCK TABLES `export_type` WRITE;
/*!40000 ALTER TABLE `export_type` DISABLE KEYS */;
INSERT INTO `export_type` VALUES (1,'Ăn uống',NULL),(2,'Giải trí',NULL),(3,'Du lịch',NULL),(4,'Giáo dục',NULL),(5,'Di chuyển',NULL),(6,'Bạn bè & tình yêu',NULL),(7,'Gia đình',NULL),(8,'Sức khỏe',NULL),(9,'Mua sắm',NULL),(10,'Đầu tư',NULL),(11,'Khác',NULL);
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
  `note` varchar(200) DEFAULT ' ',
  `idChung` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `export_type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`user_id`,`export_type_id`),
  KEY `fk_exporting_user1_idx` (`user_id`),
  KEY `fk_exporting_export_type1_idx` (`export_type_id`),
  CONSTRAINT `fk_exporting_export_type1` FOREIGN KEY (`export_type_id`) REFERENCES `export_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_exporting_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exporting`
--

LOCK TABLES `exporting` WRITE;
/*!40000 ALTER TABLE `exporting` DISABLE KEYS */;
INSERT INTO `exporting` VALUES (1,'2013-12-01',124,'2121',NULL,1,1),(2,'2013-11-12',50,'Choi GamE',NULL,1,2),(3,'2013-10-12',600,'Di bien ha long',NULL,1,3),(4,'2013-09-05',200,'Mua sach Lap Trinh',NULL,1,4),(5,'2013-08-05',50,'Do xang xe may',NULL,1,5),(6,'2013-03-08',120,'Mua hoa tang nguoi yeu',NULL,1,6),(7,'2013-05-06',240,'Mua den treo phong',NULL,1,7),(8,'2013-06-06',360,'Di kham suc khoe dinh ky',NULL,1,8),(9,'2013-12-06',830,'Mua ram Laptop 4gb Kingtom',NULL,1,9),(10,'2013-07-06',20,'Mua suat com trua',NULL,2,1),(11,'2013-07-06',60,'Choi xo so',NULL,2,2),(12,'2013-07-06',60,'Dap xe ve que',NULL,2,3),(13,'2013-07-06',14000,'Mua LapTop',NULL,2,9),(14,'2013-09-05',240,'Mua Sach giao trinh',NULL,2,4),(15,'2013-11-20',50,'Dua nguoi yeu di dao pho',NULL,2,5),(16,'2013-11-20',10,'Mua keo mut cho nguoi yeu',NULL,2,6),(17,'2012-04-09',10,'An bat xoi sang',NULL,3,1),(18,'2013-11-09',50,'',NULL,3,2),(19,'2013-11-09',10000,'Di sang USA',NULL,3,3),(20,'2013-12-09',50,'Mua slide',NULL,3,4),(21,'2013-11-10',5,'Di xe buyt',NULL,3,5),(22,'2013-12-10',100,'Mua bupbe  tang nguoi yeu',NULL,3,6),(23,'2013-09-10',200,'Mua chieu',NULL,3,7);
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
  `type` varchar(45) DEFAULT NULL,
  `image` varchar(400) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_type`
--

LOCK TABLES `import_type` WRITE;
/*!40000 ALTER TABLE `import_type` DISABLE KEYS */;
INSERT INTO `import_type` VALUES (1,'Lương',NULL),(2,'Thưởng',NULL),(3,'Bán đồ',NULL),(4,'Được tặng',NULL),(5,'Tiền lãi',NULL),(6,'Khác',NULL);
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
  `note` varchar(200) DEFAULT ' ',
  `user_id` int(11) NOT NULL,
  `import_type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`user_id`,`import_type_id`),
  KEY `fk_importing_user_idx` (`user_id`),
  KEY `fk_importing_import_type1_idx` (`import_type_id`),
  CONSTRAINT `fk_importing_import_type1` FOREIGN KEY (`import_type_id`) REFERENCES `import_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_importing_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `importing`
--

LOCK TABLES `importing` WRITE;
/*!40000 ALTER TABLE `importing` DISABLE KEYS */;
INSERT INTO `importing` VALUES (6,'2013-03-23',15,'khong note',1,2),(7,'2013-03-24',13,NULL,1,1),(9,'2013-03-23',16,'123',1,3),(10,'2013-11-18',121,'12',2,2),(12,'2013-11-25',501,'ban het tat ca moi thu,hien',1,1),(13,'2013-11-26',9,'note',1,1),(15,'2012-11-13',102,'no notE',1,1),(17,'2012-12-03',67,'hi',2,1),(18,'2013-11-11',500,'',1,4),(19,'2013-11-12',1000,'Ban Giay Dep',1,5),(20,'2013-01-06',50,'Ban may tinh cu',2,3),(21,'2013-01-06',2000,'Hoc bong',2,4),(22,'2013-02-06',10,'ko biet',2,5),(23,'2013-02-06',10,'ko biet',2,5),(24,'2013-02-06',10,'ko biet',2,5),(25,'2012-12-03',5000,'Nhan luong thang dau tien',3,1),(26,'2012-11-03',2,'Nhat duoc cua roi tra lai nguoi mat',3,2),(27,'2012-04-02',40,'Ban sach cu',3,3),(28,'2012-02-09',200,'Tien mung tuoi',3,4),(29,'2012-03-09',6000,'Ban phan mem',3,5),(30,'2013-11-30',2000,'lam thue',1,1);
/*!40000 ALTER TABLE `importing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lending`
--

DROP TABLE IF EXISTS `lending`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lending` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(11) DEFAULT NULL,
  `interestRate` int(11) DEFAULT NULL,
  `dateLend` date DEFAULT NULL,
  `infoBorrower` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `expiryDate` date DEFAULT NULL,
  `borrow_lend_type_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`borrow_lend_type_id`,`user_id`),
  KEY `fk_lending_borrow_lend_type1_idx` (`borrow_lend_type_id`),
  KEY `fk_lending_user1_idx` (`user_id`),
  CONSTRAINT `fk_lending_borrow_lend_type1` FOREIGN KEY (`borrow_lend_type_id`) REFERENCES `borrow_lend_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lending_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lending`
--

LOCK TABLES `lending` WRITE;
/*!40000 ALTER TABLE `lending` DISABLE KEYS */;
/*!40000 ALTER TABLE `lending` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (36,1,1,1,4),(37,1,2,1,4),(38,1,2,4,0),(50,3,2,1,1),(51,3,2,1,5),(52,3,2,2,1),(53,3,2,2,2),(54,3,2,2,5),(55,3,1,1,1),(56,3,1,1,4),(57,3,1,2,4),(58,3,1,2,6),(59,3,1,2,8),(60,2,1,1,1),(61,2,1,1,2),(62,2,1,1,3),(63,2,1,1,4),(64,2,1,2,1),(65,2,1,2,2),(66,2,1,2,3),(67,2,1,2,4),(68,2,1,2,5),(69,2,1,2,6),(70,2,3,1,2),(71,2,3,1,4),(72,2,3,2,1),(73,2,3,2,2),(74,2,3,2,4),(75,2,3,2,6);
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
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
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Tên hiển thị',
  `birthDay` date DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hien','hien',1,'Đỗ Đăng Hiển','2008-10-06',20),(2,'hieu','hieu',1,'Lê Trung Hiếu','1993-04-20',20),(3,'dai','dai',1,'Phạm Văn Đại','1993-01-14',20);
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

-- Dump completed on 2013-11-28 19:07:05
