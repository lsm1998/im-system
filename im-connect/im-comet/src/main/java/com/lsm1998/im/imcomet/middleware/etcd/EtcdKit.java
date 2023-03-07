package com.lsm1998.im.imcomet.middleware.etcd;

import com.google.protobuf.ByteString;
import com.ibm.etcd.api.LeaseGrantResponse;
import com.ibm.etcd.client.EtcdClient;
import com.ibm.etcd.client.kv.KvClient;
import com.ibm.etcd.client.lease.PersistentLease;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.ExecutionException;

@Component
public class EtcdKit
{
    @Resource
    private EtcdClient etcdClient;

    private static final int DEFAULT_TTL = 5;

    private KvClient kvClient;

    @PostConstruct
    public void init()
    {
        this.kvClient = etcdClient.getKvClient();
    }

    public void put(String key, String value)
    {
        this.put(key, value, 0);
    }

    public void put(String key, String value, long leaseId)
    {
        kvClient.put(ByteString.copyFrom(key.getBytes(StandardCharsets.UTF_8)),
                ByteString.copyFrom(value.getBytes(StandardCharsets.UTF_8)),
                leaseId).sync();
    }

    public void register(String key, String value)
    {
        register(key, value, Duration.ofSeconds(DEFAULT_TTL));
    }

    public void register(String key, String value, Duration ttl)
    {
        if (ObjectUtils.isEmpty(key) || ObjectUtils.isEmpty(value))
        {
            throw new RuntimeException("参数错误，kv不可以为空");
        }
        LeaseGrantResponse response = etcdClient.getLeaseClient().grant(ttl.getSeconds()).sync();
        this.put(key, value, response.getID());
    }

    public void keepalive(String key, String value, Duration ttl) throws ExecutionException, InterruptedException
    {
        PersistentLease lease = etcdClient.
                getLeaseClient().
                maintain().
                leaseId(System.currentTimeMillis()).
                keepAliveFreq((int) ttl.getSeconds()).
                start();
        this.put(key, value, lease.get());
    }
}
