/*
Navicat MySQL Data Transfer

Source Server         : xe
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : csu12306

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-09-21 08:10:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `diyuandijian`
-- ----------------------------
DROP TABLE IF EXISTS `diyuandijian`;
CREATE TABLE `diyuandijian` (
  `diyuandijianid` int(11) NOT NULL,
  `from` varchar(50) NOT NULL,
  `to` varchar(50) NOT NULL,
  `rate` decimal(9,5) NOT NULL,
  `pricerate` decimal(9,5) NOT NULL,
  `totalprice` decimal(9,5) DEFAULT NULL,
  `leiji` decimal(9,5) DEFAULT NULL,
  PRIMARY KEY (`diyuandijianid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diyuandijian
-- ----------------------------
INSERT INTO `diyuandijian` VALUES ('1', '1', '200', '0.00000', '0.05000', '10.00000', '0.00000');
INSERT INTO `diyuandijian` VALUES ('2', '201', '500', '10.00000', '0.04500', '13.50000', '23.50000');
INSERT INTO `diyuandijian` VALUES ('3', '501', '10000', '20.00000', '0.04000', '380.00000', '403.50000');
INSERT INTO `diyuandijian` VALUES ('4', '10001', '10050', '40.00000', '0.03000', null, null);

-- ----------------------------
-- Table structure for `line`
-- ----------------------------
DROP TABLE IF EXISTS `line`;
CREATE TABLE `line` (
  `lineid` int(11) NOT NULL,
  `trainid` int(11) NOT NULL,
  `stationname` varchar(50) NOT NULL,
  `distance` smallint(6) DEFAULT NULL,
  `fromtime` varchar(20) NOT NULL,
  `staytime` varchar(50) NOT NULL,
  PRIMARY KEY (`lineid`,`stationname`),
  KEY `lsid` (`stationname`),
  KEY `ltid` (`trainid`),
  CONSTRAINT `lsid` FOREIGN KEY (`stationname`) REFERENCES `station` (`stationname`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `ltid` FOREIGN KEY (`trainid`) REFERENCES `train` (`trainid`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line
-- ----------------------------
INSERT INTO `line` VALUES ('1', '1', '广州北', '1000', '2016-09-17 10:48:03', '00:05');
INSERT INTO `line` VALUES ('2', '1', '广州南', '990', '2016-09-17 11:16:18', '10分钟');
INSERT INTO `line` VALUES ('3', '2', '广州北', '1000', '2016-09-20 09:07:22', '00:05');
INSERT INTO `line` VALUES ('4', '2', '广州南', '990', '2016-09-20 09:07:46', '00:17');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` int(11) NOT NULL,
  `passengerid` int(11) NOT NULL,
  `orderstatus` varchar(50) NOT NULL,
  `ordertime` datetime NOT NULL,
  `ticketid` int(11) NOT NULL,
  PRIMARY KEY (`orderid`),
  KEY `opid` (`passengerid`),
  CONSTRAINT `opid` FOREIGN KEY (`passengerid`) REFERENCES `passenger` (`passengerid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('8056', '8052', '已退票', '2016-09-19 22:35:49', '4');
INSERT INTO `order` VALUES ('9218', '8052', '已退票', '2016-09-19 23:01:37', '1166');
INSERT INTO `order` VALUES ('9340', '8052', '已退票', '2016-09-19 23:02:28', '1288');
INSERT INTO `order` VALUES ('40260', '8052', '已退票', '2016-09-20 11:02:46', '619948');
INSERT INTO `order` VALUES ('1673628', '8052', '未支付', '2016-09-21 00:31:33', '31385232');
INSERT INTO `order` VALUES ('5944632', '8052', '已支付', '2016-09-20 15:49:18', '5936580');
INSERT INTO `order` VALUES ('15416671', '8052', '已支付', '2016-09-20 09:30:47', '15408619');
INSERT INTO `order` VALUES ('34339279', '8052', '已支付', '2016-09-20 16:51:35', '34331227');
INSERT INTO `order` VALUES ('69836061', '8052', '未支付', '2016-09-20 15:02:34', '69828009');
INSERT INTO `order` VALUES ('76642040', '8052', '已退票', '2016-09-20 11:04:42', '-1390958');
INSERT INTO `order` VALUES ('94832068', '8052', '已支付', '2016-09-21 08:06:25', '1468760');
INSERT INTO `order` VALUES ('95191089', '8052', '已退票', '2016-09-19 23:03:20', '95183037');
INSERT INTO `order` VALUES ('430578668', '8052', '已退票', '2016-09-20 09:31:14', '430570616');
INSERT INTO `order` VALUES ('1420780204', '8052', '已退票', '2016-09-20 09:26:15', '1420772152');

-- ----------------------------
-- Table structure for `passenger`
-- ----------------------------
DROP TABLE IF EXISTS `passenger`;
CREATE TABLE `passenger` (
  `passengerid` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `id` varchar(18) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `lastlogintime` datetime DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`email`),
  KEY `passengerid` (`passengerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of passenger
-- ----------------------------
INSERT INTO `passenger` VALUES ('2', '0@0', '1', '男', '我的姓名', '11123', '123234234', null, null);
INSERT INTO `passenger` VALUES ('3697', '1@1', '1', '女', '翼', '111111', '111', null, null);
INSERT INTO `passenger` VALUES ('1', '527375636@qq.com', '123456', '男', '温睿诚', '4400000000', '13308470064', null, null);
INSERT INTO `passenger` VALUES ('8052', 't@t', '1', '男', '■■■■■■刮开有奖', 't2而发', 'sdfaf ASdf 浮点数啊', null, null);

-- ----------------------------
-- Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `planid` int(11) NOT NULL,
  `trainid` int(11) NOT NULL,
  `chexiang` tinyint(4) NOT NULL,
  `compare` varchar(5) NOT NULL,
  `stationname` varchar(50) NOT NULL,
  PRIMARY KEY (`planid`),
  KEY `ptid` (`trainid`),
  KEY `psid` (`stationname`),
  CONSTRAINT `psid` FOREIGN KEY (`stationname`) REFERENCES `station` (`stationname`) ON DELETE CASCADE,
  CONSTRAINT `ptid` FOREIGN KEY (`trainid`) REFERENCES `train` (`trainid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('20', '1', '6', '>=', '广州南');
INSERT INTO `plan` VALUES ('50', '2', '1', '>=', '广州南');

-- ----------------------------
-- Table structure for `pricerate`
-- ----------------------------
DROP TABLE IF EXISTS `pricerate`;
CREATE TABLE `pricerate` (
  `pricerateid` int(11) NOT NULL,
  `tickettype` varchar(50) NOT NULL,
  `pricerate` decimal(8,2) NOT NULL,
  PRIMARY KEY (`pricerateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pricerate
-- ----------------------------
INSERT INTO `pricerate` VALUES ('1', '二等座', '9100.00');

-- ----------------------------
-- Table structure for `quduan`
-- ----------------------------
DROP TABLE IF EXISTS `quduan`;
CREATE TABLE `quduan` (
  `quduanid` int(11) NOT NULL,
  `from` varchar(50) NOT NULL,
  `to` varchar(50) NOT NULL,
  `distanceperqd` int(11) NOT NULL,
  `qdnumber` int(11) NOT NULL,
  PRIMARY KEY (`quduanid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quduan
-- ----------------------------
INSERT INTO `quduan` VALUES ('1', '1', '200', '20', '10');
INSERT INTO `quduan` VALUES ('2', '201', '500', '10', '30');
INSERT INTO `quduan` VALUES ('3', '501', '10000', '10', '950');

-- ----------------------------
-- Table structure for `seat`
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat` (
  `seatid` int(11) NOT NULL,
  `trainid` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `chexiang` smallint(6) NOT NULL,
  `seatno` varchar(50) NOT NULL,
  `from` varchar(50) NOT NULL,
  `to` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`seatid`),
  KEY `stid` (`trainid`),
  CONSTRAINT `stid` FOREIGN KEY (`trainid`) REFERENCES `train` (`trainid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES ('1', '1', '2016-09-12 16:15:51', '6', '2a', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('2', '1', '2016-09-18 14:51:18', '1', '2b', '长沙南', '广州北', '未售');
INSERT INTO `seat` VALUES ('3', '1', '2016-09-21 10:32:18', '1', '23', '长沙南', '广州北', '未售');
INSERT INTO `seat` VALUES ('4', '1', '2016-09-07 10:35:00', '1', '33', '长沙', '广州', '未售');
INSERT INTO `seat` VALUES ('5', '1', '2016-09-19 22:12:44', '1', '9c', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10601', '1', '2016-09-12 16:13:05', '6', '1', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10602', '1', '2016-09-12 16:13:05', '6', '2', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10603', '1', '2016-09-12 16:13:05', '6', '3', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10604', '1', '2016-09-12 16:13:05', '6', '4', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10605', '1', '2016-09-12 16:13:05', '6', '5', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10606', '1', '2016-09-12 16:13:05', '6', '6', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10607', '1', '2016-09-12 16:13:05', '6', '7', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10608', '1', '2016-09-12 16:13:05', '6', '8', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10609', '1', '2016-09-12 16:13:05', '6', '9', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10610', '1', '2016-09-12 16:13:05', '6', '10', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10611', '1', '2016-09-12 16:13:05', '6', '11', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10612', '1', '2016-09-12 16:13:05', '6', '12', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10613', '1', '2016-09-12 16:13:05', '6', '13', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10614', '1', '2016-09-12 16:13:05', '6', '14', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10615', '1', '2016-09-12 16:13:05', '6', '15', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10616', '1', '2016-09-12 16:13:05', '6', '16', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10617', '1', '2016-09-12 16:13:05', '6', '17', '广州南', '广州北', '已售');
INSERT INTO `seat` VALUES ('10618', '1', '2016-09-12 16:13:05', '6', '18', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10619', '1', '2016-09-12 16:13:05', '6', '19', '广州南', '广州北', '已售');
INSERT INTO `seat` VALUES ('10620', '1', '2016-09-12 16:13:05', '6', '20', '广州南', '广州北', '已售');
INSERT INTO `seat` VALUES ('10701', '1', '2016-09-12 16:13:05', '7', '1', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10703', '1', '2016-09-12 16:13:05', '7', '3', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10704', '1', '2016-09-12 16:13:05', '7', '4', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10705', '1', '2016-09-12 16:13:05', '7', '5', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10706', '1', '2016-09-12 16:13:05', '7', '6', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10707', '1', '2016-09-12 16:13:05', '7', '7', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10708', '1', '2016-09-12 16:13:05', '7', '8', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10709', '1', '2016-09-12 16:13:05', '7', '9', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10710', '1', '2016-09-12 16:13:05', '7', '10', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10711', '1', '2016-09-12 16:13:05', '7', '11', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10712', '1', '2016-09-12 16:13:05', '7', '12', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10713', '1', '2016-09-12 16:13:05', '7', '13', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10714', '1', '2016-09-12 16:13:05', '7', '14', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10715', '1', '2016-09-12 16:13:05', '7', '15', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10716', '1', '2016-09-12 16:13:05', '7', '16', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10717', '1', '2016-09-12 16:13:05', '7', '17', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10719', '1', '2016-09-12 16:13:05', '7', '19', '广州南', '广州北', '已售');
INSERT INTO `seat` VALUES ('10901', '1', '2016-09-12 16:13:05', '9', '1', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10902', '1', '2016-09-12 16:13:05', '9', '2', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10903', '1', '2016-09-12 16:13:05', '9', '3', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10904', '1', '2016-09-12 16:13:05', '9', '4', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10905', '1', '2016-09-12 16:13:05', '9', '5', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10906', '1', '2016-09-12 16:13:05', '9', '6', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10907', '1', '2016-09-12 16:13:05', '9', '7', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10908', '1', '2016-09-12 16:13:05', '9', '8', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10909', '1', '2016-09-12 16:13:05', '9', '9', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10910', '1', '2016-09-12 16:13:05', '9', '10', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10911', '1', '2016-09-12 16:13:05', '9', '11', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10912', '1', '2016-09-12 16:13:05', '9', '12', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10913', '1', '2016-09-12 16:13:05', '9', '13', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10914', '1', '2016-09-12 16:13:05', '9', '14', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10915', '1', '2016-09-12 16:13:05', '9', '15', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10916', '1', '2016-09-12 16:13:05', '9', '16', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10917', '1', '2016-09-12 16:13:05', '9', '17', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10918', '1', '2016-09-12 16:13:05', '9', '18', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10919', '1', '2016-09-12 16:13:05', '9', '19', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('10920', '1', '2016-09-12 16:13:05', '9', '20', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20101', '2', '2016-09-20 09:06:39', '1', '1', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20102', '2', '2016-09-20 09:06:39', '1', '2', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20103', '2', '2016-09-20 09:06:39', '1', '3', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20104', '2', '2016-09-20 09:06:39', '1', '4', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20105', '2', '2016-09-20 09:06:39', '1', '5', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20106', '2', '2016-09-20 09:06:39', '1', '6', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20107', '2', '2016-09-20 09:06:39', '1', '7', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20108', '2', '2016-09-20 09:06:39', '1', '8', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20109', '2', '2016-09-20 09:06:39', '1', '9', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20110', '2', '2016-09-20 09:06:39', '1', '10', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20111', '2', '2016-09-20 09:06:39', '1', '11', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20112', '2', '2016-09-20 09:06:39', '1', '12', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20113', '2', '2016-09-20 09:06:39', '1', '13', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20114', '2', '2016-09-20 09:06:39', '1', '14', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20115', '2', '2016-09-20 09:06:39', '1', '15', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20116', '2', '2016-09-20 09:06:39', '1', '16', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20117', '2', '2016-09-20 09:06:39', '1', '17', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20118', '2', '2016-09-20 09:06:39', '1', '18', '广州南', '广州北', '未售');
INSERT INTO `seat` VALUES ('20119', '2', '2016-09-20 09:06:39', '1', '19', '广州南', '广州北', '已售');
INSERT INTO `seat` VALUES ('20120', '2', '2016-09-20 09:06:39', '1', '20', '广州南', '广州北', '已售');

-- ----------------------------
-- Table structure for `station`
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `stationid` int(11) NOT NULL,
  `stationname` varchar(50) NOT NULL,
  `pinyin` varchar(50) NOT NULL,
  `location` varchar(50) DEFAULT NULL,
  `ju` varchar(50) DEFAULT NULL,
  `level` tinyint(4) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stationid`),
  UNIQUE KEY `stationname` (`stationname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES ('1', '广州北', 'GZB', '广州', null, null, null);
INSERT INTO `station` VALUES ('2', '广州南', 'GZN', '广州', '', '2', '');

-- ----------------------------
-- Table structure for `ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `ticketid` int(11) NOT NULL,
  `seatid` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `salemode` varchar(50) DEFAULT NULL,
  `tickettype` varchar(50) DEFAULT NULL,
  `passengerid` int(11) NOT NULL,
  `passengertype` varchar(50) NOT NULL,
  `salestime` datetime DEFAULT NULL,
  `ticketstatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ticketid`),
  KEY `tsid` (`seatid`),
  CONSTRAINT `tsid` FOREIGN KEY (`seatid`) REFERENCES `seat` (`seatid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES ('-1390958', '20118', '30.30', '网络售票', '一等座', '8052', '成人', '2016-09-20 11:04:42', '退票');
INSERT INTO `ticket` VALUES ('4', '4', '23.50', '网络售票', '一等座', '8052', '成人', '2016-09-19 22:35:49', '退票');
INSERT INTO `ticket` VALUES ('1166', '1', '23.50', '网络售票', '一等座', '8052', '成人', '2016-09-19 23:01:37', '退票');
INSERT INTO `ticket` VALUES ('1288', '1', '23.50', '网络售票', '一等座', '8052', '成人', '2016-09-19 23:02:28', '退票');
INSERT INTO `ticket` VALUES ('619948', '20120', '30.30', '网络售票', '一等座', '8052', '成人', '2016-09-20 11:02:46', '退票');
INSERT INTO `ticket` VALUES ('1468760', '20120', '30.30', '网络售票', '一等座', '8052', '成人', '2016-09-21 08:06:25', '已改签');
INSERT INTO `ticket` VALUES ('5936580', '10620', '23.50', '网络售票', '一等座', '8052', '成人', '2016-09-20 15:49:13', null);
INSERT INTO `ticket` VALUES ('15408619', '20119', '30.30', '网络售票', '一等座', '8052', '成人', '2016-09-20 09:30:47', null);
INSERT INTO `ticket` VALUES ('31385232', '10719', '23.50', '网络售票', '一等座', '8052', '成人', '2016-09-21 00:31:33', '已改签');
INSERT INTO `ticket` VALUES ('34331227', '10619', '23.50', '网络售票', '一等座', '8052', '成人', '2016-09-20 16:51:35', null);
INSERT INTO `ticket` VALUES ('69828009', '10617', '23.50', '网络售票', '一等座', '8052', '成人', '2016-09-20 15:02:31', null);
INSERT INTO `ticket` VALUES ('95183037', '3', '23.50', '网络售票', '一等座', '8052', '成人', '2016-09-19 23:03:20', '退票');
INSERT INTO `ticket` VALUES ('430570616', '20118', '30.30', '网络售票', '一等座', '8052', '成人', '2016-09-20 09:31:14', '退票');
INSERT INTO `ticket` VALUES ('1420772152', '20120', '30.30', '网络售票', '一等座', '8052', '成人', '2016-09-20 09:26:15', '退票');

-- ----------------------------
-- Table structure for `train`
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train` (
  `trainid` int(11) NOT NULL,
  `from` varchar(50) NOT NULL,
  `to` varchar(50) NOT NULL,
  `fromtime` datetime NOT NULL,
  `totime` datetime NOT NULL,
  `last` varchar(50) DEFAULT NULL,
  `distance` smallint(6) NOT NULL,
  `noseatnumber` smallint(6) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`trainid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train
-- ----------------------------
INSERT INTO `train` VALUES ('1', '广州南', '广州北', '2016-09-12 16:13:05', '2016-09-12 16:13:10', '15分钟', '490', '5', '火箭');
INSERT INTO `train` VALUES ('2', '广州南', '广州北', '2016-09-20 09:06:39', '2016-09-21 09:06:42', '99分钟', '666', '10', '空调车');

-- ----------------------------
-- Table structure for `traingroup`
-- ----------------------------
DROP TABLE IF EXISTS `traingroup`;
CREATE TABLE `traingroup` (
  `traingroupid` int(11) NOT NULL,
  `trainid` int(11) NOT NULL,
  `chexiang` tinyint(4) NOT NULL,
  `seattype` varchar(50) NOT NULL,
  `seatnumber` smallint(6) NOT NULL,
  `chexiangtype` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`traingroupid`),
  KEY `ttid` (`trainid`),
  CONSTRAINT `ttid` FOREIGN KEY (`trainid`) REFERENCES `train` (`trainid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traingroup
-- ----------------------------
INSERT INTO `traingroup` VALUES ('1', '1', '6', '二等座', '999', '餐车');
INSERT INTO `traingroup` VALUES ('2', '1', '1', '二等座', '30', '观光啊');
INSERT INTO `traingroup` VALUES ('3', '2', '1', '一等座', '20', '客车');
INSERT INTO `traingroup` VALUES ('4', '1', '2', '头等舱', '10', '遥控车');
INSERT INTO `traingroup` VALUES ('5', '1', '7', '阿斯蒂芬暗色', '10', '露天');
