package com.lsm1998.im.imlogic.internal.push.service.impl;

import com.lsm1998.im.common.dto.BroadcastMessage;
import com.lsm1998.im.common.dto.GroupMessage;
import com.lsm1998.im.common.dto.PushMessage;
import com.lsm1998.im.imlogic.internal.message.service.MessageService;
import com.lsm1998.im.imlogic.internal.push.dto.request.BroadcastRequest;
import com.lsm1998.im.imlogic.internal.push.dto.request.PushGroupRequest;
import com.lsm1998.im.imlogic.internal.push.dto.request.PushRequest;
import com.lsm1998.im.imlogic.internal.push.service.PushService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
@Slf4j
public class PushServiceImpl implements PushService
{
    private static final String PUSH_TOPIC = "im_push";

    private static final String BROADCAST_TOPIC = "im_broadcast";

    private static final String PUSH_GROUP_TOPIC = "im_group";

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private MessageService messageService;

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void push(PushRequest request)
    {
        List<String> nodeList = redisTemplate.opsForValue().multiGet(Arrays.asList(request.getToMid()));
        if (ObjectUtils.isEmpty(nodeList))
        {
            log.info("接收者不在线");
            messageService.saveOfflineMessage(request.ToMessage());
            return;
        }
        Map<String, List<String>> nodeMap = new HashMap<>(nodeList.size());
        for (int i = 0; i < nodeList.size(); i++)
        {
            String node = nodeList.get(i);
            List<String> list = nodeMap.get(node);
            if (list == null)
            {
                nodeMap.put(node, Collections.singletonList(request.getToMid()[i]));
            } else
            {
                list.add(request.getToMid()[i]);
            }
        }

        nodeMap.forEach((node, list) ->
        {
            PushMessage pushMessage = new PushMessage();
            pushMessage.setContent(request.getContent());
            pushMessage.setFormMid(request.getFromMid());
            pushMessage.setToMid(list.toArray(new String[]{}));
            pushMessage.setNodeId(node);
            pushMessage.setType(request.getType().getValue());
            pushMessage.setExt(request.getExt());
            kafkaTemplate.send(PUSH_TOPIC, pushMessage);
        });
    }

    @Override
    public void broadcast(BroadcastRequest request)
    {
        BroadcastMessage message = new BroadcastMessage();
        message.setContent(request.getContent());
        message.setType(request.getType().getValue());
        message.setFromId(request.getFroMid());
        kafkaTemplate.send(BROADCAST_TOPIC, message);
    }

    @Override
    public void pushGroup(PushGroupRequest request)
    {
        GroupMessage message = new GroupMessage();
        message.setContent(request.getContent());
        message.setType(request.getType().getValue());
        message.setFroMid(request.getFromMid());
        message.setGroupId(request.getGroupId());
        message.setExt(request.getExt());
        kafkaTemplate.send(PUSH_GROUP_TOPIC, message);
    }
}
