package com.lsm1998.im.imadmin.internal.base.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.common.annotations.AccessPermission;
import com.lsm1998.im.imadmin.middleware.minio.MinioComponent;
import com.lsm1998.im.imadmin.middleware.minio.MinioConfig;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务
 */
@RestController
@RequestMapping("base/file")
public class FileController
{
    @Resource
    private MinioComponent minioComponent;

    @Resource
    private MinioConfig config;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping("upload")
    @AccessPermission("base:file:upload")
    public AjaxResponse upload(MultipartFile file)
    {
        String url = minioComponent.upload(config.getBucketName(), file);
        return AjaxResponse.success(url);
    }
}
