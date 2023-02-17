package com.lsm1998.im.imcomet.server;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ImServerRunner implements ApplicationRunner
{
    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        LimServer limServer = new LimServer();
        limServer.bind(8080);
    }
}
