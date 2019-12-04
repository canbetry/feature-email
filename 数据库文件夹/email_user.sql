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
-- Table structure for fe_user
-- ----------------------------
DROP TABLE IF EXISTS `fe_user`;
CREATE TABLE `fe_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL COMMENT '用户昵称',
  `user_password` varchar(50) NOT NULL COMMENT '用户登陆密码(加密)',
  `salt` varchar(10) NOT NULL COMMENT '用户盐值，用于独有的密码加密',
  `user_email` varchar(200) NOT NULL COMMENT '用户邮箱(加密)',
  `user_type` char(1) DEFAULT '2' COMMENT '用户类型:1.管理员，2:普通用户',
  `cust_name` varchar(20) DEFAULT NULL COMMENT '用户真实姓名(加密)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间，注册时默认当前时间',
  `update_time` varchar(50) DEFAULT NULL COMMENT '用户更新时间，更新用户信息的时间',
  `is_deleted` char(1) DEFAULT '0' COMMENT '逻辑删除标志，0：正常，1：删除',
  PRIMARY KEY (`id`),
  KEY `index_fe_user_type` (`user_type`),
  KEY `index_fe_user_is_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of fe_user
-- ----------------------------
-- ----------------------------
-- Table structure for fe_send_email
-- ----------------------------
DROP TABLE IF EXISTS `fe_send_email`;
CREATE TABLE `fe_send_email` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `send_user_id` varchar(50) NOT NULL COMMENT '寄件用户id',
  `send_user_real_name` varchar(30) NOT NULL COMMENT '寄件人(真实姓名)',
  `send_user_real_email` varchar(200) NOT NULL COMMENT '寄件人邮箱,邮件寄件时会发一封邮件通知寄件人',
  `recive_user_real_name` varchar(30) NOT NULL COMMENT '收件人(真实姓名)',
  `recive_user_real_addr` varchar(200) DEFAULT '寄件人选择网络邮箱收件' COMMENT '收件人真实地址',
  `recive_user_real_email` varchar(200) NOT NULL COMMENT '收件人邮箱,邮件寄件时会发一封邮件通知收件人',
  `send_email_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发邮件时间',
  `revice_email_time` varchar(50) DEFAULT NULL COMMENT '收邮件时间',
  `total_email_id` bigint(20) NOT NULL COMMENT '发送邮件对应总邮件表id',
  `email_status` varchar(10) NOT NULL COMMENT '邮件状态:未收货、已收货',
  `is_deleted` char(1) DEFAULT '0' COMMENT '逻辑删除标志，0：正常，1：删除',
  PRIMARY KEY (`id`),
  KEY `index_fe_send_email_status` (`email_status`),
  KEY `index_fe_send_email_is_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='寄件表,已经寄出去的邮件表';
-- ----------------------------
-- Records of fe_send_email
-- ----------------------------
-- ----------------------------
-- Table structure for fe_total_email
-- ----------------------------
CREATE TABLE `fe_total_email` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '写邮件的用户id',
  `email_title` varchar(255) NOT NULL COMMENT '邮件主题',
  `email_content` mediumtext COMMENT '邮件具体内容',
  `send_user_real_name` varchar(30) NOT NULL COMMENT '寄件人(真实姓名)',
  `send_user_real_email` varchar(200) NOT NULL COMMENT '寄件人邮箱,邮件寄件时会发一封邮件通知寄件人',
  `recive_user_real_name` varchar(30) NOT NULL COMMENT '收件人(真实姓名)',
  `recive_user_real_addr` varchar(200) DEFAULT '寄件人选择网络邮箱收件' COMMENT '收件人真实地址',
  `recive_user_real_email` varchar(200) NOT NULL COMMENT '收件人邮箱,邮件寄件时会发一封邮件通知收件人',
  `create_email_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '邮件创建时间',
  `update_email_time` varchar(50) DEFAULT NULL COMMENT '邮件更新时间',
  `is_send` varchar(10) DEFAULT '未发送' COMMENT '邮件是否发送：未发送、已发送 ',
  `is_deleted` char(1) DEFAULT '0' COMMENT '逻辑删除标志，0：正常，1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件总表';
-- ----------------------------
-- Records of fe_total_email
-- ----------------------------