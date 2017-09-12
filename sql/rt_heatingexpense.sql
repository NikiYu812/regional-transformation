/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50605
Source Host           : localhost:3306
Source Database       : regional transformation

Target Server Type    : MYSQL
Target Server Version : 50605
File Encoding         : 65001

Date: 2017-09-12 09:58:27
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `rt_heatingexpense`
-- ----------------------------
DROP TABLE IF EXISTS `rt_heatingexpense`;
CREATE TABLE `rt_heatingexpense` (
  `ID` varchar(255) NOT NULL,
  `BuildingNo` varchar(255) DEFAULT NULL,
  `OriginalTenant` varchar(255) DEFAULT NULL,
  `Tel` varchar(255) DEFAULT NULL,
  `ConstructionArea` varchar(255) DEFAULT NULL,
  `PayOrNot` varchar(255) DEFAULT NULL,
  `PublicExpenseArea` varchar(255) DEFAULT NULL,
  `OwnExpenseArea` varchar(255) DEFAULT NULL,
  `HeatingExpense` varchar(255) DEFAULT NULL,
  `PaymentDate` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rt_heatingexpense
-- ----------------------------
INSERT INTO rt_heatingexpense VALUES ('1', '165栋-3号', '陈峰', '15602472171', '50.88', '1', '0', '50.88', '1185', '2016-11-2', '');
INSERT INTO rt_heatingexpense VALUES ('10', '219栋-4号', '刘金安', '18512437655', '52.98', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('11', '219栋-6号', '冯书全', '15040037667（大儿子）；18512461937（小儿子）', '52.33', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('12', '219栋-8号', '徐忠瑞', '15640194575（女儿）', '52.24', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('13', '219栋-9号', '冯文章', '15524457133（妻子：芦）', '51.93', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('14', '219栋-11号', '孙洪禄', '15524376289', '52.13', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('15', '219栋-12号', '冯茂臣', '13940206976', '50.92', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('16', '220栋-2-2号', '程立铭', '', '20.42', '1', null, null, '530', '2016-10-29', '');
INSERT INTO rt_heatingexpense VALUES ('17', '8栋-4号', '姜永海', '13897909946（儿媳：赵秀杰）', '27.33', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('18', '8栋-5、6号', '张佐廷', '13418864575（张英杰）', '51.56', '1', '51.56', '0', '1340', '2016-11-2', '');
INSERT INTO rt_heatingexpense VALUES ('19', '14栋-1号', '何成才', '15698842888（何霞）', '56.88', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('2', '144栋-14号', '宋立辉', '18940012160', '50.88', '1', null, null, '1322', '2016-10-31', '');
INSERT INTO rt_heatingexpense VALUES ('20', '14栋-2号', '孟祥斌', '13624017127（卜宝琴）', '25.01', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('21', '36栋-2号', '齐延忠', '', '24.35', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('22', '44栋-3号', '连有权', '', '41.38', '1', null, null, '1075', '2016-10-29', '');
INSERT INTO rt_heatingexpense VALUES ('23', '127栋-3、4号', '杨久然', '13940224212（孙子：杨健）', '68.63', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('24', '127栋-7、8号', '陈文田', '13889213172（儿子：陈宏武）', '68.51', '0', null, null, null, null, '');
INSERT INTO rt_heatingexpense VALUES ('25', '137栋-1、2号', '杨兆甲', '13898851500', '68.01', '1', '68.01', '0', '1768', '2016-11-3', '');
INSERT INTO rt_heatingexpense VALUES ('26', '137栋-3、4号', '王东升', '13940159973', '68.32', '1', null, null, '1776', '2016-10-31', '');
INSERT INTO rt_heatingexpense VALUES ('27', '137栋-5、6号', '王澜钧', '13804011679（母亲：王澜钧）', '81.61', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('28', '137栋-8号', '符桂琴', '24285271', '58.01', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('29', '148栋-1、2号', '李德仁', '13238815481（妻子：马淑义）', '70.91', '1', null, null, '1652', '2016-10-30', '');
INSERT INTO rt_heatingexpense VALUES ('3', '144栋-15号', '刘永录', '18809845292（女儿）', '50.88', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('30', '148栋-3、4号', '曾继彦', '13840150255（妻子：韩桂凤）', '70.76', '1', '70.76', '0', '1839', '2016-11-2', '');
INSERT INTO rt_heatingexpense VALUES ('31', '148栋-5、6号', '曾传胜', '15524338357；15802499268', '84.52', '1', '84.52', '0', '2197', '2016-11-2', '');
INSERT INTO rt_heatingexpense VALUES ('32', '148栋-7、8号', '于晓明', '13238844939', '69.94', '1', null, null, '1724', '2016-10-31', '');
INSERT INTO rt_heatingexpense VALUES ('33', '148栋-9、10号', '宋炳和', '15653539968', '71.76', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('34', '149栋-1、2号', '胡广兴', '14704031888（儿子：胡志斌）', '70.09', '1', null, null, '1633', '2016-10-30', '');
INSERT INTO rt_heatingexpense VALUES ('35', '149栋-9、10号', '乔玄', '', '62.52', '1', null, null, '1595', '2016-10-29', '');
INSERT INTO rt_heatingexpense VALUES ('36', '176栋-6号', '马忠权', '13940069677（妻子：田英）', '40.82', '1', '0', '40.82', '951', '2016-11-3', '');
INSERT INTO rt_heatingexpense VALUES ('37', '176栋-8号', '尹燕祥', '13252898546', '70.29', '1', null, null, '1827', '2016-10-30', '');
INSERT INTO rt_heatingexpense VALUES ('38', '174栋-1号', '杨兵', '13516005887', '54.24', '1', null, null, '1410', '2016-10-29', '');
INSERT INTO rt_heatingexpense VALUES ('39', '163栋-1、2号', '谢鸿禄', '13555713506', '89.4', '1', '85', '4.400000000000006', '2312', '2016-10-29', '');
INSERT INTO rt_heatingexpense VALUES ('4', '205栋-2号', '韩文海', '13664103169', '81.75', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('40', '163栋-5、6号', '尹威', '13478186858', '53.93', '1', '53.93', '0', '1402', '2016-11-1', '');
INSERT INTO rt_heatingexpense VALUES ('41', '162栋-3号', '郑晓舰', '15040218787（兄弟：郑小兵）', '83.39', '1', '83.39', '0', '2168', '2016-11-3', '');
INSERT INTO rt_heatingexpense VALUES ('42', '161栋-3号', '刘文刚', '15840352127', '43.89', '1', '43.89', '0', '1141', '2016-11-2', '');
INSERT INTO rt_heatingexpense VALUES ('43', '152栋-4号', '吴斌', '13840408262', '74.51', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('44', '151栋-1号', '马永河', '24282468 ；13804016518', '65.04', '1', null, null, '1691', '2016-10-31', '');
INSERT INTO rt_heatingexpense VALUES ('45', '151栋-4号', '张国芝', '13644043668', '71.49', '1', null, null, '1858', '2016-10-30', '');
INSERT INTO rt_heatingexpense VALUES ('46', '150栋-4号', '石福顺', '', '33.57', '1', null, null, '872', '2016-10-29', '');
INSERT INTO rt_heatingexpense VALUES ('47', '142栋-7号', '程树堂', '', '32.2', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('48', '140栋-7号', '石俊山', '13889367606', '58.06', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('49', '131栋-2、3号', '刘凤禄', '', '44.66', '1', null, null, '1161', '2016-10-31', '');
INSERT INTO rt_heatingexpense VALUES ('5', '205栋-5号', '杨兆华', '13674232413', '81.75', '1', '0', '81.75', '1904', '2016-11-2', '');
INSERT INTO rt_heatingexpense VALUES ('50', '131栋-7号', '刘凤禄', '13654015568', '25.85', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('52', '131栋-10号', '桑自铮', '13998813505', '18', '1', null, null, '468', '2016-10-30', '');
INSERT INTO rt_heatingexpense VALUES ('53', '134栋-1号', '马维列', '15640573059（妻子：周兰）', '37.1', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('54', '133栋-3、4号', '胡邦雷', '17071017592', '66.55', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('55', '123栋-2号', '程立铭', '', '43.53', '1', null, null, '1131', '2016-10-29', '');
INSERT INTO rt_heatingexpense VALUES ('56', '123栋-3号', '孙大茂', '15640317822（妻子：李）；24282542', '43.69', '1', '0', '43.69', '1017', '2016-11-2', '');
INSERT INTO rt_heatingexpense VALUES ('57', '171栋-1号', '姬阔周', '24286748', '68.86', '1', null, null, '1790', '2016-10-29', '');
INSERT INTO rt_heatingexpense VALUES ('58', '156-2栋-7号', '闫玉桓', '15940205028,13066517682', '49.93', '1', null, null, '1298', '2016-10-29', '');
INSERT INTO rt_heatingexpense VALUES ('59', '178栋-1号', '张连富', '13478851715', '68.92', '1', null, null, '1791', '2016-10-30', '');
INSERT INTO rt_heatingexpense VALUES ('6', '205栋-7号', '于洪振', '13889165389', '81.75', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('60', '183栋-1号', '杨兆甲', '13002481277', '39.16', '1', null, null, '912', '2016-10-31', '');
INSERT INTO rt_heatingexpense VALUES ('61', '182栋-3号', '梁桂华', '', '35.2', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('62', '181栋-3号', '车耀庄', '13664110965', '34.73', '1', null, null, '902', '2016-10-30', '');
INSERT INTO rt_heatingexpense VALUES ('63', '169栋3、4号', '赵锦凤', '13889867045', '74.98', '1', '74.98', '0', '1949', '2016-11-2', '');
INSERT INTO rt_heatingexpense VALUES ('64', '167栋-1号', '任雨苍', '13002497888', '73.61', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('65', '197栋-9号', '韩玉兰', '15542240016', '35.83', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('66', '197栋-22号', '景冈山', '18102455003（女儿：景红）', '36.62', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('67', '221栋-5号', '李伟英', '13889864556（外甥女）', '30.57', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('68', '221栋-12号', '李明', '出国无法联系', '39.06', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('69', '163栋-10、11号', '潘秀荣', '', '54.25', '1', null, null, '1410', '2016-10-29', '外户');
INSERT INTO rt_heatingexpense VALUES ('7', '205栋-8号', '曲长义', '13940393591', '81.75', '0', null, null, null, '', '');
INSERT INTO rt_heatingexpense VALUES ('70', '178栋-2号', '安云平', '', '55.52', '0', null, null, null, '', '外户');
INSERT INTO rt_heatingexpense VALUES ('71', '220栋-1号', '国晓东', '', '43.3', '0', null, null, null, '', '外户');
INSERT INTO rt_heatingexpense VALUES ('72', '221栋-11号', '姜平', '', '31.5', '0', null, null, null, '', '外户');
INSERT INTO rt_heatingexpense VALUES ('73', '144栋-10号', '徐景山', '', '50.88', '1', null, null, '1322', '2016-10-31', '已签协议');
INSERT INTO rt_heatingexpense VALUES ('77', '140栋-3号', '张成广', '15040089409；24282393', '55.44', '1', '55.44', '0', '1441', '2016-11-1', '');
INSERT INTO rt_heatingexpense VALUES ('78', '165栋-6号', '于海滨', '15840524478', '50.88', '1', '0', '50.88', '1185', '2016-11-2', '协议已签');
INSERT INTO rt_heatingexpense VALUES ('8', '206栋-3号', '于永学', '13149829658；24289270', '81.75', '1', '81.75', '0', '2125', '2016-11-3', '');
INSERT INTO rt_heatingexpense VALUES ('9', '206栋-6号', '张继光', '', '81.75', '0', null, null, null, '', '');
