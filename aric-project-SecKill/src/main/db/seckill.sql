/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.13 : Database - sec-kill
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sec-kill` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sec-kill`;

/*Table structure for table `t_account` */

DROP TABLE IF EXISTS `t_account`;

CREATE TABLE `t_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_account` */

/*Table structure for table `t_seckill_details` */

DROP TABLE IF EXISTS `t_seckill_details`;

CREATE TABLE `t_seckill_details` (
  `stock_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `state` int(1) NOT NULL DEFAULT '-1' COMMENT '-1,无效，0,成功，1，发货，2,签收',
  `create_time` timestamp NOT NULL,
  PRIMARY KEY (`stock_id`,`account_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `t_seckill_details_ibfk_1` FOREIGN KEY (`stock_id`) REFERENCES `t_stock` (`stock_id`),
  CONSTRAINT `t_seckill_details_ibfk_2` FOREIGN KEY (`account_id`) REFERENCES `t_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_seckill_details` */

/*Table structure for table `t_stock` */

DROP TABLE IF EXISTS `t_stock`;

CREATE TABLE `t_stock` (
  `stock_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库存表',
  `name` varchar(50) NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '商品数量',
  `start_time` timestamp NOT NULL,
  `end_time` timestamp NOT NULL,
  `create_time` timestamp NOT NULL,
  `describe` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_stock` */

insert  into `t_stock`(`stock_id`,`name`,`number`,`start_time`,`end_time`,`create_time`,`describe`) values (1,'iphone6',10,'2016-07-10 09:38:30','2016-07-10 10:38:37','2016-07-09 09:38:58',NULL),(2,'ipad',5,'2016-07-09 09:39:34','2016-07-10 09:39:37','2016-07-09 09:39:41',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
