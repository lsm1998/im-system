package com.lsm1998.im.imadmin.internal.tenant.listen;

import com.lsm1998.im.imadmin.internal.tenant.dao.TenantEntity;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "tenant_create")
public class TenantCreateListen
{
    @Bean(name = "tenant_create_queue")
    public Queue Queue()
    {
        return new Queue("tenant_create");
    }

    @RabbitHandler
    public void process(TenantEntity tenant)
    {
        System.out.println("Receiver  : " + tenant);
    }
}
