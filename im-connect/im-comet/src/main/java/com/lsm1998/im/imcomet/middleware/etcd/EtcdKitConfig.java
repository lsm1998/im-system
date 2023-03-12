package com.lsm1998.im.imcomet.middleware.etcd;

import com.ibm.etcd.client.EtcdClient;
import com.lsm1998.im.imcomet.config.EtcdConfig;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EtcdKitConfig
{
    @Resource
    private EtcdConfig etcdConfig;

    @Bean
    public EtcdKit etcdClient()
    {
        return new EtcdKit(etcdConfig.getEndpoints());
    }
}
