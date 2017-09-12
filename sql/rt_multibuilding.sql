/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50605
Source Host           : localhost:3306
Source Database       : regional transformation

Target Server Type    : MYSQL
Target Server Version : 50605
File Encoding         : 65001

Date: 2017-09-12 09:56:38
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `rt_multibuilding`
-- ----------------------------
DROP TABLE IF EXISTS `rt_multibuilding`;
CREATE TABLE `rt_multibuilding` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `Tenant` varchar(255) DEFAULT NULL,
  `BuildingNo` varchar(255) DEFAULT NULL,
  `ConstructionArea` varchar(255) DEFAULT NULL,
  `Remark` varchar(255) DEFAULT NULL,
  `flag` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rt_multibuilding
-- ----------------------------
INSERT INTO rt_multibuilding VALUES ('1', '桑自铮', '245栋（41号楼）3-36', '73.23', '', '1');
INSERT INTO rt_multibuilding VALUES ('2', '梁桂华', '246栋（39号楼）2-19', '41.73', '', '1');
INSERT INTO rt_multibuilding VALUES ('3', '程树堂', '242栋（31号楼）1-6', '59', '', '1');
INSERT INTO rt_multibuilding VALUES ('4', '吴连志', '235栋（17号楼）2-20', '54.31', '', '1');
INSERT INTO rt_multibuilding VALUES ('5', '齐延忠', '23栋（19号楼）2-18', '58.77', '', '1');
INSERT INTO rt_multibuilding VALUES ('6', '石福顺', '4栋（24号楼）2-18', '58.8', '', '1');
INSERT INTO rt_multibuilding VALUES ('7', '孟祥斌', '225栋（西五千米）4-37', '46.66', '', '1');
INSERT INTO rt_multibuilding VALUES ('8', '张传恩', '3栋（47号楼）2-16', '58.77', '', '1');
INSERT INTO rt_multibuilding VALUES ('9', '姜永海', '238栋（36号楼）2-24', '59', '', '1');
INSERT INTO rt_multibuilding VALUES ('10', '王振国', '9栋（48号楼）1-6', '58.77', '', '1');
INSERT INTO rt_multibuilding VALUES ('11', '陈文秀', '241栋（30号楼）3-27', '43.3', '', '1');
INSERT INTO rt_multibuilding VALUES ('12', '孙大茂', '238栋（36号楼）2-22', '59', '', '1');
INSERT INTO rt_multibuilding VALUES ('13', '连有权', '238栋（36号楼）3-27', '43.3', '', '1');
INSERT INTO rt_multibuilding VALUES ('14', '冯书全', '239栋（37号楼）3-27', '43.3', '', '1');
INSERT INTO rt_multibuilding VALUES ('15', '曾传胜', '223栋（东三千米）1-9', '43.12', '', '1');
INSERT INTO rt_multibuilding VALUES ('16', '韩玉兰', '226栋（1号楼）3-35', '53.03', '', '0');
INSERT INTO rt_multibuilding VALUES ('18', '石俊山', '241栋-1-3-2', '59', '', '1');
INSERT INTO rt_multibuilding VALUES ('19', '张成广', '24栋-4-1-2', '70.56', '', '0');
INSERT INTO rt_multibuilding VALUES ('20', '李纯凤', '72栋-19号', null, null, '1');
