-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: TimeDB
-- ------------------------------------------------------
-- Server version	8.0.29-0ubuntu0.22.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cms_city`
--

DROP TABLE IF EXISTS `cms_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cms_city` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `city_name` varchar(20) NOT NULL,
  `initial_char` varchar(3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cms_city_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cms_city`
--

LOCK TABLES `cms_city` WRITE;
/*!40000 ALTER TABLE `cms_city` DISABLE KEYS */;
INSERT INTO `cms_city` VALUES (1,'2022-06-02 15:05:30','2022-06-02 15:05:30','威海','W'),(2,'2022-06-06 15:14:02','2022-06-06 15:14:02','济南','J'),(3,'2022-06-06 15:14:22','2022-06-06 15:14:22','北京','B'),(4,'2022-06-06 15:14:35','2022-06-06 15:14:36','上海','S');
/*!40000 ALTER TABLE `cms_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_area_info`
--

DROP TABLE IF EXISTS `fms_area_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fms_area_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `area` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fms_area_info_area_uindex` (`area`),
  UNIQUE KEY `fms_area_info_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_area_info`
--

LOCK TABLES `fms_area_info` WRITE;
/*!40000 ALTER TABLE `fms_area_info` DISABLE KEYS */;
INSERT INTO `fms_area_info` VALUES (1,'2022-06-02 15:58:25','2022-06-02 15:58:25','大陆'),(2,'2022-06-02 15:58:25','2022-06-02 15:58:25','美国'),(3,'2022-06-02 15:58:25','2022-06-02 15:58:25','韩国'),(4,'2022-06-02 15:58:25','2022-06-02 15:58:25','日本'),(5,'2022-06-02 15:58:25','2022-06-02 15:58:25','中国香港'),(6,'2022-06-02 15:58:25','2022-06-02 15:58:25','中国台湾'),(7,'2022-06-02 15:58:25','2022-06-02 15:58:25','泰国'),(8,'2022-06-02 15:58:25','2022-06-02 15:58:25','印度');
/*!40000 ALTER TABLE `fms_area_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_film_member_relation`
--

DROP TABLE IF EXISTS `fms_film_member_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fms_film_member_relation` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `film_id` bigint unsigned NOT NULL,
  `member_id` bigint unsigned NOT NULL,
  `is_director` tinyint unsigned NOT NULL,
  `is_actor` tinyint unsigned NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fis_film_member_relation_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_film_member_relation`
--

LOCK TABLES `fms_film_member_relation` WRITE;
/*!40000 ALTER TABLE `fms_film_member_relation` DISABLE KEYS */;
INSERT INTO `fms_film_member_relation` VALUES (1,1,1,0,1,'2022-06-02 16:51:04','2022-06-02 16:51:04'),(3,1,3,0,1,'2022-06-02 16:54:04','2022-06-02 16:54:04'),(4,1,2,1,0,'2022-06-02 16:54:04','2022-06-02 16:54:04');
/*!40000 ALTER TABLE `fms_film_member_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_film_tag`
--

DROP TABLE IF EXISTS `fms_film_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fms_film_tag` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `tag` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fms_tag_film_id_uindex` (`id`),
  UNIQUE KEY `fms_tag_film_tag_uindex` (`tag`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_film_tag`
--

LOCK TABLES `fms_film_tag` WRITE;
/*!40000 ALTER TABLE `fms_film_tag` DISABLE KEYS */;
INSERT INTO `fms_film_tag` VALUES (1,'2022-06-02 15:46:19','2022-06-02 15:46:19','爱情'),(2,'2022-06-02 15:46:19','2022-06-02 15:46:19','喜剧'),(3,'2022-06-02 15:46:19','2022-06-02 15:46:19','动画'),(4,'2022-06-02 15:46:19','2022-06-02 15:46:19','科幻'),(5,'2022-06-02 15:46:19','2022-06-02 15:46:19','动作'),(6,'2022-06-02 15:46:19','2022-06-02 15:46:19','武侠');
/*!40000 ALTER TABLE `fms_film_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_member`
--

DROP TABLE IF EXISTS `fms_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fms_member` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `member_name` varchar(20) NOT NULL,
  `image_md5` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fis_film_member_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_member`
--

LOCK TABLES `fms_member` WRITE;
/*!40000 ALTER TABLE `fms_member` DISABLE KEYS */;
INSERT INTO `fms_member` VALUES (1,'2022-06-02 16:40:56','2022-06-02 16:40:56','哆啦A梦','test_md5'),(2,'2022-06-02 16:40:56','2022-06-02 16:40:56','山口晋','test_md5'),(3,'2022-06-02 16:40:56','2022-06-02 16:40:56','大雄','test_md5');
/*!40000 ALTER TABLE `fms_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_tag_film_relation`
--

DROP TABLE IF EXISTS `fms_tag_film_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fms_tag_film_relation` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `film_id` bigint unsigned NOT NULL,
  `tag_id` bigint unsigned NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fms_tag_film_relation_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_tag_film_relation`
--

LOCK TABLES `fms_tag_film_relation` WRITE;
/*!40000 ALTER TABLE `fms_tag_film_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_tag_film_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `img_info`
--

DROP TABLE IF EXISTS `img_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `img_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `img_md5` varchar(128) NOT NULL,
  `img_url` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `img_table_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `img_info`
--

LOCK TABLES `img_info` WRITE;
/*!40000 ALTER TABLE `img_info` DISABLE KEYS */;
INSERT INTO `img_info` VALUES (1,'2022-06-02 14:39:48','2022-06-02 14:39:48','test_md5','/test/url/img/00001'),(2,'2022-06-07 09:45:02','2022-06-07 09:45:02','test_md5_2','/test/url/img/00002'),(3,'2022-06-07 09:50:56','2022-06-07 09:50:56','test_md5_3','/test/url/img/00003');
/*!40000 ALTER TABLE `img_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main_cinema`
--

DROP TABLE IF EXISTS `main_cinema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main_cinema` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `city_id` bigint unsigned NOT NULL,
  `cinema_name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `service_info` varchar(150) NOT NULL,
  `img_md5` varchar(128) NOT NULL,
  `update_time` datetime NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `main_cinema_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='影院表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main_cinema`
--

LOCK TABLES `main_cinema` WRITE;
/*!40000 ALTER TABLE `main_cinema` DISABLE KEYS */;
INSERT INTO `main_cinema` VALUES (1,1,'新世纪电影城（长春路店）','环翠区长春路帝王宫昌鸿广场5楼（近帝王宫）','1234567890','基本观影服务','test_md5','2022-06-02 15:05:40','2022-06-02 15:05:40'),(2,2,'测试济南影院','济南某角落','12345678900','济南观影服务','test_md5','2022-06-06 15:27:24','2022-06-06 15:27:25'),(3,3,'北京某影院','北京某位置','12345678900','北京观影服务','test_md5','2022-06-06 15:28:20','2022-06-06 15:27:47');
/*!40000 ALTER TABLE `main_cinema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main_film`
--

DROP TABLE IF EXISTS `main_film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main_film` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `film_name` varchar(200) NOT NULL COMMENT '电影名字',
  `is_show` tinyint unsigned NOT NULL COMMENT '是否正在上映',
  `release_time` datetime NOT NULL COMMENT '上市时间',
  `income` bigint NOT NULL COMMENT '票房',
  `score` decimal(10,0) NOT NULL COMMENT '评分',
  `duration` int NOT NULL COMMENT '秒单位',
  `description_f` varchar(3000) DEFAULT NULL COMMENT '电影描述',
  `area_id` bigint unsigned NOT NULL,
  `img_md5` varchar(128) DEFAULT NULL COMMENT '电影图片',
  PRIMARY KEY (`id`),
  UNIQUE KEY `main_film_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='电影表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main_film`
--

LOCK TABLES `main_film` WRITE;
/*!40000 ALTER TABLE `main_film` DISABLE KEYS */;
INSERT INTO `main_film` VALUES (1,'2022-06-02 16:01:16','2022-06-02 16:01:16','哆啦A梦：大雄的宇宙小战争 2021',1,'2022-05-28 08:00:00',41030000,8,6540,'大雄意外结识拇指外星人帕比，在哆啦A梦的帮助下，与大家一起穿越星际共同去守护匹里卡星，并开展了一段奇妙的宇宙冒险。',4,'test_md5'),(2,'2022-06-06 15:29:05','2022-06-06 15:29:06','测试电影2',1,'2022-06-06 15:29:12',22222222,6,2135,'测试描述',1,'test_md5'),(3,'2022-06-06 15:30:35','2022-06-06 15:30:32','测试电影3',1,'2022-06-06 15:30:23',22222222,5,1235,'测试描述',2,'test_md5'),(4,'2022-06-06 15:30:34','2022-06-06 15:30:36','测试电影4',0,'2022-06-06 15:30:24',22222222,4,1235,'测试描述',3,'test_md5');
/*!40000 ALTER TABLE `main_film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main_process`
--

DROP TABLE IF EXISTS `main_process`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main_process` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `film_id` bigint unsigned NOT NULL,
  `cinema_id` bigint unsigned NOT NULL,
  `cost` decimal(10,0) NOT NULL,
  `start_time` datetime NOT NULL,
  `room_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `main_process_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main_process`
--

LOCK TABLES `main_process` WRITE;
/*!40000 ALTER TABLE `main_process` DISABLE KEYS */;
INSERT INTO `main_process` VALUES (1,'2022-06-06 10:48:20','2022-06-06 10:48:21',1,1,20,'2022-06-07 10:48:31','1号普通影厅'),(2,'2022-06-06 10:48:58','2022-06-06 10:48:59',2,1,60,'2022-06-07 10:49:14','3号高级'),(3,'2022-06-06 10:53:20','2022-06-06 10:53:20',1,2,50,'2022-06-06 10:53:28','test_room'),(4,'2022-06-06 15:18:12','2022-06-06 15:18:13',1,1,50,'2022-06-06 15:18:24','2号高级影厅'),(5,'2022-06-06 15:32:10','2022-06-06 15:32:09',2,1,30,'2022-06-06 15:32:03','1号普通'),(6,'2022-06-06 15:32:45','2022-06-06 15:32:43',1,2,15,'2022-06-06 15:32:48','1号普通'),(7,'2022-06-06 15:33:36','2022-06-06 15:33:35',2,2,20,'2022-06-06 15:33:29','1号测试'),(8,'2022-06-06 15:33:39','2022-06-06 15:33:45',2,2,60,'2022-06-06 15:33:52','2号高级');
/*!40000 ALTER TABLE `main_process` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_order`
--

DROP TABLE IF EXISTS `sms_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sms_order` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `user_id` bigint unsigned NOT NULL,
  `process_id` bigint unsigned NOT NULL,
  `seat_info` varchar(1000) NOT NULL,
  `ticket_num` smallint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sms_order_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_order`
--

LOCK TABLES `sms_order` WRITE;
/*!40000 ALTER TABLE `sms_order` DISABLE KEYS */;
INSERT INTO `sms_order` VALUES (1,'2022-06-06 23:52:49','2022-06-06 23:52:49',1,1,'(0,2)',1),(3,'2022-06-09 16:21:28','2022-06-09 16:21:28',1,4,'(0,4) (0,5) (0,6) (0,7) ',4);
/*!40000 ALTER TABLE `sms_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_seat_info`
--

DROP TABLE IF EXISTS `sms_seat_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sms_seat_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `process_id` bigint unsigned NOT NULL,
  `row_num` smallint DEFAULT NULL COMMENT '行数',
  `column_num` smallint NOT NULL,
  `seat_arrangement` varchar(500) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sms_seat_info_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_seat_info`
--

LOCK TABLES `sms_seat_info` WRITE;
/*!40000 ALTER TABLE `sms_seat_info` DISABLE KEYS */;
INSERT INTO `sms_seat_info` VALUES (1,'2022-06-06 10:38:16','2022-06-06 10:38:17',1,5,4,'{\"seatMsg\":[[2,3,2,1],[3,1,2,0],[3,2,1,3],[0,2,2,3],[1,0,1,3]]}'),(2,'2022-06-06 21:06:22','2022-06-06 21:06:22',2,10,9,'{\"seatMsg\":[[2, 0, 1, 2, 3, 2, 3, 3, 3], [1, 2, 3, 1, 0, 1, 2, 1, 3], [3, 1, 2, 2, 3, 3, 1, 1, 0], [2, 1, 2, 3, 3, 3, 1, 2, 3], [2, 0, 1, 2, 2, 2, 2, 3, 1], [2, 2, 0, 1, 2, 0, 0, 2, 0], [2, 2, 3, 0, 1, 1, 3, 0, 1], [2, 0, 3, 0, 2, 1, 1, 1, 1], [3, 1, 2, 2, 1, 3, 1, 0, 3], [2, 2, 3, 1, 1, 3, 2, 2, 1]]}'),(3,'2022-06-06 21:06:22','2022-06-06 21:06:22',3,10,5,'{\"seatMsg\":[[2, 0, 3, 1, 0], [1, 1, 3, 2, 1], [2, 3, 2, 2, 3], [3, 0, 2, 1, 0], [0, 0, 0, 3, 0], [1, 2, 2, 1, 0], [2, 3, 2, 2, 2], [2, 2, 1, 0, 0], [0, 3, 1, 0, 1], [0, 1, 1, 3, 0]]}'),(4,'2022-06-06 21:06:22','2022-06-06 21:06:22',4,5,12,'{\"seatMsg\":[[3, 3, 2, 1, 2, 2, 2, 2, 0, 2, 1, 0], [2, 1, 2, 1, 1, 2, 3, 0, 3, 0, 2, 3], [1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 2, 0], [2, 1, 0, 0, 2, 0, 2, 0, 1, 1, 3, 0], [0, 3, 3, 0, 3, 1, 0, 3, 3, 3, 3, 1]]}'),(11,'2022-06-07 09:53:49','2022-06-07 09:53:49',5,5,12,'{\"seatMsg\":[[3, 0, 0, 3, 1, 2, 2, 3, 0, 2, 3, 3], [0, 0, 3, 1, 3, 3, 2, 1, 3, 1, 0, 2], [3, 1, 0, 1, 3, 3, 0, 1, 0, 1, 1, 2], [0, 0, 2, 0, 2, 0, 0, 3, 0, 2, 3, 1], [0, 3, 0, 0, 0, 2, 1, 0, 3, 0, 1, 1]]}'),(12,'2022-06-07 09:53:49','2022-06-07 09:53:49',6,11,11,'{\"seatMsg\":[[0, 3, 2, 3, 1, 3, 2, 0, 3, 2, 1], [1, 1, 1, 0, 1, 3, 1, 2, 3, 3, 1], [3, 3, 2, 2, 1, 1, 1, 2, 0, 1, 3], [3, 2, 3, 3, 2, 2, 3, 2, 0, 0, 1], [2, 2, 3, 1, 3, 3, 3, 1, 0, 0, 2], [3, 0, 1, 3, 1, 0, 1, 0, 1, 0, 0], [0, 2, 1, 0, 1, 0, 0, 0, 1, 2, 0], [0, 1, 0, 3, 1, 1, 3, 3, 0, 1, 3], [0, 3, 2, 3, 3, 1, 0, 2, 1, 2, 0], [2, 1, 2, 2, 3, 0, 3, 0, 2, 2, 0], [0, 0, 3, 3, 3, 0, 3, 3, 3, 0, 0]]}'),(13,'2022-06-07 09:53:49','2022-06-07 09:53:49',7,7,5,'{\"seatMsg\":[[1, 2, 3, 3, 1], [0, 0, 2, 3, 3], [1, 1, 1, 1, 0], [2, 1, 1, 0, 1], [2, 3, 1, 0, 3], [3, 1, 2, 3, 2], [1, 3, 0, 1, 2]]}'),(14,'2022-06-07 09:54:35','2022-06-07 09:54:35',8,4,14,'{\"seatMsg\":[[3, 2, 0, 0, 2, 3, 3, 0, 0, 1, 0, 2, 2, 2], [3, 3, 0, 3, 1, 3, 1, 0, 1, 1, 2, 0, 2, 1], [3, 0, 3, 3, 2, 0, 2, 3, 2, 3, 0, 1, 2, 0], [0, 1, 0, 1, 3, 0, 0, 0, 2, 0, 3, 0, 0, 0]]}');
/*!40000 ALTER TABLE `sms_seat_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_comment`
--

DROP TABLE IF EXISTS `ums_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ums_comment` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `user_id` bigint unsigned NOT NULL,
  `film_id` bigint unsigned NOT NULL,
  `content` varchar(2000) NOT NULL,
  `score` int unsigned NOT NULL,
  `thumb_num` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ums_comment_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_comment`
--

LOCK TABLES `ums_comment` WRITE;
/*!40000 ALTER TABLE `ums_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `ums_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_permission`
--

DROP TABLE IF EXISTS `ums_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ums_permission` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(50) DEFAULT NULL COMMENT '权限名字',
  `uri` varchar(50) NOT NULL COMMENT '权限URI',
  `descriptions` varchar(200) NOT NULL COMMENT '权限描述',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ums_resource_id_uindex` (`id`),
  UNIQUE KEY `ums_resource_uri_uindex` (`uri`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_permission`
--

LOCK TABLES `ums_permission` WRITE;
/*!40000 ALTER TABLE `ums_permission` DISABLE KEYS */;
INSERT INTO `ums_permission` VALUES (1,'获取城市列表','/getAddrs','获取城市列表','2022-06-06 00:41:32','2022-06-06 00:41:37'),(2,'获得电影列表','/film/getList','获取电影列表，可以按照params筛选或排序，筛选包括tag, area, years,排序包括hot, time, score','2022-06-06 00:44:18','2022-06-06 00:44:19');
/*!40000 ALTER TABLE `ums_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_role`
--

DROP TABLE IF EXISTS `ums_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ums_role` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(40) NOT NULL COMMENT '角色名字',
  `descriptions` varchar(200) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ums_role_id_uindex` (`id`),
  UNIQUE KEY `ums_role_role_name_uindex` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_role`
--

LOCK TABLES `ums_role` WRITE;
/*!40000 ALTER TABLE `ums_role` DISABLE KEYS */;
INSERT INTO `ums_role` VALUES (1,'总管理员','拥有全部权限','2022-06-06 00:42:41','2022-06-06 00:42:42');
/*!40000 ALTER TABLE `ums_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_role_permission_relation`
--

DROP TABLE IF EXISTS `ums_role_permission_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ums_role_permission_relation` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `role_id` bigint unsigned NOT NULL COMMENT '角色id',
  `permission_id` bigint unsigned NOT NULL COMMENT '权限id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ums_role_resource_relation_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色权限关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_role_permission_relation`
--

LOCK TABLES `ums_role_permission_relation` WRITE;
/*!40000 ALTER TABLE `ums_role_permission_relation` DISABLE KEYS */;
INSERT INTO `ums_role_permission_relation` VALUES (1,1,1,'2022-06-06 00:44:33','2022-06-06 00:44:34'),(2,1,2,'2022-06-06 00:44:40','2022-06-06 00:44:41');
/*!40000 ALTER TABLE `ums_role_permission_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_user`
--

DROP TABLE IF EXISTS `ums_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ums_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `username` varchar(50) NOT NULL,
  `password_u` varchar(100) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `avatar_md5` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ums_user_id_uindex` (`id`),
  UNIQUE KEY `ums_user_nickname_uindex` (`nickname`),
  UNIQUE KEY `ums_user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_user`
--

LOCK TABLES `ums_user` WRITE;
/*!40000 ALTER TABLE `ums_user` DISABLE KEYS */;
INSERT INTO `ums_user` VALUES (1,'2022-06-02 14:40:12','2022-06-02 14:40:12','admin','$2a$10$nQpDfUgkZFFkqcU95Ypiy.TpQ.pwbkSe.fbChb0BZ8QRcU4Oy2cN.','admin','test_md5');
/*!40000 ALTER TABLE `ums_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_user_role_relation`
--

DROP TABLE IF EXISTS `ums_user_role_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ums_user_role_relation` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint unsigned NOT NULL COMMENT '用户id',
  `role_id` bigint unsigned NOT NULL COMMENT '角色id',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ums_user_role_relation_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_user_role_relation`
--

LOCK TABLES `ums_user_role_relation` WRITE;
/*!40000 ALTER TABLE `ums_user_role_relation` DISABLE KEYS */;
INSERT INTO `ums_user_role_relation` VALUES (1,1,1,'2022-06-06 00:42:11','2022-06-06 00:42:12');
/*!40000 ALTER TABLE `ums_user_role_relation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-09 20:22:35
