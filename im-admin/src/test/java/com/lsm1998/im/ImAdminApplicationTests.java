package com.lsm1998.im;

import com.lsm1998.im.imadmin.ImAdminApplication;
import com.lsm1998.im.imadmin.internal.tenant.service.TenantService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ImAdminApplication.class)
class ImAdminApplicationTests
{
    @Resource
    private TenantService tenantService;

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
}
