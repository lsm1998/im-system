package com.lsm1998.im.imcomet.runner;

import com.ibm.etcd.api.KeyValue;
import com.lsm1998.im.common.net.LocalHost;
import com.lsm1998.im.imcomet.config.EtcdConfig;
import com.lsm1998.im.imcomet.config.ImConfig;
import com.lsm1998.im.imcomet.middleware.etcd.EtcdKit;
import com.lsm1998.im.imcomet.runner.im.ImService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * IM服务端
 */
@Slf4j
@Component
public class ImServerRunner implements ApplicationRunner
{
    @Resource
    private ImConfig imConfig;

    @Resource(name = "imThreadPool")
    private Executor executor;

    @Resource
    private EtcdKit etcdKit;

    @Resource
    private EtcdConfig etcdConfig;

    @Override
    public void run(ApplicationArguments args)
    {
        executor.execute(this::start);
        executor.execute(this::register);
    }

    public void start()
    {
        ImService imService = new ImService(imConfig.getHost(), imConfig.getPort());
        try
        {
            imService.start();
        } catch (InterruptedException e)
        {
            log.error("IM服务端启动失败,err={}", e.getMessage());
            System.exit(-1);
        }
    }

    public void register()
    {
        try
        {
            long ttl = 4;
            String key = String.format("%s%s", etcdConfig.getPrefix(), imConfig.getNodeId());
            String value = String.format("%s:%d", LocalHost.localHost(), imConfig.getPort());
            etcdKit.register(key, value);
            log.info("etcd注册完成");
            Duration sleepTime = Duration.ofSeconds(ttl);
            while (true)
            {
                Thread.sleep(sleepTime.toMillis());
                etcdKit.keepalive(key, value, Duration.ofSeconds(ttl));
                log.info("etcd keepalive...");
            }
        } catch (InterruptedException e)
        {
            // nop
            log.error("休眠状态中程序被中止");
        } catch (Exception e)
        {
            log.error("etcd注册失败,err={}", e.getMessage());
            System.exit(-1);
        }
    }
}
