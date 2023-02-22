
# 账户服务
## 登录

**URL:** `http://127.0.0.1:9870/account/login`

**Type:** `POST`


**Content-Type:** `application/json`

**Description:** 登录




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|username|string|false|用户名|-|
|password|string|false|密码|-|
|loginIp|string|false|No comments found.|-|
|captchaId|string|false|验证码ID|-|
|captcha|string|false|验证码|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i http://127.0.0.1:9870/account/login --data '{
  "username": "tonie.schultz",
  "password": "zfc2oe",
  "loginIp": "111.135.85.153",
  "captchaId": "137",
  "captcha": "ghkr23"
}'
```

**Response-example:**
```
{}
```

## 退出登录

**URL:** `http://127.0.0.1:9870/account/loginOut`

**Type:** `POST`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 退出登录





**Request-example:**
```
curl -X POST -i http://127.0.0.1:9870/account/loginOut
```

**Response-example:**
```
{}
```

## 个人信息

**URL:** `http://127.0.0.1:9870/account/profile`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 个人信息





**Request-example:**
```
curl -X GET -i http://127.0.0.1:9870/account/profile
```

**Response-example:**
```
{}
```

## 创建账户

**URL:** `http://127.0.0.1:9870/account/create`

**Type:** `POST`


**Content-Type:** `application/json`

**Description:** 创建账户




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|account|object|false|account账户|-|
|└─id|int64|false|No comments found.|-|
|└─createTime|string|false|No comments found.|-|
|└─updateTime|string|false|No comments found.|-|
|└─deletedAt|int64|false|No comments found.|-|
|└─tenantId|int64|false|No comments found.|-|
|└─username|string|false|No comments found.|-|
|└─password|string|false|No comments found.|-|
|└─salt|string|false|No comments found.|-|
|roles|array|false|权限|-|
|└─id|int64|false|No comments found.|-|
|└─createTime|string|false|No comments found.|-|
|└─updateTime|string|false|No comments found.|-|
|└─deletedAt|int64|false|No comments found.|-|
|└─tenantId|int64|false|No comments found.|-|
|└─type|enum|false|No comments found.|-|
|└─roleName|string|false|No comments found.|-|
|└─roleKey|string|false|No comments found.|-|
|└─sort|int32|false|No comments found.|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i http://127.0.0.1:9870/account/create --data '{
  "account": {
    "id": 909,
    "createTime": "2023-02-17 00:09:28",
    "updateTime": "2023-02-17 00:09:28",
    "deletedAt": 75,
    "tenantId": 0,
    "username": "tonie.schultz",
    "password": "jqqizw",
    "salt": "ciy67w"
  },
  "roles": [
    {
      "id": 661,
      "createTime": "2023-02-17 00:09:28",
      "updateTime": "2023-02-17 00:09:28",
      "deletedAt": 66,
      "tenantId": 573,
      "type": "BaseRole",
      "roleName": "tonie.schultz",
      "roleKey": "ef6fmv",
      "sort": 921
    }
  ]
}'
```

**Response-example:**
```
{}
```

