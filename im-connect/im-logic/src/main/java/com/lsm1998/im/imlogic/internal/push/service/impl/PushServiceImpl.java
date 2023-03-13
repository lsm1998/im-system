package com.lsm1998.im.imlogic.internal.push.service.impl;

import com.lsm1998.im.imlogic.internal.message.service.MessageService;
import com.lsm1998.im.imlogic.internal.push.dto.request.BroadcastRequest;
import com.lsm1998.im.imlogic.internal.push.dto.request.PushGroupRequest;
import com.lsm1998.im.imlogic.internal.push.dto.request.PushRequest;
import com.lsm1998.im.imlogic.internal.push.service.PushService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
@Slf4j
public class PushServiceImpl implements PushService
{
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private MessageService messageService;

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

        // todo 推送 MQ 至 job 消费
    }

    @Override
    public void broadcast(BroadcastRequest request)
    {

    }

    @Override
    public void pushGroup(PushGroupRequest request)
    {

    }
}
