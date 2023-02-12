package com.lsm1998.im.imadmin.middleware.rabbitmq;

import jakarta.annotation.Resource;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitPublish
{
    @Resource
    private AmqpTemplate rabbitTemplate;

    public <T> void publish(String queueName, T data)
    {
        this.rabbitTemplate.convertAndSend(queueName, data);
    }
}
