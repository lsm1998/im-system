package com.lsm1998.im.imcomet.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "task.pool")
public class TaskPoolConfig
{
    private int corePoolSize;
    private int maxPoolSize;
    private int queueCapacity;
    private int keepAliveSeconds;

    public int getCorePoolSize()
    {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize)
    {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize()
    {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize)
    {
        this.maxPoolSize = maxPoolSize;
    }

    public int getQueueCapacity()
    {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity)
    {
        this.queueCapacity = queueCapacity;
    }

    public int getKeepAliveSeconds()
    {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds)
    {
        this.keepAliveSeconds = keepAliveSeconds;
    }
}
