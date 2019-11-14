/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : feature-email

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-11-14 19:32:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for email_user
-- ----------------------------
DROP TABLE IF EXISTS `email_user`;
CREATE TABLE `email_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL COMMENT '用户昵称',
  `user_password` varchar(50) NOT NULL COMMENT '用户登陆密码(加密)',
  `salt` varchar(10) NOT NULL COMMENT '用户盐值，用于独有的密码加密',
  `user_email` varchar(200) NOT NULL COMMENT '用户邮箱(加密)',
  `user_type` char(1) DEFAULT '2' COMMENT '用户类型:1.管理员，2:普通用户',
  `cust_name` varchar(20) DEFAULT NULL COMMENT '用户真实姓名(加密)',
  `is_deleted` char(1) DEFAULT '0' COMMENT '逻辑删除标志，0：正常，1：删除',
  PRIMARY KEY (`id`),
  KEY `index_email_user_name` (`user_name`),
  KEY `index_email_user_user_type` (`user_type`),
  KEY `index_email_user_is_deleted` (`is_deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of email_user
-- ----------------------------
