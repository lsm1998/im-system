CREATE TABLE `tenant`
(
    `id`         int                                                          NOT NULL AUTO_INCREMENT,
    `created_at` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at` datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` int                                                          NOT NULL DEFAULT '0',
    `appid`      varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'appid',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_appid` (`appid`,`deleted_at`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='租户';

CREATE TABLE `tenant_account`
(
    `id`              int                                                           NOT NULL AUTO_INCREMENT,
    `created_at`      datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at`      datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at`      int                                                           NOT NULL DEFAULT '0',
    `appid`           varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT 'appid',
    `username`        varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '',
    `password`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '',
    `nickname`        varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '',
    `salt`            varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '',
    `email`           varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '',
    `mobile`          varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '',
    `avatar`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
    `gender`          varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   NOT NULL DEFAULT '',
    `birthday`        date                                                          NOT NULL,
    `last_login_time` datetime                                                      NOT NULL,
    `last_login_ip`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '',
    `motto`           varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_appid` (`appid`,`username`,`deleted_at`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='租户账户';

CREATE TABLE `tenant_menu`
(
    `id`         int                                                           NOT NULL AUTO_INCREMENT,
    `created_at` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` int                                                           NOT NULL DEFAULT '0',
    `pid`        int                                                           NOT NULL DEFAULT '0',
    `type`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '',
    `title`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '',
    `name`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '',
    `path`       varchar(128) COLLATE utf8mb4_general_ci                       NOT NULL DEFAULT '',
    `account`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '',
    `icon`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
    `menu_type`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '',
    `url`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
    `component`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
    `extend`     text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `level`      int                                                           NOT NULL DEFAULT '1',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='租户菜单';

CREATE TABLE `tenant_packet`
(
    `id`                int                                                          NOT NULL AUTO_INCREMENT,
    `created_at`        datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at`        datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at`        int                                                          NOT NULL DEFAULT '0',
    `appid`             varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'appid',
    `group_count_limit` int                                                          NOT NULL DEFAULT '0' COMMENT '群聊数量限制',
    `group_user_limit`  int                                                          NOT NULL DEFAULT '0' COMMENT '群聊人数限制',
    `user_limit`        int                                                          NOT NULL DEFAULT '0' COMMENT '用户人数限制',
    `integral`          int                                                          NOT NULL DEFAULT '0' COMMENT '积分',
    `level`             int                                                          NOT NULL DEFAULT '1' COMMENT '等级',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_appid` (`appid`,`deleted_at`) USING BTREE,
    KEY                 `idx_created_at` (`created_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='租户基础服务包';

CREATE TABLE `tenant_user`
(
    `id`            int                                                          NOT NULL AUTO_INCREMENT,
    `created_at`    datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at`    datetime                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at`    int                                                          NOT NULL DEFAULT '0',
    `appid`         varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'appid',
    `mid`           varchar(64) COLLATE utf8mb4_general_ci                       NOT NULL COMMENT '用户id',
    `secret_key`    varchar(64) COLLATE utf8mb4_general_ci                       NOT NULL COMMENT '密钥',
    `status`        tinyint                                                      NOT NULL DEFAULT '1' COMMENT '1启用 2禁用',
    `online_status` tinyint                                                      NOT NULL DEFAULT '1' COMMENT '1在线 2离线',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_appid` (`appid`,`mid`,`deleted_at`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='租户IM用户';

CREATE TABLE `tenant_access_token`
(
    `id`         int                                                   NOT NULL AUTO_INCREMENT,
    `created_at` datetime                                              NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at` datetime                                              NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` int                                                   NOT NULL DEFAULT '0',
    `appid`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'appid',
    `access_key` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'ak',
    `secret_key` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'sk',
    `status`     tinyint                                               NOT NULL DEFAULT '1' COMMENT '1启用 2禁用',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_appid` (`appid`,`deleted_at`) USING BTREE,
    UNIQUE KEY `idx_access_key` (`access_key`,`deleted_at`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='租户access token';