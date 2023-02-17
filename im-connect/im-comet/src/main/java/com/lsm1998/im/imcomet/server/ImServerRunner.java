package com.lsm1998.im.imcomet.server;

import com.lsm1998.im.imcomet.im.ImService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * IM服务端
 */
@Component
public class ImServerRunner implements ApplicationRunner
{
    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        ImService imService = new ImService();
        imService.bind(8080);
    }
}
