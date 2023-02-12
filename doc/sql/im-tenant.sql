/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : 120.79.132.241:3306
 Source Schema         : im-tenant

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 12/02/2023 23:46:40
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '账户' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tenant
-- ----------------------------
DROP TABLE IF EXISTS `tenant`;
CREATE TABLE `tenant`
(
    `id`         int                                                          NOT NULL AUTO_INCREMENT,
    `created_at` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` int                                                          NOT NULL DEFAULT 0,
    `appid`      varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '租户唯一id',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `idx_appid`(`appid` ASC, `deleted_at` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '租户' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tenant_base_packet
-- ----------------------------
DROP TABLE IF EXISTS `tenant_base_packet`;
CREATE TABLE `tenant_base_packet`
(
    `id`                int      NOT NULL AUTO_INCREMENT,
    `created_at`        datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at`        datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at`        int      NOT NULL DEFAULT 0,
    `tenant_id`         int      NOT NULL,
    `group_count_limit` int      NOT NULL DEFAULT 0 COMMENT '群聊数量限制',
    `group_user_limit`  int      NOT NULL DEFAULT 0 COMMENT '群聊人数限制',
    `user_limit`        int      NOT NULL DEFAULT 0 COMMENT '用户人数限制',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `idx_tenant_type`(`tenant_id` ASC, `deleted_at` ASC, `group_count_limit` ASC) USING BTREE,
    INDEX               `idx_created_at`(`created_at` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '租户基础服务包' ROW_FORMAT = DYNAMIC;

SET
FOREIGN_KEY_CHECKS = 1;
