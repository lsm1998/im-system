package com.lsm1998.im;

import com.lsm1998.im.imadmin.ImAdminApplication;
import com.lsm1998.im.imadmin.internal.role.sevice.RoleService;
import com.lsm1998.im.imadmin.internal.tenant.dao.Tenant;
import com.lsm1998.im.imadmin.internal.tenant.service.TenantService;
import com.lsm1998.im.imadmin.middleware.minio.MinioComponent;
import com.lsm1998.im.imadmin.middleware.rabbitmq.RabbitPublish;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest(classes = ImAdminApplication.class)
class ImAdminApplicationTests
{
    @Resource
    private TenantService tenantService;

    @Resource
    private RoleService roleService;

    @Resource
    private RabbitPublish publish;

    @Resource
    private MinioComponent minioComponent;

    @Test
    void contextLoads()
    {
        System.out.println("hello");
    }

    @Test
    void insertAppid()
    {
        tenantService.generateAppid("123");
    }

    @Test
    void createBaseRole()
    {
        roleService.createBaseRole(1L);
    }

    @Test
    void publish()
    {
        Tenant tenant = new Tenant();
        tenant.setAppid("appid");
        publish.publish("tenant_create", tenant);
    }

    @Test
    void bucket()
    {
        String bucketName = "im-admin";
        if (!minioComponent.bucketExists(bucketName))
        {
            minioComponent.makeBucket("im-admin");
        }
    }

    @Test
    void upload()
    {
        System.out.println(minioComponent.upload("im-admin", new File("C:\\Users\\p8s8liushim\\Pictures\\images.png")));
    }

    @Test
    void deleteTenant()
    {
        System.out.println(tenantService.delete(1L));
    }
}
