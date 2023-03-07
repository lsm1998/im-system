package com.lsm1998.im.imcomet.middleware.etcd;

import com.ibm.etcd.client.EtcdClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EtcdConfig
{
    @Value("#{'${etcd.endpoints}'.split(',')}")
    private List<String> endpoints;

    @Bean
    public EtcdClient etcdClient()
    {
        return EtcdClient.forEndpoints(endpoints).build();
    }
}
