package com.lsm1998.im.imjob.middleware.redis;

import jakarta.annotation.Resource;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

@Component
public class OnlineRedisFacade
{
    private static final String ONLINE_KEY = "online:list";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void addOnline(Long userId)
    {
        redisTemplate.opsForValue().setBit(ONLINE_KEY, userId, true);
    }

    public void removeOnline(Long userId)
    {
        redisTemplate.opsForValue().setBit(ONLINE_KEY, userId, false);
    }

    public boolean isOnline(Long userId)
    {
        return Boolean.TRUE.equals(redisTemplate.opsForValue().getBit(ONLINE_KEY, userId));
    }

    public int getOnlineCount()
    {
        List<Long> bitField = redisTemplate.opsForValue()
                .bitField(ONLINE_KEY, BitFieldSubCommands.create().get(BitFieldSubCommands.BitFieldType.unsigned(1))
                        .valueAt(0));
        if (ObjectUtils.isEmpty(bitField))
            return 0;
        return bitField.size();
    }

    public List<Long> getOnlineList()
    {
        return redisTemplate.execute((RedisCallback<List<Long>>) connection ->
        {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            return connection.bitField(Objects.requireNonNull(serializer.serialize(ONLINE_KEY)), BitFieldSubCommands.create()
                    .get(BitFieldSubCommands.BitFieldType.unsigned(1))
                    .valueAt(0));
        });
    }
}
