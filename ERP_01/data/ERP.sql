/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 127.0.0.1:3306
 Source Schema         : ERP

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 23/10/2019 10:28:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_dept
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dept`;
CREATE TABLE `tbl_dept` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `tele` varchar(30) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_dept
-- ----------------------------
BEGIN;
INSERT INTO `tbl_dept` VALUES (1, '开放部', '110');
INSERT INTO `tbl_dept` VALUES (2, '销售部', '120');
INSERT INTO `tbl_dept` VALUES (4, '运维部', '119');
INSERT INTO `tbl_dept` VALUES (15, '测试部', 'q');
INSERT INTO `tbl_dept` VALUES (16, '运维开放部', '113');
COMMIT;

-- ----------------------------
-- Table structure for tbl_emp
-- ----------------------------
DROP TABLE IF EXISTS `tbl_emp`;
CREATE TABLE `tbl_emp` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(15) NOT NULL,
  `pwd` varchar(32) NOT NULL,
  `name` varchar(28) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tele` varchar(30) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` int(1) NOT NULL COMMENT '1-男；0-女',
  `birthday` bigint(20) NOT NULL,
  `depUuid` bigint(20) NOT NULL,
  `lastLoginTime` bigint(20) NOT NULL,
  `lastLoginIp` varchar(255) NOT NULL,
  `loginTimes` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_emp
-- ----------------------------
BEGIN;
INSERT INTO `tbl_emp` VALUES (6, 'admin', '1', '赵云', 'admin@itcast.cn', '112233', '金燕龙1楼大厅', 1, 1263830400000, 1, 1422266691599, '0:0:0:0:0:0:0:1', 33);
INSERT INTO `tbl_emp` VALUES (7, 'chengzheng', '1', '陈征征婚', 'Qeeqe', 'q11213', 'q213', 0, 1420473600000, 1, 1422263312319, '-', 0);
INSERT INTO `tbl_emp` VALUES (8, 'hr', '2', 'hr主管', 'hr@itcast.cn', '3232323', '金燕龙1楼大厅', 0, 1421164800000, 6, 1422263331951, '-', 0);
INSERT INTO `tbl_emp` VALUES (9, 'hr2', '2', 'hr专员', 'hr2@itcast.cn', '3232323', '中腾建华3楼', 0, 1421683200000, 6, 1422263354970, '-', 0);
COMMIT;

-- ----------------------------
-- Table structure for tbl_emp_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_emp_role`;
CREATE TABLE `tbl_emp_role` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `empUuid` bigint(20) NOT NULL,
  `roleUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_emp_role
-- ----------------------------
BEGIN;
INSERT INTO `tbl_emp_role` VALUES (11, 6, 1);
INSERT INTO `tbl_emp_role` VALUES (12, 8, 8);
INSERT INTO `tbl_emp_role` VALUES (13, 9, 9);
INSERT INTO `tbl_emp_role` VALUES (14, 11, 1);
INSERT INTO `tbl_emp_role` VALUES (15, 11, 2);
INSERT INTO `tbl_emp_role` VALUES (16, 11, 3);
INSERT INTO `tbl_emp_role` VALUES (17, 11, 4);
INSERT INTO `tbl_emp_role` VALUES (18, 11, 5);
INSERT INTO `tbl_emp_role` VALUES (19, 11, 6);
INSERT INTO `tbl_emp_role` VALUES (20, 11, 7);
COMMIT;

-- ----------------------------
-- Table structure for tbl_res
-- ----------------------------
DROP TABLE IF EXISTS `tbl_res`;
CREATE TABLE `tbl_res` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_res
-- ----------------------------
BEGIN;
INSERT INTO `tbl_res` VALUES (1, '员工列表', '');
INSERT INTO `tbl_res` VALUES (2, '操作添加/修改员工', '');
INSERT INTO `tbl_res` VALUES (3, '添加/修改员工', '');
INSERT INTO `tbl_res` VALUES (4, '删除员工', '');
COMMIT;

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `code` varchar(30) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
BEGIN;
INSERT INTO `tbl_role` VALUES (1, '系统管理员', 'admin');
INSERT INTO `tbl_role` VALUES (2, '采购主管', 'buymgr');
INSERT INTO `tbl_role` VALUES (3, '采购专员', 'buyer');
INSERT INTO `tbl_role` VALUES (4, '销售主管', 'salemgr');
INSERT INTO `tbl_role` VALUES (5, '销售专员', 'saler');
INSERT INTO `tbl_role` VALUES (6, '跟单员', 'follower');
INSERT INTO `tbl_role` VALUES (7, '仓库管理员', 'storemgr');
COMMIT;

-- ----------------------------
-- Table structure for tbl_role_res
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role_res`;
CREATE TABLE `tbl_role_res` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleUuid` bigint(20) NOT NULL,
  `resUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_role_res
-- ----------------------------
BEGIN;
INSERT INTO `tbl_role_res` VALUES (5, 1, 3);
INSERT INTO `tbl_role_res` VALUES (6, 1, 4);
INSERT INTO `tbl_role_res` VALUES (7, 1, 2);
INSERT INTO `tbl_role_res` VALUES (8, 1, 1);
INSERT INTO `tbl_role_res` VALUES (9, 8, 3);
INSERT INTO `tbl_role_res` VALUES (10, 8, 1);
INSERT INTO `tbl_role_res` VALUES (11, 8, 2);
INSERT INTO `tbl_role_res` VALUES (12, 9, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
