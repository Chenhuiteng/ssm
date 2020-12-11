/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50544
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50544
File Encoding         : 65001

Date: 2020-12-11 22:39:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_resident`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_resident`;
CREATE TABLE `tbl_resident` (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `area` varchar(20) DEFAULT NULL,
  `birth_time` datetime DEFAULT NULL,
  `pass_word` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tbl_resident
-- ----------------------------
INSERT INTO `tbl_resident` VALUES ('1', 'w', '15', '11', '2020-06-17 15:41:55', '123', '22');
