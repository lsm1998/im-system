package com.lsm1998.im;

import com.lsm1998.im.imadmin.ImAdminApplication;
import com.lsm1998.im.imadmin.internal.role.sevice.RoleService;
import com.lsm1998.im.imadmin.internal.tenant.dao.TenantEntity;
import com.lsm1998.im.imadmin.internal.tenant.service.TenantService;
import com.lsm1998.im.imadmin.middleware.rabbitmq.RabbitPublish;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ImAdminApplication.class)
class ImAdminApplicationTests
{
    @Resource
    private TenantService tenantService;

    @Resource
    private RoleService roleService;

    @Resource
    private RabbitPublish publish;

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
        TenantEntity tenant = new TenantEntity();
        tenant.setAppid("appid");
        publish.publish("tenant_create" , tenant);
    }
}
