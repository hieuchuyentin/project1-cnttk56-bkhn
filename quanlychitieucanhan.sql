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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowing`
--

LOCK TABLES `borrowing` WRITE;
/*!40000 ALTER TABLE `borrowing` DISABLE KEYS */;
INSERT INTO `borrowing` VALUES (3,1,5,'2007-02-03','2010-02-12','bb',1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exporting`
--

LOCK TABLES `exporting` WRITE;
/*!40000 ALTER TABLE `exporting` DISABLE KEYS */;
INSERT INTO `exporting` VALUES (1,'2013-12-01',124,'2121',NULL,1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `importing`
--

LOCK TABLES `importing` WRITE;
/*!40000 ALTER TABLE `importing` DISABLE KEYS */;
INSERT INTO `importing` VALUES (6,'2013-03-23',12,NULL,1,2),(7,'2013-03-24',13,NULL,1,1),(9,'2013-03-23',16,'123',1,3),(10,'2013-11-18',121,'12',2,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (4,1,2,1,2);
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
INSERT INTO `user` VALUES (1,'hien','hien',1,'Đỗ Đăng Hiển','2008-10-06',20),(2,'hieu','hieu',1,'Lê Trung Hiếu','1993-04-20',20);
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

-- Dump completed on 2013-11-18 20:19:27
