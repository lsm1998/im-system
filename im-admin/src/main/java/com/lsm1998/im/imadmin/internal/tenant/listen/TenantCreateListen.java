package com.lsm1998.im.imadmin.internal.tenant.listen;

import com.lsm1998.im.imadmin.internal.account.service.AccountService;
import com.lsm1998.im.imadmin.internal.role.sevice.RoleService;
import com.lsm1998.im.imadmin.internal.tenant.dao.Tenant;
import jakarta.annotation.Resource;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RabbitListener(queues = "tenant_create")
public class TenantCreateListen
{
    @Resource
    private RoleService roleService;

    @Resource
    private AccountService accountService;

    @Bean(name = "tenant_create_queue")
    public Queue Queue()
    {
        return new Queue("tenant_create");
    }

    @RabbitHandler
    @Transactional
    public void process(@NotNull Tenant tenant)
    {
        // 为tenant创建基础权限数据
        roleService.createBaseRole(tenant.getId());

        // 为tenant创建基础账户数据
        accountService.createBaseAccount(tenant.getId());

        // 为tenant创建服务包数据
    }
}
