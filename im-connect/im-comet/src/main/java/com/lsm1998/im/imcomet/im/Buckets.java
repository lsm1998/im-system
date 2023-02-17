package com.lsm1998.im.imcomet.im;

import com.lsm1998.im.common.utils.CityHashUtil;
import com.lsm1998.im.imcomet.im.bucket.Bucket;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class Buckets
{
    @Value("${im.comet.bucketNum:32}")
    private int bucketNum;

    private Bucket[] buckets;

    @PostConstruct
    public void init()
    {
        buckets = new Bucket[bucketNum];
    }

    public Bucket getBucket(String key)
    {
        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);
        long hash64 = CityHashUtil.cityHash64(bytes, 0, bytes.length);
        return buckets[(int) (hash64 % bucketNum)];
    }
}
