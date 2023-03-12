package com.lsm1998.im.imcomet.middleware.etcd;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.ByteString;
import com.ibm.etcd.api.KeyValue;
import com.ibm.etcd.api.LeaseGrantResponse;
import com.ibm.etcd.api.RangeResponse;
import com.ibm.etcd.client.EtcdClient;
import com.ibm.etcd.client.kv.KvClient;
import com.ibm.etcd.client.lease.PersistentLease;
import org.springframework.util.ObjectUtils;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class EtcdKit
{
    private final EtcdClient etcdClient;

    private final KvClient kvClient;

    private int ttl = 4;

    public EtcdKit(String endpoints)
    {
        this(endpoints, 4);
    }

    public EtcdKit(List<String> endpoints)
    {
        this(endpoints, 4);
    }

    public EtcdKit(String endpoints, int ttl)
    {
        this(endpoints, null, ttl);

    }

    public EtcdKit(List<String> endpoints, int ttl)
    {
        this(null, endpoints, ttl);
    }

    private EtcdKit(String endpoints, List<String> list, int ttl)
    {
        if (ttl > 0)
        {
            this.ttl = ttl;
        }
        EtcdClient.Builder builder;
        if (endpoints != null)
        {
            builder = EtcdClient.forEndpoints(endpoints);
        } else
        {
            builder = EtcdClient.forEndpoints(list);
        }
        this.etcdClient = builder.withPlainText().build();
        this.kvClient = this.etcdClient.getKvClient();
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
        register(key, value, Duration.ofSeconds(ttl));
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

    public List<KeyValue> get(String key) throws ExecutionException, InterruptedException
    {
        ByteString byteString = ByteString.copyFrom(key.getBytes(StandardCharsets.UTF_8));
        KvClient.FluentRangeRequest request = kvClient.get(byteString);
        ListenableFuture<RangeResponse> future = request.async();
        RangeResponse response = future.get();
        return response.getKvsList();
    }
}
