/*
 Navicat Premium Data Transfer

 Source Server         : cproot
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : 116.255.186.125:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 15/12/2020 16:46:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for BookType
-- ----------------------------
DROP TABLE IF EXISTS `BookType`;
CREATE TABLE `BookType`  (
  `BookType` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`BookType`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of BookType
-- ----------------------------
INSERT INTO `BookType` VALUES ('123');
INSERT INTO `BookType` VALUES ('习题集');
INSERT INTO `BookType` VALUES ('普通教材');
INSERT INTO `BookType` VALUES ('规划教材');

-- ----------------------------
-- Table structure for CTC
-- ----------------------------
DROP TABLE IF EXISTS `CTC`;
CREATE TABLE `CTC`  (
  `UnionID` int(11) NOT NULL,
  `ClassName` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `CourseName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ISBN` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  UNIQUE INDEX `CTC`(`UnionID`, `ClassName`, `CourseName`) USING BTREE,
  INDEX `fk_CTC_Class_1`(`ClassName`) USING BTREE,
  INDEX `fk_CTC_Course_1`(`CourseName`) USING BTREE,
  CONSTRAINT `fk_CTC_Class_1` FOREIGN KEY (`ClassName`) REFERENCES `Class` (`ClassName`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_CTC_Course_1` FOREIGN KEY (`CourseName`) REFERENCES `Course` (`CourseName`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_CTC_Teacher_1` FOREIGN KEY (`UnionID`) REFERENCES `Teacher` (`UnionID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of CTC
-- ----------------------------
INSERT INTO `CTC` VALUES (544385330, '初一1班', '化学', NULL);
INSERT INTO `CTC` VALUES (544385330, '初一1班', '政治', NULL);
INSERT INTO `CTC` VALUES (544385330, '初一3班', '化学', '201');
INSERT INTO `CTC` VALUES (544385330, '初一3班', '政治', '202');
INSERT INTO `CTC` VALUES (544385330, '初一4班', '政治', NULL);
INSERT INTO `CTC` VALUES (1912120346, '初一2班', '数学', '201');

-- ----------------------------
-- Table structure for Class
-- ----------------------------
DROP TABLE IF EXISTS `Class`;
CREATE TABLE `Class`  (
  `ClassName` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`ClassName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of Class
-- ----------------------------
INSERT INTO `Class` VALUES ('初一1班');
INSERT INTO `Class` VALUES ('初一2班');
INSERT INTO `Class` VALUES ('初一3班');
INSERT INTO `Class` VALUES ('初一4班');
INSERT INTO `Class` VALUES ('高一3班');
INSERT INTO `Class` VALUES ('高三1班');
INSERT INTO `Class` VALUES ('高二1班');

-- ----------------------------
-- Table structure for Course
-- ----------------------------
DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course`  (
  `CourseName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`CourseName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of Course
-- ----------------------------
INSERT INTO `Course` VALUES ('化学');
INSERT INTO `Course` VALUES ('历史');
INSERT INTO `Course` VALUES ('地理');
INSERT INTO `Course` VALUES ('政治');
INSERT INTO `Course` VALUES ('数学');
INSERT INTO `Course` VALUES ('生物');
INSERT INTO `Course` VALUES ('英语');
INSERT INTO `Course` VALUES ('语文');

-- ----------------------------
-- Table structure for Secretary
-- ----------------------------
DROP TABLE IF EXISTS `Secretary`;
CREATE TABLE `Secretary`  (
  `UnionID` int(11) NOT NULL COMMENT '全局唯一ID',
  `Account` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账户登录名',
  `Password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账户密码',
  `Name` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '秘书名称',
  `Age` int(11) NULL DEFAULT NULL COMMENT '秘书年龄',
  `Telephone` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `LastLogin` bigint(20) NULL DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`UnionID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of Secretary
-- ----------------------------
INSERT INTO `Secretary` VALUES (123, '123', '123', '123', NULL, NULL, NULL);
INSERT INTO `Secretary` VALUES (1912120346, '1912120346', '1912120346', 'zpolari', 19, '15555388121', 12);

-- ----------------------------
-- Table structure for Teacher
-- ----------------------------
DROP TABLE IF EXISTS `Teacher`;
CREATE TABLE `Teacher`  (
  `UnionID` int(11) NOT NULL COMMENT '全局唯一ID',
  `Account` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账户登录名',
  `Password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账户密码',
  `Name` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `Age` int(11) NULL DEFAULT NULL COMMENT '教师年龄',
  `Telephone` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师电话',
  `LastLogin` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`UnionID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of Teacher
-- ----------------------------
INSERT INTO `Teacher` VALUES (402906219, 'zjj', 'zjj', 'zjjnb', 123123, 'zjj', 1);
INSERT INTO `Teacher` VALUES (544385330, '33333', '123', '312321', 312321, '123', 1);
INSERT INTO `Teacher` VALUES (1912120346, '1912120346', '1912120346', 'Mr.zhang', 20, '1555388121', 12);

-- ----------------------------
-- Table structure for TechBook
-- ----------------------------
DROP TABLE IF EXISTS `TechBook`;
CREATE TABLE `TechBook`  (
  `ISBN` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Bname` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `Author` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教材作者',
  `Type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教材类型',
  `Publisher` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `PublishTime` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ISBN`) USING BTREE,
  INDEX `fk_TechBook_BookType_1`(`Type`) USING BTREE,
  CONSTRAINT `fk_TechBook_BookType_1` FOREIGN KEY (`Type`) REFERENCES `BookType` (`BookType`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of TechBook
-- ----------------------------
INSERT INTO `TechBook` VALUES ('202', 'Tomcat与Java Web 开发技术祥解', '孙卫琴', '规划教材', '机械工业出版社	', '2000-1-1');
INSERT INTO `TechBook` VALUES ('203', 'JSP应用开发技术', '321', '普通教材', '人民邮电出版社	', '2000-1-2');
INSERT INTO `TechBook` VALUES ('204', 'Head First Servlets&JSP	', 'Bryan Basham', '习题集', '中国电力出版社', '1202-3-3');
INSERT INTO `TechBook` VALUES ('205', 'J2EE编程指南', 'Spielman Sue', '规划教材', '电子工业出版社', '2013-5-3');
INSERT INTO `TechBook` VALUES ('213134124124', 'Servlets与JSP核心教程', 'Hall Marty', '普通教材', '清华大学出版社', '2000-1-1');

SET FOREIGN_KEY_CHECKS = 1;
