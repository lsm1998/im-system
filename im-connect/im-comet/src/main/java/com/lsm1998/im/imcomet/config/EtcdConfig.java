package com.lsm1998.im.imcomet.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "etcd")
public class EtcdConfig
{
    private List<String> endpoints;

    private String prefix;

    public List<String> getEndpoints()
    {
        return endpoints;
    }

    public void setEndpoints(List<String> endpoints)
    {
        this.endpoints = endpoints;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }
}
