
# 文件服务
## 上传文件

**URL:** `http://127.0.0.1:9870/base/file/upload`

**Type:** `POST`


**Content-Type:** `multipart/form-data`

**Description:** 上传文件



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|file|file|false|No comments found.|-|


**Request-example:**
```
curl -X POST -H 'Content-Type: multipart/form-data' -F 'file=' -i http://127.0.0.1:9870/base/file/upload
```

**Response-example:**
```
{}
```

