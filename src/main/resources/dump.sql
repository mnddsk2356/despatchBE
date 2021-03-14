-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: logistic
-- ------------------------------------------------------
-- Server version	5.7.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agreement`
--

DROP TABLE IF EXISTS `agreement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `agreement` (
  `id` int(11) NOT NULL,
  `agreement_end_dt` datetime DEFAULT NULL,
  `agreement_id` varchar(255) DEFAULT NULL,
  `agreement_st_dt` datetime DEFAULT NULL,
  `issuing_officer_id` int(11) NOT NULL,
  `trip_number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agreement`
--

LOCK TABLES `agreement` WRITE;
/*!40000 ALTER TABLE `agreement` DISABLE KEYS */;
/*!40000 ALTER TABLE `agreement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `analysis`
--

DROP TABLE IF EXISTS `analysis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `analysis` (
  `id` int(11) NOT NULL,
  `amount_paid` decimal(19,2) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `trips` int(11) NOT NULL,
  `year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analysis`
--

LOCK TABLES `analysis` WRITE;
/*!40000 ALTER TABLE `analysis` DISABLE KEYS */;
/*!40000 ALTER TABLE `analysis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit`
--

DROP TABLE IF EXISTS `audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `audit` (
  `audit_id` int(11) NOT NULL,
  `audit_event` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  `show_status` bit(1) NOT NULL,
  `time_created` datetime DEFAULT NULL,
  `time_updated` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`audit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit`
--

LOCK TABLES `audit` WRITE;
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
INSERT INTO `audit` VALUES (2,'Login Event for company','2021-03-01 16:07:45',NULL,_binary '\0','2021-03-01 16:07:45',NULL,1),(6,'Bid Created','2021-03-07 23:34:01',NULL,_binary '\0','2021-03-07 23:34:01',NULL,NULL),(7,'Bid Created','2021-03-07 23:35:25',NULL,_binary '\0','2021-03-07 23:35:25',NULL,NULL),(8,'Bid Created','2021-03-07 23:37:29',NULL,_binary '\0','2021-03-07 23:37:29',NULL,NULL),(9,'Bid Created','2021-03-07 23:38:51',NULL,_binary '\0','2021-03-07 23:38:51',NULL,NULL),(10,'Bid Created','2021-03-07 23:41:22',NULL,_binary '\0','2021-03-07 23:41:22',NULL,NULL),(11,'Bid Created','2021-03-08 11:00:41',NULL,_binary '\0','2021-03-08 11:00:41',NULL,NULL),(12,'Bid Created','2021-03-08 11:03:12',NULL,_binary '\0','2021-03-08 11:03:12',NULL,NULL),(13,'Bid Created','2021-03-08 11:37:34',NULL,_binary '\0','2021-03-08 11:37:34',NULL,NULL),(14,'Bid Created','2021-03-08 11:38:49',NULL,_binary '\0','2021-03-08 11:38:49',NULL,NULL),(18,'Bid Created','2021-03-08 15:31:58',NULL,_binary '\0','2021-03-08 15:31:58',NULL,NULL),(19,'Bid Created','2021-03-08 15:35:44',NULL,_binary '\0','2021-03-08 15:35:44',NULL,NULL),(24,'Login Event for company','2021-03-08 17:55:21',NULL,_binary '\0','2021-03-08 17:55:21',NULL,8),(25,'Bid Created','2021-03-08 17:57:05',NULL,_binary '\0','2021-03-08 17:57:05',NULL,NULL),(33,'Bid Created','2021-03-15 00:04:09',NULL,_binary '\0','2021-03-15 00:04:09',NULL,NULL),(34,'Bid Created ','2021-03-15 00:08:07',NULL,_binary '\0','2021-03-15 00:08:07',NULL,NULL),(35,'Bid Created ','2021-03-15 00:18:09',NULL,_binary '\0','2021-03-15 00:18:09',NULL,NULL),(36,'Bid Created ','2021-03-15 00:35:12',NULL,_binary '\0','2021-03-15 00:35:12',NULL,NULL),(37,'Bid Created ','2021-03-15 00:37:02',NULL,_binary '\0','2021-03-15 00:37:02',NULL,NULL);
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_details`
--

DROP TABLE IF EXISTS `bank_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bank_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_number` bigint(20) DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `ifsc_code` varchar(255) DEFAULT NULL,
  `micr_code` varchar(255) DEFAULT NULL,
  `pan_number` varchar(255) DEFAULT NULL,
  `audit_audit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlftpi1kxc6gryd9oo776rk6c2` (`audit_audit_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_details`
--

LOCK TABLES `bank_details` WRITE;
/*!40000 ALTER TABLE `bank_details` DISABLE KEYS */;
INSERT INTO `bank_details` VALUES (1,988988989,'current','Tech Towers,2nd Flr','HDFC Bank Ltd','HDFC86186','MICRCODE0080','AFE8787878UI',NULL);
/*!40000 ALTER TABLE `bank_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bid_master`
--

DROP TABLE IF EXISTS `bid_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bid_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid_close_date` datetime DEFAULT NULL,
  `bid_end_date` datetime DEFAULT NULL,
  `bid_start_date` datetime DEFAULT NULL,
  `contract_st_dt` datetime DEFAULT NULL,
  `contrcat_end_dt` datetime DEFAULT NULL,
  `ship_from` varchar(255) NOT NULL,
  `ship_to` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `target_price` decimal(19,2) DEFAULT NULL,
  `audit_audit_id` int(11) DEFAULT NULL,
  `bid_by_id` bigint(20) DEFAULT NULL,
  `drop_location` varchar(255) DEFAULT NULL,
  `is_drop_req` bit(1) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `ship_from_zone_id` int(11) NOT NULL,
  `ship_to_zone_id` int(11) NOT NULL,
  `trip_assigned` int(11) NOT NULL,
  `truck_type` int(11) NOT NULL,
  PRIMARY KEY (`id`,`ship_from`,`ship_to`),
  KEY `FK3fdsmpwifr8gxbkgcrlopiqkx` (`audit_audit_id`),
  KEY `FK72swetuifggh02xwya45xxqlm` (`bid_by_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bid_master`
--

LOCK TABLES `bid_master` WRITE;
/*!40000 ALTER TABLE `bid_master` DISABLE KEYS */;
INSERT INTO `bid_master` VALUES (6,'2021-03-14 05:30:00','2021-03-12 05:30:00','2021-03-07 05:30:00',NULL,NULL,'Delhi','Noida','Accepted',12000.00,11,1,'pune',_binary '\0',NULL,0,0,0,0),(8,'2021-03-06 05:30:00','2021-03-06 05:30:00','2021-03-02 05:30:00',NULL,NULL,'Delhi','Kolkata','',10000.00,14,1,NULL,_binary '\0',NULL,0,0,0,0),(10,'2021-03-14 05:30:00','2021-03-12 05:30:00','2021-03-07 05:30:00',NULL,NULL,'Delhi','Mumbai','',15000.00,19,1,'Goa',_binary '',NULL,0,0,0,0),(11,'2021-03-14 05:30:00','2021-03-12 05:30:00','2021-03-07 05:30:00',NULL,NULL,'Pune','Bhubaneswar','Accepted',12000.00,25,1,NULL,_binary '\0',NULL,0,0,0,0),(13,'2021-03-21 05:30:00','2021-03-20 05:30:00','2021-03-14 05:30:00','2021-04-07 05:30:00',NULL,'Pune','Bhubaneswar','',12000.00,34,1,NULL,_binary '\0',NULL,1,2,100,4),(14,'2021-03-21 05:30:00','2021-03-20 05:30:00','2021-03-14 05:30:00','2021-04-07 05:30:00',NULL,'Pune','Mumbai','Accepted',10000.00,35,1,NULL,_binary '\0',NULL,1,1,150,4),(15,'2021-03-21 05:30:00','2021-03-20 05:30:00','2021-03-15 05:30:00','2021-04-07 05:30:00',NULL,'Pune','Chennai','',10000.00,36,1,NULL,_binary '\0',NULL,1,2,300,5),(16,'2021-03-21 05:30:00','2021-03-20 05:30:00','2021-03-14 05:30:00','2021-04-07 05:30:00',NULL,'Pune','Chennai','',10000.00,37,1,NULL,_binary '\0',NULL,1,2,300,5);
/*!40000 ALTER TABLE `bid_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billing`
--

DROP TABLE IF EXISTS `billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `billing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `approved_amount` decimal(19,2) DEFAULT NULL,
  `billing_date` datetime DEFAULT NULL,
  `invoice_id` varchar(255) DEFAULT NULL,
  `approval_officer_id` bigint(20) DEFAULT NULL,
  `billing_officer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rk9duls39dql8pjork6l2ckbn` (`invoice_id`),
  KEY `FKn46k98qgexot9vye0lxqvyg6w` (`approval_officer_id`),
  KEY `FK9xcwo0vinf0xxtghu27jfwn6w` (`billing_officer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing`
--

LOCK TABLES `billing` WRITE;
/*!40000 ALTER TABLE `billing` DISABLE KEYS */;
/*!40000 ALTER TABLE `billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `branch` (
  `id` int(11) NOT NULL,
  `branch_location` varchar(255) DEFAULT NULL,
  `branch_name` varchar(255) DEFAULT NULL,
  `is_head_office` bit(1) NOT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `zone_id` int(11) NOT NULL,
  `branch_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK14f9k065wqeubl6tl0gdumcp5` (`company_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'Pune','sk &co',_binary '\0',1,'123',1,NULL),(15,'Pune','Vivek &co',_binary '',2,'456',1,NULL),(16,'Pune','Vivek &co',_binary '',3,'789',1,NULL),(17,'Pune','Vivek &co',_binary '',2,'111',2,NULL),(20,'Mumbai','Mainudidn &co',_binary '',1,'222',2,NULL),(21,'Bhubaneswar','XYZ &co',_binary '',2,'333',2,NULL),(22,'Cuttack','Quick &co',_binary '\0',3,'109',1,NULL),(23,'Cuttack','Quick &co',_binary '\0',3,'209',2,NULL),(31,'Bhubaneswar','Carry Co ',_binary '\0',1,'751007',1,'Lords Tower 7th Floor'),(32,'Bhubaneswar','Carry Co Kalinga Vihar ',_binary '\0',1,'751007',2,'Near Damana ,KV');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `auth_person` varchar(255) DEFAULT NULL,
  `business_from` varchar(255) DEFAULT NULL,
  `comp_address` varchar(255) DEFAULT NULL,
  `comp_qualification` varchar(255) DEFAULT NULL,
  `company_login_name` varchar(8) NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `agreement_id` int(11) DEFAULT NULL,
  `audit_audit_id` int(11) DEFAULT NULL,
  `bank_details_id` int(11) DEFAULT NULL,
  `company_status_id` int(11) DEFAULT NULL,
  `owner_details_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_46jubpbtfae2gfb74a3x6qug7` (`company_name`),
  KEY `FKg4l3wyyi36bjcleolij4g0dm8` (`agreement_id`),
  KEY `FKpjso1euwmmc4r3n9khcnivn3m` (`audit_audit_id`),
  KEY `FKjjmq0trusyub91h0il7ffji95` (`bank_details_id`),
  KEY `FK6f7iirk0kycqn30yrmd1a0uup` (`company_status_id`),
  KEY `FK3qf8121vch3bsldido56wmcqc` (`owner_details_id`),
  KEY `FK5u6je0yfrq1lmy3h1vbpumo7g` (`type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'sk moin',NULL,NULL,NULL,'moinco','Moin Logistic','moinco@moinlogistic.com',NULL,'$2a$12$sfF5D1iXez6ltKwBl/WfH.WDQFCq/2qsXZ/omZgHI6OklFITuE2q2',NULL,NULL,NULL,1,NULL,1,1),(2,'Vivek Hari',NULL,NULL,NULL,'vivekco','Vivek Transporter','vivekco@transporter.com',NULL,'$2a$12$H9xA2baqf7853ptwb3uSD.MqJkBhDRVfNS82.XxlU5AMwSX2pSle.',NULL,NULL,NULL,NULL,NULL,NULL,2),(5,'Mainuddin Tarafdar',NULL,NULL,NULL,'moinco','Moin Transporter1','moinco@transporter1.com',NULL,'$2a$12$xA/ezfKOA2tSTFqjPBTP6OA9Mh1W3XkaPTvQfjLQi7/oATftRcKhG',NULL,NULL,NULL,NULL,NULL,NULL,2),(6,'XYZ Tarafdar',NULL,NULL,NULL,'xyzco','XYZ Transporter1','xyzco@transporter1.com',NULL,'$2a$12$bUsXa.O6emzRso87BlDwyeVu1KgdTB9dVnt6BsUcMrhQVaRkK12Km',NULL,NULL,NULL,NULL,NULL,NULL,2),(7,'Quick Tarafdar',NULL,NULL,NULL,'quickco','Quick Transporter1','quickco@transporter1.com',NULL,'$2a$12$uzn5CDuUK72lZPnzRAw8guyf6lBQEHtv2URTmNiw.ZWga8wP8IzSy',NULL,NULL,NULL,NULL,NULL,NULL,2),(8,'Sushil Sharma',NULL,NULL,NULL,'sushilco','Sushil Transporter1','sushilco@transporter1.com',NULL,'$2a$12$XhDdZy.PcaOmHcs.WJZeKe4gT7HMXqReQoGyVkO98j5wjC8dmbtu.',NULL,NULL,NULL,NULL,NULL,NULL,2);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_compliance`
--

DROP TABLE IF EXISTS `company_compliance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `company_compliance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `doc_number` varchar(255) DEFAULT NULL,
  `document_name` varchar(255) DEFAULT NULL,
  `issued_by` varchar(255) DEFAULT NULL,
  `renewal_required` bit(1) NOT NULL,
  `upload_path` varchar(255) DEFAULT NULL,
  `valid_from` datetime DEFAULT NULL,
  `valid_to` datetime DEFAULT NULL,
  `audit_audit_id` int(11) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKonwuyo7s5xbfi69hcai2fcyqu` (`audit_audit_id`),
  KEY `FKmv8mnj2d64jjuuc9eigc85t4r` (`company_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_compliance`
--

LOCK TABLES `company_compliance` WRITE;
/*!40000 ALTER TABLE `company_compliance` DISABLE KEYS */;
INSERT INTO `company_compliance` VALUES (7,'Bhubaneswar','OK','989889898889','GST','Global Taxation Dept',_binary '\0',NULL,'2015-02-16 05:30:00','2032-02-14 05:30:00',NULL,1),(6,'Bhubaneswar','OK','989889898889','Registration','REgistration Dept',_binary '\0',NULL,'2010-02-16 05:30:00','2022-02-14 05:30:00',NULL,1),(5,'Bhubaneswar','OK','86186168AHGHG9808','Adhar','UDDI Gove of India',_binary '\0',NULL,'2010-02-16 05:30:00','2025-02-14 05:30:00',NULL,1),(8,'Bhubaneswar','OK','AFEUT7884R','PAN','Income Tax Dept.',_binary '\0',NULL,'2010-02-16 05:30:00','2022-02-14 05:30:00',NULL,1);
/*!40000 ALTER TABLE `company_compliance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_status`
--

DROP TABLE IF EXISTS `company_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `company_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adhar` varchar(255) DEFAULT NULL,
  `pan` varchar(255) DEFAULT NULL,
  `reg_number` varchar(255) DEFAULT NULL,
  `audit_audit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_thjnvxuim801w81p0wfekxa95` (`reg_number`),
  KEY `FKt24274u4o49k1bjsjhchdbxbb` (`audit_audit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_status`
--

LOCK TABLES `company_status` WRITE;
/*!40000 ALTER TABLE `company_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `company_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entities`
--

DROP TABLE IF EXISTS `entities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `entities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `entity_name` varchar(255) DEFAULT NULL,
  `audit_audit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkdx4obdaqr1vwjirdhstf6wwf` (`audit_audit_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entities`
--

LOCK TABLES `entities` WRITE;
/*!40000 ALTER TABLE `entities` DISABLE KEYS */;
INSERT INTO `entities` VALUES (1,'SHIPPER',NULL),(2,'TRANSPORTER',NULL);
/*!40000 ALTER TABLE `entities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (38),(38),(38),(38),(38),(38);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `notification_from` int(11) NOT NULL,
  `notification_to` int(11) NOT NULL,
  `audit_audit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2cf4uyf51snehs64cif1gufga` (`audit_audit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `owner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `experience` int(11) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1,'VIP Street Lane,Noida',50,'chadda1@moinco.com',20,'Milu Mittal','1266666561');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking`
--

DROP TABLE IF EXISTS `parking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bay_entry_date_time` datetime DEFAULT NULL,
  `bay_manager_id` bigint(20) DEFAULT NULL,
  `bay_number` int(11) NOT NULL,
  `gate_entry_date_time` datetime DEFAULT NULL,
  `gate_keeper_id` bigint(20) DEFAULT NULL,
  `parking_lot` int(11) NOT NULL,
  `parking_lot_entry_date_time` datetime DEFAULT NULL,
  `parking_status` varchar(255) DEFAULT NULL,
  `truck_arrival_date_time` datetime DEFAULT NULL,
  `yard_boy_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking`
--

LOCK TABLES `parking` WRITE;
/*!40000 ALTER TABLE `parking` DISABLE KEYS */;
/*!40000 ALTER TABLE `parking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking_status`
--

DROP TABLE IF EXISTS `parking_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parking_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) NOT NULL,
  `available_bay_slots` int(11) NOT NULL,
  `available_parking_slots` int(11) NOT NULL,
  `bay_entry_date` datetime DEFAULT NULL,
  `bay_exit_date` datetime DEFAULT NULL,
  `bay_number` int(11) NOT NULL,
  `bay_status` bit(1) NOT NULL,
  `bay_user_id` bigint(20) DEFAULT NULL,
  `booking_id` bigint(20) NOT NULL,
  `booking_id_in_bay` bigint(20) NOT NULL,
  `load_unload_status` varchar(255) DEFAULT NULL,
  `parking` int(11) NOT NULL,
  `parking_entry_date` datetime DEFAULT NULL,
  `parking_exit_date` datetime DEFAULT NULL,
  `total_bay_slots` int(11) NOT NULL,
  `total_parking_slots` int(11) NOT NULL,
  `vehicle_number` varchar(255) DEFAULT NULL,
  `yard_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking_status`
--

LOCK TABLES `parking_status` WRITE;
/*!40000 ALTER TABLE `parking_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `parking_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quote`
--

DROP TABLE IF EXISTS `quote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `quote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid_price` decimal(19,2) DEFAULT NULL,
  `bid_status` varchar(255) DEFAULT NULL,
  `negotiate_price` decimal(19,2) DEFAULT NULL,
  `audit_audit_id` int(11) DEFAULT NULL,
  `bid_id` int(11) DEFAULT NULL,
  `quote_by_id` bigint(20) DEFAULT NULL,
  `quote_price` decimal(19,2) DEFAULT NULL,
  `quote_status` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `trip_assigned` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl6pgdo0xkqjewq4k2ncvod3ta` (`quote_by_id`),
  KEY `FKo1wrrypp9yaahxaq3r79pkgg1` (`audit_audit_id`),
  KEY `FKf9gnbay5k53c7f7kcticfbapl` (`bid_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quote`
--

LOCK TABLES `quote` WRITE;
/*!40000 ALTER TABLE `quote` DISABLE KEYS */;
INSERT INTO `quote` VALUES (4,NULL,NULL,NULL,NULL,10,5,5000.00,'Quoted',NULL,0),(3,NULL,NULL,NULL,NULL,10,2,8000.00,'Quoted',NULL,0),(5,NULL,NULL,NULL,NULL,10,6,3000.00,'Quoted',NULL,0),(6,NULL,NULL,NULL,NULL,10,7,3500.00,'Quoted',NULL,0),(7,NULL,NULL,NULL,NULL,11,2,6000.00,'Accepted',NULL,0),(8,NULL,NULL,NULL,NULL,11,8,4000.00,'Quoted',NULL,0),(9,NULL,NULL,NULL,NULL,11,5,8000.00,'Quoted',NULL,0),(10,NULL,NULL,NULL,NULL,11,6,9000.00,'Quoted',NULL,0),(11,NULL,NULL,NULL,NULL,11,7,19000.00,'Accepted',NULL,0),(12,NULL,NULL,NULL,NULL,11,7,19000.00,'Quoted',NULL,0),(13,NULL,NULL,NULL,NULL,14,7,19000.00,'Accepted',NULL,0),(14,NULL,NULL,NULL,NULL,14,7,11000.00,'Rejected','Not Applicable',0),(15,NULL,NULL,NULL,NULL,14,8,11000.00,'Quoted',NULL,0),(16,NULL,NULL,3000.00,NULL,16,8,5000.00,'Quoted',NULL,300);
/*!40000 ALTER TABLE `quote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment_booking`
--

DROP TABLE IF EXISTS `shipment_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shipment_booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_paid` decimal(19,2) DEFAULT NULL,
  `arrival_date_time` datetime DEFAULT NULL,
  `booking_number` bigint(20) DEFAULT NULL,
  `booking_start_date` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `company_id` int(11) NOT NULL,
  `delivered_date` datetime DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `driver_id` int(11) NOT NULL,
  `driver_mob` varchar(255) DEFAULT NULL,
  `driver_name` varchar(255) DEFAULT NULL,
  `drop_location` varchar(255) DEFAULT NULL,
  `drop_required` bit(1) NOT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  `gate_keeper_id` int(11) NOT NULL,
  `logistic_officer_id` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `shipment_cost` decimal(19,2) DEFAULT NULL,
  `shipment_type` varchar(255) DEFAULT NULL,
  `shipment_unit` varchar(255) DEFAULT NULL,
  `shipment_weight` int(11) NOT NULL,
  `source_location` varchar(255) DEFAULT NULL,
  `truck_type` varchar(255) DEFAULT NULL,
  `vehicle_number` varchar(255) DEFAULT NULL,
  `audit_audit_id` int(11) DEFAULT NULL,
  `billing_id` int(11) DEFAULT NULL,
  `parking_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_64rnbms6pe0cjjrug40rm4dr9` (`booking_number`),
  KEY `FKxmujvamvxpoxhmk7ov8vtd44` (`audit_audit_id`),
  KEY `FKgsow28kohyn7u2a9qekt2k2xn` (`billing_id`),
  KEY `FKdjokxrn9ia0tsbuadxkqqoj14` (`parking_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_booking`
--

LOCK TABLES `shipment_booking` WRITE;
/*!40000 ALTER TABLE `shipment_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipment_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `truck`
--

DROP TABLE IF EXISTS `truck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `truck` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` decimal(19,2) DEFAULT NULL,
  `reg_number` varchar(255) DEFAULT NULL,
  `truck_type` varchar(255) DEFAULT NULL,
  `owned_by_id` bigint(20) DEFAULT NULL,
  `truck_type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7xxch732rmr4yda4s24m4ybav` (`owned_by_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `truck`
--

LOCK TABLES `truck` WRITE;
/*!40000 ALTER TABLE `truck` DISABLE KEYS */;
/*!40000 ALTER TABLE `truck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `truck_type`
--

DROP TABLE IF EXISTS `truck_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `truck_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `truck_type`
--

LOCK TABLES `truck_type` WRITE;
/*!40000 ALTER TABLE `truck_type` DISABLE KEYS */;
INSERT INTO `truck_type` VALUES (1,'Canter Jumbo'),(2,'Container Truck'),(3,'Trailer'),(4,'Truck 10 Wheel'),(5,'Truck 12 Wheel'),(6,'Truck 14 Wheel');
/*!40000 ALTER TABLE `truck_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_bank_details`
--

DROP TABLE IF EXISTS `user_bank_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_bank_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_number` bigint(20) DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `ifsc_code` varchar(255) DEFAULT NULL,
  `micr_code` varchar(255) DEFAULT NULL,
  `pan_number` varchar(255) DEFAULT NULL,
  `audit_audit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9xxioxil6li9g01pfb9kimlec` (`audit_audit_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_bank_details`
--

LOCK TABLES `user_bank_details` WRITE;
/*!40000 ALTER TABLE `user_bank_details` DISABLE KEYS */;
INSERT INTO `user_bank_details` VALUES (1,990029092990,'Saving','Global Towers ,3d Flr','Baroda Bank Ltd','BRDA86186','MICRCODE0080','AFE8787878UI',NULL),(2,990029092990,'current','Global Towers,2nd Flr','Dena Bank Ltd','Dena86186','MICRCODE0080','AFE8787878UI',NULL),(3,990029092990,'Saving','Global Towers ,3d Flr','CITI Bank Ltd','BRDA86186','MICRCODE0080','AFE8787878UI',NULL);
/*!40000 ALTER TABLE `user_bank_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_compliance`
--

DROP TABLE IF EXISTS `user_compliance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_compliance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `doc_number` varchar(255) DEFAULT NULL,
  `document_name` varchar(255) DEFAULT NULL,
  `issued_by` varchar(255) DEFAULT NULL,
  `renewal_required` bit(1) NOT NULL,
  `upload_path` varchar(255) DEFAULT NULL,
  `valid_from` datetime DEFAULT NULL,
  `valid_to` datetime DEFAULT NULL,
  `audit_audit_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbud8682nt55s1h7lnptyd2p0t` (`audit_audit_id`),
  KEY `FK7npd7lmroc4shdh1fhs98qqd8` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_compliance`
--

LOCK TABLES `user_compliance` WRITE;
/*!40000 ALTER TABLE `user_compliance` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_compliance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_personal_details`
--

DROP TABLE IF EXISTS `user_personal_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_personal_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `doj` varchar(255) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `work_location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_personal_details`
--

LOCK TABLES `user_personal_details` WRITE;
/*!40000 ALTER TABLE `user_personal_details` DISABLE KEYS */;
INSERT INTO `user_personal_details` VALUES (1,'Lewis Square Colony',3,'b+','1985-02-18','2010-09-18','bobby@gmail.com','2','Shaikh Aqsha','1234567890','Female','Bhubaneswar'),(2,'Stewart Colony',40,'B+','1981-02-18','2007-09-18','moin@gmail.com','15','Shaikh Sohail','7676766760','male','Bhubaneswar'),(3,'Infotech Global',3,'b+','1988-02-18','2010-09-18','bobby@gmail.com','2','Shaikh Aroosh','1234567890','male','Pune');
/*!40000 ALTER TABLE `user_personal_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `user_bank_details_id` int(11) DEFAULT NULL,
  `user_personal_details_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  KEY `FKbwv4uspmyi7xqjwcrgxow361t` (`company_id`),
  KEY `FKio6calq1j9o61i37rn7a8gk8u` (`user_bank_details_id`),
  KEY `FKc03buooqpdvqgnm3elidgvth8` (`user_personal_details_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,_binary '\0','user123','Office Manager',NULL,'aqsha123',1,1,1),(4,_binary '\0','user123','Office Executive',NULL,'sohail123',1,2,2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zone`
--

DROP TABLE IF EXISTS `zone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `zone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zone_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zone`
--

LOCK TABLES `zone` WRITE;
/*!40000 ALTER TABLE `zone` DISABLE KEYS */;
INSERT INTO `zone` VALUES (1,'ZONE A'),(2,'ZONE B');
/*!40000 ALTER TABLE `zone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-15  1:30:58
