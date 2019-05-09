/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.25 : Database - quick_start
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`quick_start` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `quick_start`;

/*Table structure for table `class` */

CREATE TABLE `class` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `caption` varchar(32) NOT NULL,
  `grade_id` int(11) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `class` */

insert  into `class`(`cid`,`caption`,`grade_id`) values (1,'一年一班',1);
insert  into `class`(`cid`,`caption`,`grade_id`) values (2,'一年二班',1);
insert  into `class`(`cid`,`caption`,`grade_id`) values (3,'一年三班',1);
insert  into `class`(`cid`,`caption`,`grade_id`) values (4,'二年一班',2);
insert  into `class`(`cid`,`caption`,`grade_id`) values (5,'二年二班',2);
insert  into `class`(`cid`,`caption`,`grade_id`) values (6,'二年三班',2);

/*Table structure for table `course` */

CREATE TABLE `course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(32) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

/*Table structure for table `grade` */

CREATE TABLE `grade` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(32) NOT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `grade` */

insert  into `grade`(`gid`,`gname`) values (1,'一年级');
insert  into `grade`(`gid`,`gname`) values (2,'二年级');
insert  into `grade`(`gid`,`gname`) values (3,'三年级');
insert  into `grade`(`gid`,`gname`) values (4,'四年级');
insert  into `grade`(`gid`,`gname`) values (5,'五年级');
insert  into `grade`(`gid`,`gname`) values (6,'六年级');

/*Table structure for table `score` */

CREATE TABLE `score` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `score` */

/*Table structure for table `student` */

CREATE TABLE `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `gender` char(1) NOT NULL,
  `class_id` int(11) NOT NULL,
  `sname` varchar(32) NOT NULL,
  PRIMARY KEY (`sid`),
  KEY `fk_class` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`sid`,`gender`,`class_id`,`sname`) values (1,'1',1,'张三');
insert  into `student`(`sid`,`gender`,`class_id`,`sname`) values (2,'2',1,'张彤');
insert  into `student`(`sid`,`gender`,`class_id`,`sname`) values (3,'1',2,'李四');
insert  into `student`(`sid`,`gender`,`class_id`,`sname`) values (4,'1',2,'历史');

/*Table structure for table `teacher` */

CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(32) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
