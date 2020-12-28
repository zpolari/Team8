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

 Date: 27/12/2020 18:09:27
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
  INDEX `fk_CTC_TechBook_1`(`ISBN`) USING BTREE,
  CONSTRAINT `fk_CTC_Class_1` FOREIGN KEY (`ClassName`) REFERENCES `Class` (`ClassName`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_CTC_Course_1` FOREIGN KEY (`CourseName`) REFERENCES `Course` (`CourseName`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_CTC_Teacher_1` FOREIGN KEY (`UnionID`) REFERENCES `Teacher` (`UnionID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_CTC_TechBook_1` FOREIGN KEY (`ISBN`) REFERENCES `TechBook` (`ISBN`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of CTC
-- ----------------------------
INSERT INTO `CTC` VALUES (402906219, '初一2班', '历史', NULL);
INSERT INTO `CTC` VALUES (402906219, '初一2班', '数学', NULL);
INSERT INTO `CTC` VALUES (402906219, '初一2班', '英语', NULL);
INSERT INTO `CTC` VALUES (402906219, '高一3班', '数学', NULL);
INSERT INTO `CTC` VALUES (402906219, '高二1班', '数学', NULL);
INSERT INTO `CTC` VALUES (402906219, '高二1班', '英语', NULL);
INSERT INTO `CTC` VALUES (436464827, '初一3班', '政治', NULL);
INSERT INTO `CTC` VALUES (544385330, '初一3班', '地理', NULL);
INSERT INTO `CTC` VALUES (586880206, '初一3班', '生物', NULL);
INSERT INTO `CTC` VALUES (586880206, '高一3班', '地理', NULL);
INSERT INTO `CTC` VALUES (544385330, '初一1班', '地理', '199');
INSERT INTO `CTC` VALUES (544385330, '初一1班', '化学', '203');
INSERT INTO `CTC` VALUES (402906219, '初一1班', '英语', '204');
INSERT INTO `CTC` VALUES (436464827, '初一3班', '数学', '204');
INSERT INTO `CTC` VALUES (544385330, '初一1班', '数学', '204');
INSERT INTO `CTC` VALUES (544385330, '初一1班', '历史', '205');
INSERT INTO `CTC` VALUES (544385330, '初一3班', '历史', '205');
INSERT INTO `CTC` VALUES (402906219, '初一1班', '生物', '413345321');
INSERT INTO `CTC` VALUES (402906219, '初一2班', '地理', '54124232');

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
INSERT INTO `Secretary` VALUES (103683333, '321', '321', '321', 321, '321', 1);
INSERT INTO `Secretary` VALUES (749927706, '123456', '123456', '11', 11, '123', 1);
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
  PRIMARY KEY (`UnionID`) USING BTREE,
  UNIQUE INDEX `Acc`(`Account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of Teacher
-- ----------------------------
INSERT INTO `Teacher` VALUES (402906219, 'zpolari', '123', '章威星', 12, '13067233333', 1);
INSERT INTO `Teacher` VALUES (436464827, 'Mr.zhang', '123', 'zpolari', 20, '131231122', 1);
INSERT INTO `Teacher` VALUES (544385330, '1231', '123', '312', 31, '3123122', 1);
INSERT INTO `Teacher` VALUES (545691232, '詹', '123', '詹', 1, '11111111111', 1);
INSERT INTO `Teacher` VALUES (586880206, '312312', '32112', '12312', 12, '13221312', 1);
INSERT INTO `Teacher` VALUES (843343958, '1551', '1551', '1', 13, '1', 1);

-- ----------------------------
-- Table structure for TechBook
-- ----------------------------
DROP TABLE IF EXISTS `TechBook`;
CREATE TABLE `TechBook`  (
  `ISBN` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Bname` varchar(190) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教材名称',
  `Author` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教材作者',
  `Type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教材类型',
  `Publisher` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `PublishTime` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ISBN`) USING BTREE,
  UNIQUE INDEX `Bname`(`Bname`) USING BTREE,
  INDEX `fk_TechBook_BookType_1`(`Type`) USING BTREE,
  CONSTRAINT `fk_TechBook_BookType_1` FOREIGN KEY (`Type`) REFERENCES `BookType` (`BookType`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of TechBook
-- ----------------------------
INSERT INTO `TechBook` VALUES ('199', 'J2EE编程指南2', 'zpoalri', '习题集', '123', '2000-01-20');
INSERT INTO `TechBook` VALUES ('203', 'JSP应用开发技术', 'zpolari', '普通教材', '人民邮电出版社', '2000-01-02');
INSERT INTO `TechBook` VALUES ('204', 'Head First Servlets&JSP', 'Bryan Basham', '习题集', '中国电力出版社', '1118-03-13');
INSERT INTO `TechBook` VALUES ('205', 'J2EE编程指南', 'Spielman Sue', '规划教材', '电子工业出版社', '2013-05-03');
INSERT INTO `TechBook` VALUES ('413345321', '语文书', '章威星', '普通教材', '厦门出版社', '2020-12-27');
INSERT INTO `TechBook` VALUES ('54124232', '数学书', '章威星', '规划教材', '511出版社', '2020-12-27');

SET FOREIGN_KEY_CHECKS = 1;
