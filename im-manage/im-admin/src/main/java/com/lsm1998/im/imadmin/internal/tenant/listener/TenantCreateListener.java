package com.lsm1998.im.imadmin.internal.tenant.listener;

import com.lsm1998.im.imadmin.internal.account.service.AccountService;
import com.lsm1998.im.imadmin.internal.role.sevice.RoleService;
import com.lsm1998.im.imadmin.internal.tenant.dao.Tenant;
import com.rabbitmq.client.Channel;
import jakarta.annotation.Resource;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
@RabbitListener(queues = "tenant_create")
public class TenantCreateListener
{
    @Resource
    private RoleService roleService;

    @Resource
    private AccountService accountService;

    @Bean(name = "tenant_create_queue")
    public Queue queue()
    {
        return new Queue("tenant_create");
    }

    @RabbitHandler
    @Transactional
    public void process(Channel channel, @NotNull Tenant tenant, Message message) throws Exception
    {
        try
        {
            // 为tenant创建基础权限数据
            roleService.createBaseRole(tenant.getId());

            // 为tenant创建基础账户数据
            accountService.createBaseAccount(tenant.getId());

            // 为tenant创建服务包数据
        } catch (Exception e)
        {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        } finally
        {
            // channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);//确认消息接收
            // channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);//拒绝消息接收
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}
