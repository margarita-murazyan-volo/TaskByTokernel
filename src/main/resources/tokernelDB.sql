/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.18-log : Database - tokernel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tokernel` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tokernel`;

/*Table structure for table `number` */

DROP TABLE IF EXISTS `number`;

CREATE TABLE `number` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `odd_number` int(11) DEFAULT NULL,
  `even_number` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `number_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `number` */

insert  into `number`(`id`,`odd_number`,`even_number`,`user_id`) values (5,0,6,1),(6,9,0,1),(7,11,0,1),(8,15,0,1),(9,125,0,1),(10,0,0,1),(11,0,546,1),(12,5,0,2),(13,0,6,2),(14,0,968,2),(15,589,0,2),(16,789,0,2),(17,235,0,2),(18,0,236,2);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_type` enum('USER') NOT NULL DEFAULT 'USER',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`surname`,`email`,`password`,`user_type`) values (1,'Gayane','Melqonyan','m@mail.ru','$2a$10$kxEDXJJRL98LG95mR2CFruLpq/gtbU6ktxAwUQb06nHMle0dhL8tm','USER'),(2,'Margarita','Murazyan','margarita.mailru@mail.ru','$2a$10$OccPd5jYDA5bR5wcCd7kW.Lcyd5NjS9nSQf4nWTC6OALuu3Sp1CnS','USER');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
