/*
SQLyog Ultimate v8.6 Beta2
MySQL - 5.5.5-10.1.8-MariaDB : Database - pbo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pbo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pbo`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `dosenlesson` */

DROP TABLE IF EXISTS `dosenlesson`;

CREATE TABLE `dosenlesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `idlesson` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `forum` */

DROP TABLE IF EXISTS `forum`;

CREATE TABLE `forum` (
  `description` varchar(50) NOT NULL,
  `idforum` int(11) NOT NULL AUTO_INCREMENT,
  `idlesson` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `title` varchar(50) NOT NULL,
  `topic` varchar(50) NOT NULL,
  PRIMARY KEY (`idforum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `forumstudent` */

DROP TABLE IF EXISTS `forumstudent`;

CREATE TABLE `forumstudent` (
  `idforum` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `lesson` */

DROP TABLE IF EXISTS `lesson`;

CREATE TABLE `lesson` (
  `idlesson` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `topic` varchar(50) NOT NULL,
  `tingkat` varchar(10) NOT NULL,
  `file` mediumblob NOT NULL,
  PRIMARY KEY (`idlesson`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Table structure for table `progress` */

DROP TABLE IF EXISTS `progress`;

CREATE TABLE `progress` (
  `username` varchar(20) NOT NULL,
  `idlesson` int(11) NOT NULL,
  `persentasi` int(11) NOT NULL,
  `idprogress` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idprogress`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `study` */

DROP TABLE IF EXISTS `study`;

CREATE TABLE `study` (
  `idstudy` int(11) NOT NULL,
  `idlesson` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`idstudy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `idlesson` int(11) NOT NULL,
  `idtest` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `pertanyaan` varchar(100) NOT NULL,
  `jawaban` int(11) NOT NULL,
  `nilai` double NOT NULL,
  PRIMARY KEY (`idtest`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
