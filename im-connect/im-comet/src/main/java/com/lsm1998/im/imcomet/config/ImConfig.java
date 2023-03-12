package com.lsm1998.im.imcomet.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "im.server")
public class ImConfig
{
    private String nodeId;

    private String host;

    private Integer port;

    private Integer bucketNum;

    public String getNodeId()
    {
        return nodeId;
    }

    public void setNodeId(String nodeId)
    {
        this.nodeId = nodeId;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public Integer getPort()
    {
        return port;
    }

    public void setPort(Integer port)
    {
        this.port = port;
    }

    public Integer getBucketNum()
    {
        return bucketNum;
    }

    public void setBucketNum(Integer bucketNum)
    {
        this.bucketNum = bucketNum;
    }
}
