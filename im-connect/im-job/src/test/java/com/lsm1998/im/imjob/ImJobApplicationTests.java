package com.lsm1998.im.imjob;

import com.lsm1998.im.imjob.internal.push.service.PushService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ImJobApplication.class)
class ImJobApplicationTests
{
    @Resource
    private PushService pushService;

    @Test
    void contextLoads() throws InterruptedException
    {
        for (int i = 0; i < 1000; i++)
        {
            Thread.sleep(1000);
            pushService.push();
        }
    }
}
