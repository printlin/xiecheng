/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.17-log : Database - xiecheng
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xiecheng` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xiecheng`;

/*Table structure for table `good_info` */

DROP TABLE IF EXISTS `good_info`;

CREATE TABLE `good_info` (
  `good_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `good_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `good_price` float DEFAULT NULL COMMENT '商品价格',
  `good_desc` varchar(50) DEFAULT NULL COMMENT '商品的简介',
  `good_pic` varchar(255) DEFAULT NULL COMMENT '商品的图片',
  `good_count` int(50) DEFAULT NULL COMMENT '商品的数量',
  `good_size` varchar(255) DEFAULT NULL COMMENT '商品的大小',
  `good_color` varchar(50) DEFAULT NULL COMMENT '商品的颜色',
  `good_type` varchar(255) DEFAULT NULL COMMENT '商品类型',
  PRIMARY KEY (`good_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `good_info` */

insert  into `good_info`(`good_id`,`good_name`,`good_price`,`good_desc`,`good_pic`,`good_count`,`good_size`,`good_color`,`good_type`) values 
(3,'耐克官方男子板鞋',449,'Nike 耐克官方 NIKE ESSENTIALIST 男子板鞋 819810','images/板鞋/3.jpg',10,'38-40-42','黑色-天蓝色','耐克'),
(4,'冰蓝耐克滑板鞋',799,'Nike Dunk SB Low IW 冰蓝 耐克滑板鞋 819674-301','images/板鞋/4.jpg',9,'37-38-41','黑色-红色','耐克'),
(5,'耐克女鞋AIR板鞋',469,'耐克女鞋AIR FORCE 1 板鞋NIKE AF1全白低帮男鞋315122','images/板鞋/5.jpg',14,'39-42','黑色-粉红色','耐克'),
(6,'乔丹女板鞋2017春季新品',375,'乔丹女板鞋2017春季新品高帮女板鞋休闲鞋时尚街头风格板鞋休闲鞋','images/板鞋/6.jpg',6,'41-42-43','粉红色-红色','乔丹'),
(7,'乔丹板鞋男鞋韩版',139,'乔丹板鞋男鞋韩版低帮网面学生白色滑板鞋休闲鞋','images/板鞋/7.jpg',8,'40-42-44','黑色-红色','乔丹'),
(8,'安踏男板鞋',149,'安踏男鞋 板鞋男2017新款男士休闲运动鞋 白色低帮滑板鞋','images/板鞋/8.jpg',9,'38-41-43','白色','安踏'),
(9,'安踏男时尚板鞋',169,'安踏男鞋板鞋轻便休闲鞋时尚运动滑板鞋','images/板鞋/9.jpg',13,'40-41-44','深蓝色-亮酒红色','安踏'),
(10,'心尚体育实战篮球鞋',428,'心尚体育 NIKE ZOOM EVIDENCE 实战篮球鞋','images/篮球鞋/1.jpg',20,'38-40-42-44','蓝色-黑色','耐克'),
(11,'耐克男子篮球运动鞋',519,'Nike 耐克官方 NIKE MAMBA INSTINCT EP 男子篮球运动鞋','images/篮球鞋/2.jpg',15,'39-41-43','黑色-红色','耐克'),
(12,'阿迪达斯篮球鞋',499,'adidas 阿迪达斯 篮球 男子 场下款篮球鞋 GVP MID','images/篮球鞋/3.jpg',10,'39-42','蓝色-红色-黑色','阿迪达斯'),
(13,'耐克运动篮球鞋',749,'耐克Nike Kyrie 3 欧文3 象牙白 男鞋实战运动篮球鞋','images/篮球鞋/4.jpg',9,'41-42-44','蓝色-黑色-白色','耐克'),
(14,'安踏篮球鞋',339,'安踏篮球鞋男鞋2017秋季新款运动鞋男气垫缓震耐磨高帮篮球鞋战靴','images/篮球鞋/5.jpg',8,'37-39-42','红色-白色-蓝色','安踏'),
(15,'乔丹篮球鞋男鞋',249,'乔丹篮球鞋男鞋夏季新款透气水泥地高帮战靴耐磨球鞋运动鞋男鞋子','images/篮球鞋/6.jpg',15,'40-44','红色-白色','乔丹'),
(16,'阿迪达斯篮球鞋',365,'adidas 阿迪达斯 篮球 男子 罗斯系列场上款篮球鞋 D ROSE 773 V','images/篮球鞋/7.jpg',9,'40-43-44','蓝色-红色-黑色','阿迪达斯'),
(17,'安踏新款篮球鞋',269,'安踏篮球鞋男鞋2017新款正品气垫球鞋运动鞋男高帮水泥地耐磨战靴','images/篮球鞋/8.jpg',5,'39-41-44','白色-黑色','安踏'),
(18,'乔丹新款篮球鞋',199,'乔丹篮球鞋男2017春季新款高帮学生运动鞋男减震耐磨球鞋黑红战靴','images/篮球鞋/9.jpg',18,'39-41-43','红色-白色-蓝色','乔丹'),
(19,'安踏网面透气休闲鞋',329,'安踏男鞋 跑鞋新款全掌气垫鞋减震跑步鞋 网面透气休闲鞋运动鞋男','images/休闲鞋/1.jpg',14,'38-42-43','白色-黑色','安踏'),
(20,'安踏男鞋休闲鞋',259,'安踏男鞋跑鞋2017轻便透气潮百搭休闲鞋全黑慢跑鞋黑武士运动鞋男','images/休闲鞋/2.jpg',16,'39-43','白色-黑色','安踏'),
(21,'耐克女鞋',499,'耐克女鞋/Nike Air Max Thea女子气垫休闲跑步鞋599409 599728','images/休闲鞋/3.jpg',13,'38-42-44','蓝色-黑色','耐克'),
(22,'阿迪达斯男鞋',418,'阿迪达斯男鞋板鞋2017夏秋季新款中高帮网球鞋运动鞋休闲鞋B74256','images/休闲鞋/4.jpg',9,'37-40-41','白色-黑色-天蓝色','阿迪达斯'),
(23,'NIKE休闲鞋',799,'NIKE LUNAREPIC LOW FLYKNIT 男子登月跑步鞋','images/休闲鞋/5.jpg',12,'38-42-43','白色-黑色','耐克'),
(24,'正品nike耐克男鞋',439,'nike耐克男鞋Kaishi时尚休闲运动鞋轻便减震透气跑步鞋','images/休闲鞋/6.jpg',4,'39-41-44','深蓝色-黑色','耐克'),
(25,'阿迪达斯男鞋',399,'阿迪达斯男鞋三叶草女鞋ZX700 750新款跑步运动休闲板鞋','images/休闲鞋/7.jpg',7,'38-39-40','红色-黑色','阿迪达斯'),
(26,'乔丹男鞋跑步鞋',209,'乔丹男鞋跑步鞋运动鞋男夏季透气网面编织跑鞋轻便休闲鞋旅游鞋子','images/休闲鞋/8.jpg',6,'37-39-41','白色-棕色','乔丹'),
(27,'乔丹女鞋运动鞋',209,'乔丹女鞋运动鞋女春季休闲鞋减震跑步鞋女轻便旅游鞋耐磨气垫鞋潮','images/休闲鞋/9.jpg',14,'37-42-43','黄色-黑色','乔丹'),
(28,'1',10,'10',NULL,10,'37','白色','安踏');

/*Table structure for table `good_type` */

DROP TABLE IF EXISTS `good_type`;

CREATE TABLE `good_type` (
  `type_id` int(20) NOT NULL COMMENT '类别id',
  `type_name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `type_desc` varchar(50) DEFAULT NULL COMMENT '类别的简介',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `good_type` */

/*Table structure for table `order_good` */

DROP TABLE IF EXISTS `order_good`;

CREATE TABLE `order_good` (
  `ord_good_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '详情id',
  `ord_id` int(20) DEFAULT NULL COMMENT '订单id',
  `good_id` int(20) DEFAULT NULL COMMENT '商品id',
  `good_size` varchar(255) DEFAULT NULL COMMENT '商品大小',
  `good_color` varchar(50) DEFAULT NULL COMMENT '商品颜色',
  PRIMARY KEY (`ord_good_id`),
  KEY `ord_id` (`ord_id`),
  KEY `good_id` (`good_id`),
  CONSTRAINT `order_good_ibfk_1` FOREIGN KEY (`ord_id`) REFERENCES `order_info` (`ord_id`),
  CONSTRAINT `order_good_ibfk_2` FOREIGN KEY (`good_id`) REFERENCES `good_info` (`good_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_good` */

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `ord_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `ord_u_name` varchar(50) DEFAULT NULL COMMENT '收货人姓名',
  `ord_u_add` varchar(50) DEFAULT NULL COMMENT '收货人地址',
  `ord_price` float DEFAULT NULL COMMENT '订单总额',
  `ord_type` varchar(20) DEFAULT NULL COMMENT '订单状态',
  `ord_date` varchar(20) DEFAULT NULL COMMENT '订单日期',
  `u_id` int(20) DEFAULT NULL COMMENT '用户ID（外键）',
  `ord_u_phone` varchar(11) DEFAULT NULL COMMENT '收货人电话',
  `ord_count` varchar(255) DEFAULT NULL COMMENT '商品id集',
  PRIMARY KEY (`ord_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `order_info_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user_info` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `order_info` */

insert  into `order_info`(`ord_id`,`ord_u_name`,`ord_u_add`,`ord_price`,`ord_type`,`ord_date`,`u_id`,`ord_u_phone`,`ord_count`) values 
(1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL),
(5,'1','5',4,'1','2',1,NULL,NULL),
(10,NULL,NULL,139,'未付款','2017-06-14 15:27:20',2,NULL,'1'),
(11,NULL,NULL,375,'未付款','2017-06-14 15:37:32',2,NULL,'1'),
(12,NULL,NULL,139,'未付款','2017-06-14 15:39:02',2,NULL,'1'),
(13,'1','3',449,'已付款','2017-06-14 15:41:01',2,'2','1'),
(14,NULL,NULL,1512,'未付款','2017-06-14 16:12:05',2,NULL,'4'),
(15,NULL,'ee',2450,'未付款','2017-06-14 16:16:34',2,NULL,'6'),
(16,NULL,NULL,1137,'未付款','2017-06-14 16:17:46',2,NULL,'3'),
(17,NULL,NULL,1137,'未付款','2017-06-14 16:18:18',2,NULL,'3'),
(18,NULL,NULL,2450,'未付款','2017-06-14 16:23:26',2,NULL,'6'),
(19,'123','111',1961,'已付款','2017-06-14 16:26:44',2,'123','5'),
(20,NULL,NULL,449,'未付款','2017-06-14 16:32:50',2,NULL,'1'),
(21,'杨','重庆市巴南区重庆工程学院',549,'未付款','2017-06-15 09:51:02',2,'18184075666','5-'),
(22,'杨','重庆市巴南区重庆工程学院',898,'未付款','2017-06-15 10:29:37',2,'18184075666','6-7-'),
(23,'杨','重庆市巴南区重庆工程学院',259,'已付款','2017-06-15 10:32:46',2,'18184075666','1'),
(24,'杨','重庆市巴南区重庆工程学院',499,'未付款','2017-06-15 10:50:37',2,'18184075666','1');

/*Table structure for table `shopping_cart` */

DROP TABLE IF EXISTS `shopping_cart`;

CREATE TABLE `shopping_cart` (
  `shop_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '购物车Id',
  `good_id` int(20) DEFAULT NULL COMMENT '商品id',
  `good_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `good_count` int(20) DEFAULT NULL COMMENT '商品数量',
  `good_price` float DEFAULT NULL COMMENT '商品价格',
  `u_id` int(20) DEFAULT NULL COMMENT '用户id',
  `good_pic` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `good_color` varchar(255) DEFAULT NULL COMMENT '颜色',
  `good_size` varchar(255) DEFAULT NULL COMMENT '大小',
  PRIMARY KEY (`shop_id`),
  KEY `u_id` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `shopping_cart` */

insert  into `shopping_cart`(`shop_id`,`good_id`,`good_name`,`good_count`,`good_price`,`u_id`,`good_pic`,`good_color`,`good_size`) values 
(2,1,'阿迪达斯女子板鞋',1,499,123456,'images/板鞋/1.jpg','红色','38'),
(3,1,'阿迪达斯女子板鞋',1,499,123456,'images/板鞋/1.jpg','粉色','38'),
(4,1,'阿迪达斯女子板鞋',1,499,123456,'images/板鞋/1.jpg','红色','37');

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `u_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `u_pwd` varchar(20) DEFAULT NULL COMMENT '密码',
  `u_address` varchar(50) DEFAULT NULL COMMENT '收货人地址',
  `u_birth` varchar(200) DEFAULT NULL COMMENT '出生日期',
  `u_gender` varchar(10) DEFAULT NULL COMMENT '性别',
  `u_num` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `u_money` varchar(255) DEFAULT NULL COMMENT '余额',
  `u_name` varchar(50) DEFAULT NULL COMMENT '收货人姓名',
  `type` varchar(20) DEFAULT NULL COMMENT '用户类型',
  `u_pic` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

insert  into `user_info`(`username`,`u_id`,`u_pwd`,`u_address`,`u_birth`,`u_gender`,`u_num`,`u_money`,`u_name`,`type`,`u_pic`) values 
(NULL,1,'55','klk',NULL,'1','51',NULL,NULL,NULL,NULL),
('123456',2,'456789','重庆市巴南区重庆工程学院',NULL,NULL,'18184075666','95396.0','杨','管理员','images\\user\\1497453797833.jpg'),
('胡主席',3,'123456',NULL,NULL,NULL,NULL,'100000000',NULL,'用户','images\\user\\1497495238882.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
