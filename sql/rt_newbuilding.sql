/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50605
Source Host           : localhost:3306
Source Database       : regional transformation

Target Server Type    : MYSQL
Target Server Version : 50605
File Encoding         : 65001

Date: 2017-09-12 09:57:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `rt_newbuilding`
-- ----------------------------
DROP TABLE IF EXISTS `rt_newbuilding`;
CREATE TABLE `rt_newbuilding` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '新房源ID',
  `BuildingNo` varchar(255) DEFAULT NULL,
  `flag` tinyint(4) unsigned zerofill DEFAULT NULL COMMENT '是否被抽选',
  `ownerId` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rt_newbuilding
-- ----------------------------
INSERT INTO rt_newbuilding VALUES ('1', '555-1-1', '0000', null, null);
INSERT INTO rt_newbuilding VALUES ('2', '555-1-2', '0000', null, null);
INSERT INTO rt_newbuilding VALUES ('3', '555-2-1', '0000', null, null);
INSERT INTO rt_newbuilding VALUES ('4', '555-2-2', '0000', null, null);
INSERT INTO rt_newbuilding VALUES ('5', '555-3-1', '0000', null, null);
INSERT INTO rt_newbuilding VALUES ('6', '555-3-2', '0000', null, null);
