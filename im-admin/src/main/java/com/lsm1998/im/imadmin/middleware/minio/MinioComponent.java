package com.lsm1998.im.imadmin.middleware.minio;

import io.micrometer.common.util.StringUtils;
import io.minio.*;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@Component
public class MinioComponent
{
    @Resource
    private MinioConfig config;

    private MinioClient minioClient;

    @PostConstruct
    public void init()
    {
        this.minioClient = MinioClient.builder()
                .endpoint(config.getEndpoint())
                .credentials(config.getAccessKey(), config.getSecretKey())
                .build();
    }

    /**
     * 查看存储bucket是否存在
     *
     * @return boolean
     */
    public Boolean bucketExists(String bucketName)
    {
        try
        {
            return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 创建存储bucket
     *
     * @return Boolean
     */
    public Boolean makeBucket(String bucketName)
    {
        try
        {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 文件上传
     *
     * @param file 文件
     * @return Boolean
     */
    public String upload(String bucketName, MultipartFile file)
    {
        String originalFilename = file.getOriginalFilename();
        if (StringUtils.isBlank(originalFilename))
        {
            throw new RuntimeException();
        }
        String fileName = UUID.randomUUID().toString()
                .replaceAll("-", "") + originalFilename.substring(originalFilename.lastIndexOf("."));
        String objectName = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance()
                .getTime()) + "/" + fileName;
        try
        {
            PutObjectArgs objectArgs = PutObjectArgs.builder().bucket(bucketName).object(objectName)
                    .stream(file.getInputStream(), file.getSize(), -1).contentType(file.getContentType()).build();
            //文件名称相同会覆盖
            minioClient.putObject(objectArgs);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return objectName;
    }

    /**
     * 删除
     *
     * @param bucketName
     * @param fileName
     * @return
     */
    public boolean remove(String bucketName, String fileName)
    {
        try
        {
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(fileName).build());
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }
}
