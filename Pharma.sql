-- MySQL dump 10.13  Distrib 5.5.32, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: Pharmacy
-- ------------------------------------------------------
-- Server version	5.5.32-0ubuntu0.12.04.1

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
-- Table structure for table `customer_order`
--

DROP TABLE IF EXISTS `customer_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_order` (
  `customer_order_id` varchar(5) NOT NULL,
  `customer_order_date` varchar(45) NOT NULL,
  `customer_order_amount` decimal(10,0) NOT NULL,
  `employee_id` varchar(5) NOT NULL,
  PRIMARY KEY (`customer_order_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `customer_order_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_order`
--

LOCK TABLES `customer_order` WRITE;
/*!40000 ALTER TABLE `customer_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drug`
--

DROP TABLE IF EXISTS `drug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drug` (
  `drug_id` varchar(5) NOT NULL,
  `drug_name_id` varchar(5) NOT NULL,
  `drug_type` varchar(50) NOT NULL,
  `drug_dose` int(11) NOT NULL,
  `drug_unit_price` decimal(10,4) NOT NULL,
  `drug_expire_date` varchar(50) DEFAULT NULL,
  `drug_qty` varchar(50) NOT NULL,
  `availability` tinyint(1) NOT NULL,
  PRIMARY KEY (`drug_id`),
  KEY `drug_name_id` (`drug_name_id`),
  CONSTRAINT `drug_ibfk_1` FOREIGN KEY (`drug_name_id`) REFERENCES `trade_name` (`trade_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drug`
--

LOCK TABLES `drug` WRITE;
/*!40000 ALTER TABLE `drug` DISABLE KEYS */;
INSERT INTO `drug` VALUES ('D001','T001','Pill',50,45.0000,'05-04-2020','200',1),('D002','T006','Pill',10,2.4500,'10-06-2016','30',1),('D003','T012','Pill',500,2.5000,'06-11-2018','12',1);
/*!40000 ALTER TABLE `drug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employee_id` varchar(5) NOT NULL,
  `employee_name` varchar(50) NOT NULL,
  `employee_address` varchar(200) NOT NULL,
  `employee_telephone` varchar(10) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('E001','Sanduni Nimesha','No.200,Galle Road,Matara','0714019137'),('OWNER','OWNER','OWNER','OWNER');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharma_name`
--

DROP TABLE IF EXISTS `pharma_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pharma_name` (
  `pharma_id` varchar(5) NOT NULL,
  `pharma_name` varchar(100) NOT NULL,
  PRIMARY KEY (`pharma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharma_name`
--

LOCK TABLES `pharma_name` WRITE;
/*!40000 ALTER TABLE `pharma_name` DISABLE KEYS */;
INSERT INTO `pharma_name` VALUES ('P001','Atenelol'),('P002','Atorvastatin'),('P003','Amoxicillin'),('P004','Amoxicillin+Calvunic Acid'),('P005','Diclofenac'),('P006','Aspirin'),('P007','Paracetamol');
/*!40000 ALTER TABLE `pharma_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `supplier_id` varchar(5) NOT NULL,
  `supplier_name` varchar(100) NOT NULL,
  `supplier_address` varchar(200) NOT NULL,
  `suplier_telephone` varchar(10) NOT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('S001','Ceylon Drugs','Galle Rd, Colombo','0112233478');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_order`
--

DROP TABLE IF EXISTS `supplier_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_order` (
  `suppplier_order_id` varchar(5) NOT NULL,
  `supplier_id` varchar(5) NOT NULL,
  `supplier_order_date` varchar(45) DEFAULT NULL,
  `supplier_payment_id` varchar(5) NOT NULL,
  PRIMARY KEY (`suppplier_order_id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `supplier_payment_id` (`supplier_payment_id`),
  CONSTRAINT `supplier_order_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `supplier_order_ibfk_2` FOREIGN KEY (`supplier_payment_id`) REFERENCES `supplier_payment` (`payment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_order`
--

LOCK TABLES `supplier_order` WRITE;
/*!40000 ALTER TABLE `supplier_order` DISABLE KEYS */;
INSERT INTO `supplier_order` VALUES ('D001','S001','30/09/2013','P001');
/*!40000 ALTER TABLE `supplier_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_order_details`
--

DROP TABLE IF EXISTS `supplier_order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_order_details` (
  `order_id` varchar(5) NOT NULL,
  `trade_id` varchar(5) NOT NULL,
  `unit_price` decimal(10,2) NOT NULL,
  `unit_type` varchar(50) NOT NULL,
  `dose` int(11) NOT NULL,
  `qty` varchar(50) NOT NULL,
  PRIMARY KEY (`order_id`,`trade_id`),
  KEY `drug_id` (`trade_id`),
  CONSTRAINT `supplier_order_details_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `supplier_order` (`suppplier_order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `supplier_order_details_ibfk_2` FOREIGN KEY (`trade_id`) REFERENCES `trade_name` (`trade_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_order_details`
--

LOCK TABLES `supplier_order_details` WRITE;
/*!40000 ALTER TABLE `supplier_order_details` DISABLE KEYS */;
INSERT INTO `supplier_order_details` VALUES ('D001','T005',0.00,'Pill',10,'100');
/*!40000 ALTER TABLE `supplier_order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_payment`
--

DROP TABLE IF EXISTS `supplier_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_payment` (
  `payment_id` varchar(5) NOT NULL,
  `employee_id` varchar(5) NOT NULL,
  `payment_date` varchar(45) NOT NULL,
  `amount` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`payment_id`,`employee_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `supplier_payment_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_payment`
--

LOCK TABLES `supplier_payment` WRITE;
/*!40000 ALTER TABLE `supplier_payment` DISABLE KEYS */;
INSERT INTO `supplier_payment` VALUES ('P001','OWNER','30/09/2013',NULL);
/*!40000 ALTER TABLE `supplier_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade_name`
--

DROP TABLE IF EXISTS `trade_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade_name` (
  `trade_id` varchar(5) NOT NULL,
  `trade_name` varchar(100) NOT NULL,
  `pharma_id` varchar(5) NOT NULL,
  PRIMARY KEY (`trade_id`,`pharma_id`,`trade_name`),
  KEY `pharma_id` (`pharma_id`),
  CONSTRAINT `trade_name_ibfk_1` FOREIGN KEY (`pharma_id`) REFERENCES `pharma_name` (`pharma_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_name`
--

LOCK TABLES `trade_name` WRITE;
/*!40000 ALTER TABLE `trade_name` DISABLE KEYS */;
INSERT INTO `trade_name` VALUES ('T001','Aminol','P001'),('T002','Atol -AM','P001'),('T004','Atria','P002'),('T005','Atstat','P002'),('T006','Atrostat','P002'),('T007','Atvas','P002'),('T008','Atrolar','P002'),('T009','Panadene','P007'),('T010','AmoxiClav','P004'),('T011','Panadol','P007'),('T012','Paracetol','P007');
/*!40000 ALTER TABLE `trade_name` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-09-27  2:37:33
