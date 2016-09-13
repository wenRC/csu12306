/*
Navicat MySQL Data Transfer

Source Server         : xe
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : csu12306

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-09-12 16:19:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `station`
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `stationid` int(11) NOT NULL,
  `stationname` varchar(50) NOT NULL,
  `pinyin` varchar(50) NOT NULL,
  `location` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stationid`),
  UNIQUE( `stationname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES ('1', '广州北', 'GZB', '广州');
INSERT INTO `station` VALUES ('2', '广州南', 'GZN', '广州');

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
INSERT INTO `train` VALUES ('1', '广州南', '广州北', '2016-09-12 16:13:05', '2016-09-12 16:13:10', '15分钟', '500', '5', '磁悬浮');
-- ----------------------------
-- Table structure for `diyuandijian`
-- ----------------------------
DROP TABLE IF EXISTS `diyuandijian`;
CREATE TABLE `diyuandijian` (
  `diyuandijianid` int(11) NOT NULL,
  `from` varchar(50) NOT NULL,
  `to` varchar(50) NOT NULL,
  `rate` decimal(4,2) NOT NULL,
  `pricerate` decimal(4,2) NOT NULL,
  `totalprice` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`diyuandijianid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diyuandijian
-- ----------------------------
INSERT INTO `diyuandijian` VALUES ('1', '广州北', '广州南', '10.00', '10.00', '15.00');

-- ----------------------------
-- Table structure for `line`
-- ----------------------------
DROP TABLE IF EXISTS `line`;
CREATE TABLE `line` (
  `lineid` int(11) NOT NULL,
  `trainid` int(11) NOT NULL,
  `stationname` varchar(50) NOT NULL,
  `distance` smallint(6) NOT NULL,
  `fromtime` datetime NOT NULL,
  `lasttime` varchar(20) NOT NULL,
  PRIMARY KEY (`lineid`),
  KEY `lsid` (`stationname`),
  KEY `ltid` (`trainid`),
  CONSTRAINT `lsid` FOREIGN KEY (`stationname`) REFERENCES `station` (`stationname`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `ltid` FOREIGN KEY (`trainid`) REFERENCES `train` (`trainid`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line
-- ----------------------------
INSERT INTO `line` VALUES ('1', '1', '广州北', '1000', '2016-09-12 16:18:41', '5分钟');
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
  PRIMARY KEY (`email`),
  KEY `passengerid` (`passengerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of passenger
-- ----------------------------
INSERT INTO `passenger` VALUES ('1', '527375636@qq.com', '123456', '男', '温睿诚', '4400000000', '13308470064');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` int(11) NOT NULL,
  `passengerid` int(11) NOT NULL,
  `orderstatus` varchar(50) NOT NULL,
  `ordertime` datetime NOT NULL,
  PRIMARY KEY (`orderid`),
  KEY `opid` (`passengerid`),
  CONSTRAINT `opid` FOREIGN KEY (`passengerid`) REFERENCES `passenger` (`passengerid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '未出行', '2016-09-12 16:17:56');


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
INSERT INTO `plan` VALUES ('1', '1', '6', '>=', '1');

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
INSERT INTO `pricerate` VALUES ('1', '二等座', '900.00');

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
INSERT INTO `quduan` VALUES ('1', '广州北', '广州南', '10', '10');

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
INSERT INTO `seat` VALUES ('1', '1', '2016-09-12 16:15:51', '6', '2a', '广州南', '广州北', '未出行');



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
  PRIMARY KEY (`ticketid`),
  KEY `tsid` (`seatid`),
  CONSTRAINT `tsid` FOREIGN KEY (`seatid`) REFERENCES `seat` (`seatid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES ('1', '1', '15.00', '网络', '二等座');



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
