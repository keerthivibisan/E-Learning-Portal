-- MySQL dump 10.19  Distrib 10.3.31-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: eportal
-- ------------------------------------------------------
-- Server version	10.3.31-MariaDB-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adminlogin`
--

DROP TABLE IF EXISTS `adminlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminlogin` (
  `AEmail` varchar(35) DEFAULT NULL,
  `Apassword` varchar(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminlogin`
--

LOCK TABLES `adminlogin` WRITE;
/*!40000 ALTER TABLE `adminlogin` DISABLE KEYS */;
INSERT INTO `adminlogin` VALUES ('keerthivibisan.ct20@bitsathy.ac.in','vibi1234');
/*!40000 ALTER TABLE `adminlogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `Cno` int(11) NOT NULL AUTO_INCREMENT,
  `Cname` varchar(40) DEFAULT NULL,
  `filepath` varchar(200) DEFAULT NULL,
  `UploaderTno` int(11) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `Udate` varchar(30) DEFAULT NULL,
  `jspfile` varchar(20) DEFAULT NULL,
  `detail` varchar(500) DEFAULT NULL,
  `img` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`Cno`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'JAVA','/usr/local/tomcat/webapps/E-Portal/Courses/JAVA',5,'ACTIVE','1.10.2021','JavaCourseVideo.jsp','Here You will Learn JAVA Core and Collections.','https://images.idgesg.net/images/article/2019/05/java_binary_code_gears_programming_coding_development_by_bluebay2014_gettyimages-1040871468_2400x1600-100795798-large.jpg?auto=webp&quality=85,70');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gamifyregister`
--

DROP TABLE IF EXISTS `gamifyregister`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gamifyregister` (
  `Sid` int(11) DEFAULT NULL,
  `Score` int(11) DEFAULT NULL,
  `Cdate` varchar(30) DEFAULT NULL,
  KEY `Sid` (`Sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamifyregister`
--

LOCK TABLES `gamifyregister` WRITE;
/*!40000 ALTER TABLE `gamifyregister` DISABLE KEYS */;
INSERT INTO `gamifyregister` VALUES (17069,5,'Sun Aug 15 23:06:30 IST 2021'),(17069,5,'Sun Aug 15 23:06:30 IST 2021'),(85259,1,'Tue Nov 23 17:10:03 IST 2021');
/*!40000 ALTER TABLE `gamifyregister` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stucoursemarks`
--

DROP TABLE IF EXISTS `stucoursemarks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stucoursemarks` (
  `Cno` int(11) DEFAULT NULL,
  `Sno` int(11) DEFAULT NULL,
  `mark` int(10) DEFAULT NULL,
  `dates` varchar(30) DEFAULT NULL,
  KEY `Cno` (`Cno`),
  KEY `Sno` (`Sno`),
  CONSTRAINT `stucoursemarks_ibfk_1` FOREIGN KEY (`Cno`) REFERENCES `courses` (`Cno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stucoursemarks_ibfk_2` FOREIGN KEY (`Sno`) REFERENCES `studentdetails` (`Sno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stucoursemarks`
--

LOCK TABLES `stucoursemarks` WRITE;
/*!40000 ALTER TABLE `stucoursemarks` DISABLE KEYS */;
/*!40000 ALTER TABLE `stucoursemarks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentdetails`
--

DROP TABLE IF EXISTS `studentdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentdetails` (
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(18) DEFAULT NULL,
  `contact` varchar(10) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `Sno` int(11) NOT NULL AUTO_INCREMENT,
  `Jdate` varchar(30) DEFAULT NULL,
  `action` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`Sno`),
  UNIQUE KEY `name` (`name`,`password`,`contact`,`email`,`Sno`)
) ENGINE=InnoDB AUTO_INCREMENT=85264 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentdetails`
--

LOCK TABLES `studentdetails` WRITE;
/*!40000 ALTER TABLE `studentdetails` DISABLE KEYS */;
INSERT INTO `studentdetails` VALUES ('user','useruser','9655997760','student@gmail.com',1,'',NULL),('vibi','vibi1234','9655997760','trimaqua7760@gmail.com',17069,NULL,NULL),('KAMALESWARAN S','Google-User',NULL,'kamaleswaran.ct20@bitsathy.ac.in',85260,'Fri Nov 19 19:12:46 IST 2021',NULL),('KEERTHI VIBISAN S','Google-User','9655997760','keerthivibisan.ct20@bitsathy.ac.in',85261,'Mon Dec 06 10:32:44 IST 2021',NULL),('No Reply','Google-User',NULL,'skvtech2211@gmail.com',85262,'Wed Dec 08 11:21:31 IST 2021',NULL),('MOHAMEDHIJAS','hijas1234','9787972809','mohamedhijas.ct20@bitsathy.ac.in',85263,'Fri Dec 10 03:41:54 UTC 2021',NULL);
/*!40000 ALTER TABLE `studentdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sturegistercourse`
--

DROP TABLE IF EXISTS `sturegistercourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sturegistercourse` (
  `Cno` int(11) DEFAULT NULL,
  `Cname` varchar(60) DEFAULT NULL,
  `Sno` int(11) DEFAULT NULL,
  `Rdate` varchar(30) DEFAULT NULL,
  KEY `Cno` (`Cno`),
  KEY `Sno` (`Sno`),
  CONSTRAINT `sturegistercourse_ibfk_1` FOREIGN KEY (`Cno`) REFERENCES `courses` (`Cno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sturegistercourse_ibfk_2` FOREIGN KEY (`Sno`) REFERENCES `studentdetails` (`Sno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sturegistercourse`
--

LOCK TABLES `sturegistercourse` WRITE;
/*!40000 ALTER TABLE `sturegistercourse` DISABLE KEYS */;
INSERT INTO `sturegistercourse` VALUES (1,'JAVA',85261,'Tue Dec 21 16:17:27 IST 2021'),(1,'JAVA',17069,'Fri Feb 18 08:54:28 UTC 2022');
/*!40000 ALTER TABLE `sturegistercourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stuvideoregister`
--

DROP TABLE IF EXISTS `stuvideoregister`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stuvideoregister` (
  `VideoId` varchar(30) DEFAULT NULL,
  `Sid` int(11) DEFAULT NULL,
  `Cid` int(11) DEFAULT NULL,
  `Wdate` varchar(35) DEFAULT NULL,
  KEY `Sid` (`Sid`),
  KEY `Cid` (`Cid`),
  CONSTRAINT `stuvideoregister_ibfk_1` FOREIGN KEY (`Sid`) REFERENCES `studentdetails` (`Sno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stuvideoregister_ibfk_2` FOREIGN KEY (`Cid`) REFERENCES `courses` (`Cno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stuvideoregister`
--

LOCK TABLES `stuvideoregister` WRITE;
/*!40000 ALTER TABLE `stuvideoregister` DISABLE KEYS */;
INSERT INTO `stuvideoregister` VALUES ('JavaV1',85261,1,'Tue Dec 21 16:17:51 IST 2021');
/*!40000 ALTER TABLE `stuvideoregister` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `Tno` int(11) NOT NULL AUTO_INCREMENT,
  `Tname` varchar(30) DEFAULT NULL,
  `Tcontact` varchar(10) DEFAULT NULL,
  `Temail` varchar(80) DEFAULT NULL,
  `Tpassword` varchar(18) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  `Action` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Tno`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (5,'vibiasd','9655997760','keerthivibisan.ct20@bitsathy.ac.in','vibi1234',NULL,NULL),(6,'ElonMusk','9655997760','skvtech2211@gmail.com','elon1234','Mon Aug 16 11:16:53 IST 2021',NULL),(12,'BOOTSTRAP','9655997760','trimaqua7760@gmail.com',NULL,'Sat Sep 11 21:38:17 IST 2021',NULL);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-18 13:38:14
