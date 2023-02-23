package com.lsm1998.im.imcomet.runner;

import com.lsm1998.im.imcomet.im.ImService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * IM服务端
 */
@Slf4j
@Component
public class ImServerRunner implements ApplicationRunner
{
    @Value("${im.server.port:8888}")
    private int port;

    @Value("${im.server.host:localhost}")
    private String host;

    @Resource(name = "imThreadPool")
    private Executor executor;

    @Override
    public void run(ApplicationArguments args)
    {
        executor.execute(this::start);
    }

    public void start()
    {
        ImService imService = new ImService(host, port);
        try
        {
            imService.start();
        } catch (InterruptedException e)
        {
            log.error("IM服务端启动失败,err={}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
