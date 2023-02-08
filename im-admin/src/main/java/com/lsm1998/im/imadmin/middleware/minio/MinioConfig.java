package com.lsm1998.im.imadmin.middleware.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fs.minio")
@Data
public class MinioConfig
{
    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucketName;

    private String fileHost;
}
