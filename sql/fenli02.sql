-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.27 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `test`;

-- 导出  表 test.alipay 结构
CREATE TABLE IF NOT EXISTS `alipay` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ordertoken` varchar(50) NOT NULL DEFAULT '0',
  `time` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `ordertoken` (`ordertoken`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  test.alipay 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `alipay` DISABLE KEYS */;
INSERT INTO `alipay` (`id`, `ordertoken`, `time`) VALUES
	(1, '16683238962282314', '2022-11-13'),
	(2, '16683239673153224', '2022-11-13'),
	(3, '1668324024260411', '2022-11-13'),
	(4, '1668324107228235', '2022-11-13'),
	(5, '1668324174228235', '2022-11-13');
/*!40000 ALTER TABLE `alipay` ENABLE KEYS */;

-- 导出  表 test.editortest 结构
CREATE TABLE IF NOT EXISTS `editortest` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `avater` text,
  `test` text,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `name1` (`time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  test.editortest 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `editortest` DISABLE KEYS */;
INSERT INTO `editortest` (`id`, `title`, `avater`, `test`, `time`) VALUES
	(1, '方便面', 'http://localhost:8080/file/img/屏幕截图 2022-05-06 201238.png', '<p><br/><img src="http://localhost:8080/file/img/屏幕截图 2022-05-06 201238.png" style="max-width:100%;" contenteditable="false"/></p><p>\n</p><p>方便面（Instant Noodles），又称<a target="_blank" href="https://baike.baidu.com/item/%E5%BF%AB%E9%A4%90%E9%9D%A2/10864030?fromModule=lemma_inlink">快餐面</a>、<a target="_blank" href="https://baike.baidu.com/item/%E6%B3%A1%E9%9D%A2/1249584?fromModule=lemma_inlink">泡面</a>、<a target="_blank" href="https://baike.baidu.com/item/%E6%9D%AF%E9%9D%A2/6165204?fromModule=lemma_inlink">杯面</a>、<a target="_blank" href="https://baike.baidu.com/item/%E5%BF%AB%E7%86%9F%E9%9D%A2/6165968?fromModule=lemma_inlink">快熟面</a>、<a target="_blank" href="https://baike.baidu.com/item/%E9%80%9F%E9%A3%9F%E9%9D%A2/6165083?fromModule=lemma_inlink">速食面</a>、<a target="_blank" href="https://baike.baidu.com/item/%E5%8D%B3%E9%A3%9F%E9%9D%A2/6165950?fromModule=lemma_inlink">即食面</a>，南方一般称为碗面，香港则称之为<a target="_blank" href="https://baike.baidu.com/item/%E5%85%AC%E4%BB%94%E9%9D%A2/6164914?fromModule=lemma_inlink">公仔面</a>。是一种可在短时间之内用热水泡熟食用的面制<a target="_blank" href="https://baike.baidu.com/item/%E9%A3%9F%E5%93%81/174284?fromModule=lemma_inlink">食品</a>。广义上是指一种可在短时间之内用热水泡熟食用的面制食品，有相关的菜肴如归<a target="_blank" href="https://baike.baidu.com/item/%E6%B3%A1%E9%9D%A2/1249584?fromModule=lemma_inlink">泡面</a>、泡面沙拉等；狭义的方便面上通常指由<a target="_blank" href="https://baike.baidu.com/item/%E9%9D%A2%E9%A5%BC/9248981?fromModule=lemma_inlink">面饼</a>、调料包及油包组成的销售成品，市面上以袋装和杯或碗装居多。<a target="_blank" href="https://baike.baidu.com/item/%E5%AE%89%E8%97%A4%E7%99%BE%E7%A6%8F/11023389?fromModule=lemma_inlink">安藤百福</a>在1958年发明了方便面，随着生活节奏加快及旅行需要，方便面成为现代生活不可或缺的简易食品之一。</p><p>哈哈哈哈<br/></p>', '2022-10-25 17:24:50'),
	(4, '矿泉水', 'http://localhost:8080/file/img/屏幕截图 2022-05-08 184557.png', '<p>矿泉水真好喝<span>😍<span>😍<span>😍</span></span></span></p><p><span><span><span><span>😚<span>😙<span>😙</span></span></span></span></span></span></p>', '2022-10-25 18:52:06'),
	(5, '大熊', 'http://localhost:8080/file/img/屏幕截图 2022-04-23 152401.png', '<p>大熊A</p><p>大熊B</p><p>大熊C</p><p>大熊D</p><p>大熊E</p><p>大熊F</p><p>大熊G</p><p><span><span><span></span></span></span></p>', '2022-10-25 18:53:21'),
	(7, '大熊MAO', 'http://localhost:8080/file/img/屏幕截图 2022-04-23 152419.png', '<p><img src="http://localhost:8080/file/img/屏幕截图 2022-04-23 152345.png" style="max-width:100%;" contenteditable="false"/><img src="http://localhost:8080/file/img/屏幕截图 2022-04-23 152332.png" style="max-width:100%;" contenteditable="false"/><img src="http://localhost:8080/file/img/屏幕截图 2022-04-23 152401.png" style="max-width:100%;" contenteditable="false"/><img src="http://localhost:8080/file/img/屏幕截图 2022-04-23 152419.png" style="max-width:100%;" contenteditable="false"/><img src="http://localhost:8080/file/img/屏幕截图 2022-04-23 152449.png" style="max-width:100%;" contenteditable="false"/><br/></p>', '2022-10-25 20:25:16'),
	(8, '张三', 'http://localhost:8080/file/img/屏幕截图 2022-10-25 203050.png', '<p><iframe src="//player.bilibili.com/player.html?aid=559357902&amp;bvid=BV1We4y1U7pH&amp;cid=868005620&amp;page=1" scrolling="no" border="0" framespacing="0" allowfullscreen="true" frameborder="no"> </iframe></p><p><br/><br/></p>', '2022-10-25 20:31:07'),
	(9, '凡人修仙传', 'http://localhost:8080/file/img/屏幕截图 2022-10-26 165119.png', '<p><iframe src="//player.bilibili.com/player.html?aid=646734705&amp;bvid=BV12e4y1j7QE&amp;cid=864205831&amp;page=1" scrolling="no" border="0" framespacing="0" allowfullscreen="true" frameborder="no"> </iframe></p><p><br/><br/></p><p></p>', '2022-10-26 16:52:50'),
	(10, 'haha2', 'http://localhost:8080/file/img/屏幕截图 2022-06-05 191533.png', '<p><span>😁</span></p><p><span><img src="http://localhost:8080/file/img/屏幕截图 2022-06-05 191533.png" style="max-width:100%;" contenteditable="false"/><br/></span></p>', '2022-10-30 15:36:00'),
	(11, '分库分表', 'http://localhost:8080/file/img/屏幕截图 2022-06-05 191515.png', '<p><iframe src="//player.bilibili.com/player.html?aid=855862388&amp;bvid=BV1ZV4y1n7B8&amp;cid=771276836&amp;page=1" scrolling="no" border="0" framespacing="0" allowfullscreen="true" frameborder="no"> </iframe></p><p><br/><br/></p>', '2022-10-31 09:44:03'),
	(12, '第一次双黄蛋', 'http://localhost:8080/file/img/屏幕截图_20221107_135201.png', '<p><img src="http://localhost:8080/file/img/屏幕截图 2022-11-07 135203.png" style="max-width:100%;" contenteditable="false"/><img src="http://localhost:8080/file/img/屏幕截图_20221107_135201.png" style="max-width:100%;" contenteditable="false"/><br/></p>', '2022-11-10 19:09:29');
