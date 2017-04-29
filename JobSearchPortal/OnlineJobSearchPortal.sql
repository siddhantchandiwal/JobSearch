-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: jobsearchportal
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`userId`),
  CONSTRAINT `FKjoav33p64suikub3369fpajy4` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidate` (
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`userId`),
  CONSTRAINT `FKg9cpirmn7dulbni5x4dnuw32c` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES (3),(17),(21),(27),(35);
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employer`
--

DROP TABLE IF EXISTS `employer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employer` (
  `userId` int(11) NOT NULL,
  `organizationID` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `FKj8f11aejbk81vosr2ja7yp31k` (`organizationID`),
  CONSTRAINT `FK4kwyjdf9h43oenbta8ec77g92` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `FKj8f11aejbk81vosr2ja7yp31k` FOREIGN KEY (`organizationID`) REFERENCES `organziation` (`organizationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employer`
--

LOCK TABLES `employer` WRITE;
/*!40000 ALTER TABLE `employer` DISABLE KEYS */;
INSERT INTO `employer` VALUES (2,4),(13,12),(23,24),(33,34);
/*!40000 ALTER TABLE `employer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (40),(40),(40),(40),(40),(40);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `jobID` int(11) NOT NULL,
  `jobDescription` varchar(255) DEFAULT NULL,
  `jobLocationCity` varchar(255) DEFAULT NULL,
  `jobLocationCountry` varchar(255) DEFAULT NULL,
  `jobLocationState` varchar(255) DEFAULT NULL,
  `jobTitle` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `vacancies` varchar(255) DEFAULT NULL,
  `organizationID` int(11) DEFAULT NULL,
  PRIMARY KEY (`jobID`),
  KEY `FK3osl0hdxdgjnwth4h259r9r39` (`organizationID`),
  CONSTRAINT `FK3osl0hdxdgjnwth4h259r9r39` FOREIGN KEY (`organizationID`) REFERENCES `organziation` (`organizationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (5,'Proficient Software Engineer having good skill set and have 5 years of work experience','New York','USA','NY','Software Engineer','Master\'s Degree','5',4),(6,'Management Profile Person Required','Boston','USA','MA','Business Analyst','Bachelor\'s Degree','1',4),(7,'Current Graduate Student Required','Austin','USA','TX','Software Engineer Intern','Master\'s Degree','12',4),(8,'Management Profile Person Required','Dallas','USA','TX','Program Manager Intern','PhD','5',4),(14,'Experienced Candidate Required','Boston','USA','MA','Software Developer','Master\'s Degree','10',12),(15,'Having Business Knowledge','Chicago','USA','IL','Business Analyst','Master\'s Degree','15',12),(16,'Data Analytical Skills Required','Austin','USA','TX','Data Analyst Intern','PhD','6',12),(25,'Software Engineer with high technical skills','Dallas','USA','TX','Software Engineer','Master\'s Degree','6',24),(26,'Management Profile Person Required','Chicago','USA','IL','Program Manager Intern','Bachelor\'s Degree','4',24),(39,'Software Engineer with high technical skills','Boston','USA','MA','Software Developer Intern','Bachelor\'s Degree','40',34);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobapp`
--

DROP TABLE IF EXISTS `jobapp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobapp` (
  `jobApplicationID` int(11) NOT NULL,
  `currentJobStatus` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `jobID` int(11) DEFAULT NULL,
  PRIMARY KEY (`jobApplicationID`),
  KEY `FKhegc3gvu6ism7r8o3w58t5j1e` (`userId`),
  KEY `FKeffq57jjt0ncsrbhjdl1b6998` (`jobID`),
  CONSTRAINT `FKeffq57jjt0ncsrbhjdl1b6998` FOREIGN KEY (`jobID`) REFERENCES `job` (`jobID`),
  CONSTRAINT `FKhegc3gvu6ism7r8o3w58t5j1e` FOREIGN KEY (`userId`) REFERENCES `candidate` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobapp`
--

LOCK TABLES `jobapp` WRITE;
/*!40000 ALTER TABLE `jobapp` DISABLE KEYS */;
INSERT INTO `jobapp` VALUES (10,'Applied',3,5),(19,'Applied',17,14),(28,'Applied',21,26),(31,'Applied',27,16),(37,'Applied',35,15);
/*!40000 ALTER TABLE `jobapp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobstatus`
--

DROP TABLE IF EXISTS `jobstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobstatus` (
  `jobStatusId` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `jobAppID` int(11) DEFAULT NULL,
  PRIMARY KEY (`jobStatusId`),
  KEY `FKe0lgiyd4q1crqnqmwb0acpjaq` (`jobAppID`),
  CONSTRAINT `FKe0lgiyd4q1crqnqmwb0acpjaq` FOREIGN KEY (`jobAppID`) REFERENCES `jobapp` (`jobApplicationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobstatus`
--

LOCK TABLES `jobstatus` WRITE;
/*!40000 ALTER TABLE `jobstatus` DISABLE KEYS */;
INSERT INTO `jobstatus` VALUES (11,'Applied',10),(20,'Applied',19),(29,'Applied',28),(32,'Applied',31),(38,'Applied',37);
/*!40000 ALTER TABLE `jobstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organziation`
--

DROP TABLE IF EXISTS `organziation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organziation` (
  `organizationID` int(11) NOT NULL,
  `businessType` varchar(255) DEFAULT NULL,
  `organizationName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`organizationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organziation`
--

LOCK TABLES `organziation` WRITE;
/*!40000 ALTER TABLE `organziation` DISABLE KEYS */;
INSERT INTO `organziation` VALUES (4,'Apple','Apple'),(12,'Google','Google'),(24,'Facebook','Facebook'),(34,'Amazon','Amazon');
/*!40000 ALTER TABLE `organziation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `profileID` int(11) NOT NULL,
  `annualEndPay` double DEFAULT NULL,
  `annualStartPay` double DEFAULT NULL,
  `companyCity` varchar(255) DEFAULT NULL,
  `companyCountry` varchar(255) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `companyState` varchar(255) DEFAULT NULL,
  `companyType` varchar(255) DEFAULT NULL,
  `companyZipCode` varchar(255) DEFAULT NULL,
  `educationLevel` varchar(255) DEFAULT NULL,
  `expYearOfGraduation` varchar(255) DEFAULT NULL,
  `gpa` double DEFAULT NULL,
  `jobTitle` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `startYear` varchar(255) DEFAULT NULL,
  `universityAddress` varchar(255) DEFAULT NULL,
  `universityName` varchar(255) DEFAULT NULL,
  `candidate` int(11) NOT NULL,
  PRIMARY KEY (`profileID`),
  KEY `FK57k913ifb50e5lxhb0l4sfme8` (`candidate`),
  CONSTRAINT `FK57k913ifb50e5lxhb0l4sfme8` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (9,14,11,'Boston','United States','Neu RSO','MA','Safety','02115','Masters','2018',3.667,'Proctor','Information Systems','2016','360 Huntington Ave Boston MA','Northeastern University',3),(18,3500,3000,'Mumbai','India','Accenture','MH','IT Software','400002','Bachelors','2014',3.54,'Analyst','CS','2010','University Road Mumbai','Mumbai University',17),(22,35000,30000,'Pune','India','Infosys Ltd','MH','IT','411057','Bachelors','2014',3.55,'Analyst','IT','2010','Ganeshkhind Road Pune','Pune University',21),(30,20,16,'Pune','India','Sandvik Pvt Ltd','MH','Mechanical Instrumentation','411058','Masters','2018',3.54,'Mechanical Intern','Engineering Management','2016','360 Huntington Ave Boston MA','Northeastern University',27),(36,90,63,'Mumbai','India','Infosys Ltd','MH','Pune','400002','Diploma','2014',2.63,'Analyst','Instrumentation','2010','Mahalaxmi Temple','Kolhapur University',35);
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `emailId` varchar(255) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `streetLine1` varchar(255) DEFAULT NULL,
  `streetLine2` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,'admin@gmail.com',NULL,'admin','admin','admin',0,NULL,NULL,NULL,'admin','Admin'),(2,NULL,NULL,'applerecruiter@apple.com',NULL,'Apple','Apple','apple',0,NULL,NULL,NULL,'apple','Employer'),(3,'Boston','United States','chandiwal.s@husky.neu.edu','Siddhant_Chandiwal_Resume.pdf','Siddhant','Chandiwal','sc',8577078619,'MASSACHUSETTS','8 Saint Germain Street','Apt 4','sc','Candidate'),(13,NULL,NULL,'google@gmail.com',NULL,'Google','Google','google',0,NULL,NULL,NULL,'google','Employer'),(17,'Mumbai','India','gor.v@husky.neu.edu','Login.jpg','Vinay','Gor','vg',8577078635,'MH','Goregaon','Near Railway Station','vg','Candidate'),(21,'Mumbai','India','jain.aksha@husky.neu.edu','Front2.jpg','Akshay','Jain','aj',8577078637,'MH','Mulund','Highway road','aj','Candidate'),(23,NULL,NULL,'facebook@gmail.com',NULL,'Facebook','Facebook','facebook',0,NULL,NULL,NULL,'facebook','Employer'),(27,'Aurangabad','India','ajmera.j@husky.neu.edu','download.jpg','Jatin','Ajmera','ja',8577078629,'MH','Chintamani Society','Near Satish Petrol Pump','ja','Candidate'),(33,NULL,NULL,'amazon@recruiter.com',NULL,'Amazon','Amazon','amazon',0,NULL,NULL,NULL,'amazon','Employer'),(35,'New York','USA','randeria.a@husky.neu.edu','index.html','Aadesh','Randeria','ar',8576523568,'NY','Saint Germain Street','Apartment 4','ar','Candidate');
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

-- Dump completed on 2017-04-26  6:03:59
