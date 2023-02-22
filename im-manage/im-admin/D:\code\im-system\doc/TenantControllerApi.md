
# 租户服务
## 创建租户

**URL:** `http://127.0.0.1:9870/tenant/create`

**Type:** `POST`


**Content-Type:** `application/json`

**Description:** 创建租户




**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|appid|string|false|No comments found.|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i http://127.0.0.1:9870/tenant/create --data '{
  "appid": "137"
}'
```

**Response-example:**
```
{}
```