/*!40000 ALTER TABLE `editortest` ENABLE KEYS */;

-- 导出  表 test.files 结构
CREATE TABLE IF NOT EXISTS `files` (
  `id` int NOT NULL AUTO_INCREMENT,
  `filename` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `size` bigint DEFAULT NULL,
  `avater` text,
  `check` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  test.files 的数据：~22 rows (大约)
/*!40000 ALTER TABLE `files` DISABLE KEYS */;
INSERT INTO `files` (`id`, `filename`, `type`, `size`, `avater`, `check`) VALUES
	(1, '屏幕截图 2022-07-22 001437.png', 'png', 57131, 'http://localhost:8080/file/img/屏幕截图 2022-07-22 001437.png', 0),
	(4, '屏幕截图 2022-04-23 152449.png', 'png', 66311, 'http://localhost:8080/file/img/屏幕截图 2022-04-23 152449.png', 1),
	(5, '屏幕截图 2022-04-09 143903.png', 'png', 301211, 'http://localhost:8080/file/img/屏幕截图 2022-04-09 143903.png', 0),
	(6, '屏幕截图 2022-04-23 152332.png', 'png', 59779, 'http://localhost:8080/file/img/屏幕截图 2022-04-23 152332.png', 1),
	(8, '屏幕截图 2022-04-23 152401.png', 'png', 46494, 'http://localhost:8080/file/img/屏幕截图 2022-04-23 152401.png', 1),
	(9, '屏幕截图 2022-04-09 105010.png', 'png', 130938, 'http://localhost:8080/file/img/屏幕截图 2022-04-09 105010.png', 0),
	(10, '屏幕截图 2022-05-06 201238.png', 'png', 124272, 'http://localhost:8080/file/img/屏幕截图 2022-05-06 201238.png', 0),
	(11, '屏幕截图 2022-06-05 192958.png', 'png', 181748, 'http://localhost:8080/file/img/屏幕截图 2022-06-05 192958.png', 0),
	(12, '屏幕截图 2022-04-23 152419.png', 'png', 64099, 'http://localhost:8080/file/img/屏幕截图 2022-04-23 152419.png', 0),
	(21, '屏幕截图 2022-04-23 152427.png', 'png', 55341, 'http://localhost:8080/file/img/屏幕截图 2022-04-23 152427.png', 0),
	(30, '用户信息.xlsx', 'xlsx', 10191, 'http://localhost:8080/file/img/用户信息.xlsx', 0),
	(31, 'ct.gif', 'gif', 238012, 'http://localhost:8080/file/img/ct.gif', 1),
	(32, 'haha.mp4', 'mp4', 5476096, 'http://localhost:8080/file/img/haha.mp4', 0),
	(33, 'bishe.zip', 'zip', 43190506, 'http://localhost:8080/file/img/bishe.zip', 0),
	(34, '25097db9352238981be08103bd10de9.jpg', 'jpg', 306253, 'http://localhost:8080/file/img/25097db9352238981be08103bd10de9.jpg', 0),
	(35, '8e2e9b9e65904cce9375affdbd2b146.jpg', 'jpg', 87964, 'http://localhost:8080/file/img/8e2e9b9e65904cce9375affdbd2b146.jpg', 0),
	(37, '屏幕截图 2022-06-06 082600.png', 'png', 1730617, 'http://localhost:8080/file/img/屏幕截图 2022-06-06 082600.png', 1),
	(38, 'gg.png', 'png', 215085, 'http://localhost:8080/file/img/gg.png', 0),
	(39, 'k.png', 'png', 92336, 'http://localhost:8080/file/img/k.png', 0),
	(40, '屏幕截图 2022-05-08 184557.png', 'png', 244180, 'http://localhost:8080/file/img/屏幕截图 2022-05-08 184557.png', 0),
	(41, '屏幕截图 2022-04-23 152345.png', 'png', 65941, 'http://localhost:8080/file/img/屏幕截图 2022-04-23 152345.png', 0),
	(42, '屏幕截图 2022-10-25 203050.png', 'png', 503512, 'http://localhost:8080/file/img/屏幕截图 2022-10-25 203050.png', 0),
	(43, '屏幕截图_20221025_203048.png', 'png', 503512, 'http://localhost:8080/file/img/屏幕截图_20221025_203048.png', 0),
	(44, 'R-C.png', 'png', 208285, 'http://localhost:8080/file/img/R-C.png', 0),
	(45, '屏幕截图 2022-10-26 165119.png', 'png', 261168, 'http://localhost:8080/file/img/屏幕截图 2022-10-26 165119.png', 0),
	(46, '屏幕截图 2022-06-05 191533.png', 'png', 141818, 'http://localhost:8080/file/img/屏幕截图 2022-06-05 191533.png', 0),
	(47, '屏幕截图 2022-06-05 191515.png', 'png', 94665, 'http://localhost:8080/file/img/屏幕截图 2022-06-05 191515.png', 0),
	(48, '屏幕截图_20221107_135201.png', 'png', 1937339, 'http://localhost:8080/file/img/屏幕截图_20221107_135201.png', 0),
	(49, '屏幕截图 2022-11-07 135203.png', 'png', 1937339, 'http://localhost:8080/file/img/屏幕截图 2022-11-07 135203.png', 0);
/*!40000 ALTER TABLE `files` ENABLE KEYS */;

-- 导出  事件 test.orderTime 结构
DELIMITER //
CREATE EVENT `orderTime` ON SCHEDULE EVERY 1 DAY STARTS '2022-11-13 00:00:00' ON COMPLETION NOT PRESERVE ENABLE DO BEGIN
    TRUNCATE TABLE alipay;
END//
DELIMITER ;

-- 导出  表 test.role 结构
CREATE TABLE IF NOT EXISTS `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  test.role 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `role`) VALUES
	(1, '普通用户'),
	(2, 'vip'),
	(3, '管理员'),
	(7, '测试'),
	(8, '程序员');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- 导出  表 test.second 结构
CREATE TABLE IF NOT EXISTS `second` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `token` text,
  `avater` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  test.second 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `second` DISABLE KEYS */;
INSERT INTO `second` (`id`, `username`, `password`, `create_time`, `token`, `avater`, `role`) VALUES
	(1, 'admin', '1234', '2022-09-25 00:00:00', NULL, 'http://localhost:8080/file/img/屏幕截图 2022-06-06 082600.png', '管理员'),
	(2, 'zmh', '1234', '2022-09-26 00:00:00', NULL, 'http://localhost:8080/file/img/8e2e9b9e65904cce9375affdbd2b146.jpg', 'vip'),
	(3, '张明辉', '1234', '2022-09-26 00:00:00', NULL, 'http://localhost:8080/file/img/屏幕截图 2022-04-23 152332.png', '普通用户'),
	(8, 'user', '1234', '2022-09-27 00:00:00', NULL, 'http://localhost:8080/file/img/屏幕截图 2022-04-23 152427.png', '普通用户'),
	(17, 'liu', '1234', '2022-10-05 16:31:59', NULL, 'http://localhost:8080/file/img/屏幕截图_20221025_203048.png', '普通用户'),
	(19, 'wang', '1234', '2022-10-13 11:01:17', NULL, 'http://localhost:8080/file/img/屏幕截图 2022-04-23 152401.png', '普通用户'),
	(20, 'zmh1', '1234', '2022-10-31 14:30:39', NULL, 'http://localhost:8080/file/img/屏幕截图 2022-04-23 152345.png', 'vip');
/*!40000 ALTER TABLE `second` ENABLE KEYS */;

-- 导出  表 test.shopcar 结构
CREATE TABLE IF NOT EXISTS `shopcar` (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods` varchar(50) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `total` int DEFAULT NULL,
  `user` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `num` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user` (`user`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  test.shopcar 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `shopcar` DISABLE KEYS */;
INSERT INTO `shopcar` (`id`, `goods`, `price`, `total`, `user`, `time`, `num`) VALUES
	(4, '凡人修仙传', 9, 18, 'user', '2022-11-10', 2),
	(5, '第一次双黄蛋', 12, 600, 'user', '2022-11-10', 50),
	(6, '凡人修仙传', 9, 45, '张明辉', '2022-11-12', 5),
	(12, '矿泉水', 4, 4, '张明辉', '2022-11-13', 1),
	(13, '大熊MAO', 7, 7, '张明辉', '2022-11-13', 1);
/*!40000 ALTER TABLE `shopcar` ENABLE KEYS */;

-- 导出  表 test.time 结构
CREATE TABLE IF NOT EXISTS `time` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  test.time 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` (`id`, `name`, `time`) VALUES
	(1, 'admin', '2022-10-28'),
	(2, 'zmh', '2022-10-29'),
	(3, 'liu', '2022-10-29'),
	(4, 'admin', '2022-10-29'),
	(5, 'admin', '2022-10-30'),
	(6, 'zmh', '2022-10-30'),
	(7, 'admin', '2022-10-31'),
	(8, 'wang', '2022-10-31'),
	(9, 'zmh1', '2022-10-31'),
	(10, 'zmh', '2022-10-31'),
	(16, 'admin', '2022-11-08'),
	(17, 'admin', '2022-11-10'),
	(18, 'admin', '2022-11-13');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
