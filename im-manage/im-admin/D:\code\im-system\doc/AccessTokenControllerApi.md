
# 访问凭证服务
## 创建访问凭证

**URL:** `http://127.0.0.1:9870/accessToken`

**Type:** `POST`


**Content-Type:** `application/json`

**Description:** 创建访问凭证




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|appId|string|true|No comments found.|-|
|accessKey|string|true|No comments found.|-|
|secretKey|string|true|No comments found.|-|
|roles|array|false|No comments found.|-|
|└─id|int64|false|No comments found.|-|
|└─createTime|string|false|No comments found.|-|
|└─updateTime|string|false|No comments found.|-|
|└─deletedAt|int64|false|No comments found.|-|
|└─accessTokenId|int64|false|No comments found.|-|
|└─roleId|int64|false|No comments found.|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i http://127.0.0.1:9870/accessToken --data '{
  "appId": "137",
  "accessKey": "dly54c",
  "secretKey": "xu7nm1",
  "roles": [
    {
      "id": 925,
      "createTime": "2023-02-17 00:09:28",
      "updateTime": "2023-02-17 00:09:28",
      "deletedAt": 265,
      "accessTokenId": 242,
      "roleId": 636
    }
  ]
}'
```

**Response-example:**
```
{}
```

## 更新访问凭证

**URL:** `http://127.0.0.1:9870/accessToken`

**Type:** `PUT`


**Content-Type:** `application/json`

**Description:** 更新访问凭证




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int64|false|No comments found.|-|
|roles|array|false|No comments found.|-|
|└─id|int64|false|No comments found.|-|
|└─createTime|string|false|No comments found.|-|
|└─updateTime|string|false|No comments found.|-|
|└─deletedAt|int64|false|No comments found.|-|
|└─accessTokenId|int64|false|No comments found.|-|
|└─roleId|int64|false|No comments found.|-|

**Request-example:**
```
curl -X PUT -H 'Content-Type: application/json' -i http://127.0.0.1:9870/accessToken --data '{
  "id": 615,
  "roles": [
    {
      "id": 804,
      "createTime": "2023-02-17 00:09:28",
      "updateTime": "2023-02-17 00:09:28",
      "deletedAt": 877,
      "accessTokenId": 23,
      "roleId": 55
    }
  ]
}'
```

**Response-example:**
```
{}
```

## 删除访问凭证

**URL:** `http://127.0.0.1:9870/accessToken/{id}`

**Type:** `DELETE`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 删除访问凭证


**Path-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|id|int64|true|No comments found.|-|



**Request-example:**
```
curl -X DELETE -i http://127.0.0.1:9870/accessToken/164
```

**Response-example:**
```
{}
```

## 查询列表

**URL:** `http://127.0.0.1:9870/accessToken`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 查询列表



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|appid|string|false|No comments found.|-|
|page|int32|false|No comments found.|-|
|size|int32|false|No comments found.|-|


**Request-example:**
```
curl -X GET -i http://127.0.0.1:9870/accessToken?appid=137&page=1&size=10
```

**Response-example:**
```
{}
```

