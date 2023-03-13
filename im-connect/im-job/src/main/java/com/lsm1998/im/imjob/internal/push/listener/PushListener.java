package com.lsm1998.im.imjob.internal.push.listener;

import com.lsm1998.im.common.dto.PushMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PushListener
{
    @KafkaListener(topics = "push")
    public void pushProcess(ConsumerRecord<String, PushMessage> record)
    {
        System.out.println("push");
    }
}
