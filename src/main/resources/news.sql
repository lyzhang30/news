-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: news
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_category`
--

DROP TABLE IF EXISTS `t_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `t_category` (
                              `categoryId` int(11) NOT NULL,
                              `categoryName` varchar(20) DEFAULT NULL,
                              PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_category`
--

LOCK TABLES `t_category` WRITE;
/*!40000 ALTER TABLE `t_category` DISABLE KEYS */;
INSERT INTO `t_category` VALUES (1,'今日头条'),(2,'综合资讯'),(3,'国内新闻'),(4,'国际新闻');
/*!40000 ALTER TABLE `t_cateL,'1',1,NULL);
/*!40000 ALTER TABLE `t_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_role` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'管理员'),(2,'信息员');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `loginName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `registerTime` datetime DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'无为','admin','123456',NULL,'2020-04-13 13:44:13','2',1),(2,'user','user','123456','','2020-04-13 13:44:34','2',2);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*gory` ENABLE KEYS */;
/*UNLOCK TABLES;*/

--
-- Table structure for table `t_news`
--

DROP TABLE IF EXISTS `t_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_news` (
  `newsId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) DEFAULT NULL,
  `contentTitle` varchar(120) DEFAULT NULL,
  `titlePicUrl` varchar(120) DEFAULT NULL,
  `content` text,
  `contentAbstract` varchar(300) DEFAULT NULL,
  `keywords` varchar(100) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `clicks` int(11) DEFAULT NULL,
  `publishStatus` char(1) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`newsId`),
  KEY `categoryId` (`categoryId`),
  KEY `userId` (`userId`),
  CONSTRAINT `t_news_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `t_category` (`categoryid`),
  CONSTRAINT `t_news_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `t_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_news`
--

LOCK TABLES `t_news` WRITE;
/*!40000 ALTER TABLE `t_news` DISABLE KEYS */;
INSERT INTO `t_news` VALUES (1,'做好疫情加试题 确保脱贫高质量','做好疫情加试题 确保脱贫高质量',NULL,'做好疫情加试题 确保脱贫高质量','','','','2020-04-14 13:44:39',NULL,'2',1,NULL),(2,'扩大内需必须加快推进复工复产','扩大内需必须加快推进复工复产',NULL,'扩大内需必须加快推进复工复产','','','','2020-04-14 13:45:56',NULL,'1',2,NULL),(3,'做好疫情加试题 确保脱贫高质量','做好疫情加试题 确保脱贫高质量',NULL,'新冠肺炎疫情是决战决胜脱贫攻坚的加试题，也是影响脱贫质量的最大不确定因素。要按照党中央的决策部署，坚持在常态化疫情防控中加快推进生产生活秩序全面恢复，积极推动贫困劳动力尽快就业务工，大力开展消费扶贫行动，切实解决制约扶贫项目开工建设的突出问题，织牢织密综合兜底保障网，坚决把疫情耽误的进度抢回来，力争把疫情的不利影响降到最低。脱贫工作越到最后时刻，越要狠抓工作作风转变，坚决克服形式主义、官僚主义，坚决纠正挂牌督战中只督不战、督强战弱、重督轻扶等问题，把提出问题与解决问题结合起来，上级下级捆到一起干，确保各项工作见真章、出实效。\r\n\r\n　　中共中央政治局委员、国务院副总理、国务院扶贫开发领导小组组长胡春华出席会议并讲话。他指出，要深入贯彻习近平总书记关于扶贫工作的重要论述，进一步提高思想认识和政治站位，全面落实县委书记一线总指挥责任，狠抓脱贫攻坚政策、工作落实。要坚持从严从实、督战一体，较真碰硬彻底整改发现问题。要加快推进脱贫攻坚各项工作，坚决防止松劲懈怠贻误战机，不折不扣完成好目标任务，确保如期打赢脱贫攻坚战。\r\n\r\n　　本次约谈以电视电话会议方式召开。中西部11个省区24位县委书记参加约谈，4位县委书记作代表性发言。\r\n\r\n','中共中央政治局常委、全国政协主席汪洋4月13日在京主持召开脱贫攻坚约谈会议并讲话。他强调，县一级在我们党的组织结构中处于承上启下的关键环节，县委书记是脱贫攻坚的“一线指挥官”。党中央决定直接约谈部分脱贫攻坚任务重和考核发现问题较多县的县委书记，充分体现了对县级脱贫工作的格外重视，对决战决胜脱贫攻坚具有重要意义。约谈既是督战和加压，也是信任和加油。','新冠肺炎，疫情','人民日报','2020-04-14 13:51:31',NUL!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-14 22:06:47