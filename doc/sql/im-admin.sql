/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : 120.79.132.241:3306
 Source Schema         : im-admin

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 12/02/2023 23:22:58
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for access_role
-- ----------------------------
DROP TABLE IF EXISTS `access_role`;
CREATE TABLE `access_role`
(
    `id`              int      NOT NULL AUTO_INCREMENT,
    `created_at`      datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at`      datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at`      int      NOT NULL DEFAULT 0,
    `access_token_id` int      NOT NULL DEFAULT 0 COMMENT 'token id',
    `role_id`         int      NOT NULL DEFAULT 0 COMMENT 'role id',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `idx_access_token_id`(`access_token_id` ASC, `role_id` ASC, `deleted_at` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '登录日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for access_token
-- ----------------------------
DROP TABLE IF EXISTS `access_token`;
CREATE TABLE `access_token`
(
    `id`         int                                                   NOT NULL AUTO_INCREMENT,
    `created_at` datetime                                              NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at` datetime                                              NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` int                                                   NOT NULL DEFAULT 0,
    `appid`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'appid',
    `access_key` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'ak',
    `secret_key` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'sk',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `idx_appid_access_key`(`appid` ASC, `access_key` ASC, `deleted_at` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '登录日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`
(
    `id`         int                                                           NOT NULL AUTO_INCREMENT,
    `created_at` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` int                                                           NOT NULL DEFAULT 0,
    `tenant_id`  int                                                           NOT NULL DEFAULT 0,
    `username`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '账户',
    `password`   varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
    `salt`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '密码盐',
    `phone`      varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '电话',
    `email`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
    `nickname`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '昵称',
    `avatar`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
    `status`     tinyint(1) NOT NULL DEFAULT 1 COMMENT '帐号状态（1正常 2停用）',
    `login_ip`   varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '最后登录IP',
    `login_date` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登录时间',
    `skin_style` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '皮肤风格',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `idx_tenant_username`(`tenant_id` ASC, `username` ASC, `deleted_at` ASC) USING BTREE,
    INDEX        `idx_created_at`(`created_at` ASC) USING BTREE,
    INDEX        `idx_phone`(`phone` ASC, `deleted_at` ASC) USING BTREE,
    INDEX        `idx_email`(`email` ASC, `deleted_at` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '账户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for loginin_log
-- ----------------------------
DROP TABLE IF EXISTS `loginin_log`;
CREATE TABLE `loginin_log`
(
    `id`             int                                                    NOT NULL AUTO_INCREMENT,
    `created_at`     datetime                                               NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at`     datetime                                               NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at`     int                                                    NOT NULL DEFAULT 0,
    `username`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  NOT NULL DEFAULT '' COMMENT '用户账号',
    `ipaddr`         varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '登录IP地址',
    `login_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '登录地点',
    `browser`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  NOT NULL DEFAULT '' COMMENT '浏览器类型',
    `os`             varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  NOT NULL DEFAULT '' COMMENT '操作系统',
    `status`         tinyint                                                NOT NULL DEFAULT 0 COMMENT '登录状态（1成功 2失败）',
    `msg`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '提示消息',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX            `idx_username`(`username` ASC) USING BTREE,
    INDEX            `idx_created_at`(`created_at` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '登录日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `id`         int                                                          NOT NULL AUTO_INCREMENT,
    `created_at` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` int                                                          NOT NULL DEFAULT 0,
    `tenant_id`  int                                                          NOT NULL DEFAULT 0,
    `type`       tinyint                                                      NOT NULL DEFAULT 0 COMMENT '1基础 2用户创建',
    `role_name`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
    `role_key`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'key',
    `sort`       int                                                          NOT NULL DEFAULT 0 COMMENT '排序',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `idex_tenant_key`(`tenant_id` ASC, `role_key` ASC, `deleted_at` ASC) USING BTREE,
    INDEX        `idx_created_at`(`created_at` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3790 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_account
-- ----------------------------
DROP TABLE IF EXISTS `role_account`;
CREATE TABLE `role_account`
(
    `id`         int      NOT NULL AUTO_INCREMENT,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` int      NOT NULL DEFAULT 0,
    `tenant_id`  int      NOT NULL DEFAULT 0,
    `role_id`    int      NOT NULL DEFAULT 0,
    `account_id` int      NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `idex_tenant_role`(`tenant_id` ASC, `role_id` ASC, `account_id` ASC, `deleted_at` ASC) USING BTREE,
    INDEX        `idx_created_at`(`created_at` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限 角色-账户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_authority
-- ----------------------------
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority`
(
    `id`            int                                                          NOT NULL AUTO_INCREMENT,
    `created_at`    datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at`    datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at`    int                                                          NOT NULL DEFAULT 0,
    `role_id`       int                                                          NOT NULL DEFAULT 0 COMMENT 'role id',
    `authority_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限标识',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'role权限' ROW_FORMAT = Dynamic;
SET
FOREIGN_KEY_CHECKS = 1;
