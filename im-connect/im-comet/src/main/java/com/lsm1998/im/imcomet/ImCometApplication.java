package com.lsm1998.im.imcomet;

import com.lsm1998.im.imcomet.context.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SpringContextUtil.class})
public class ImCometApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ImCometApplication.class, args);
    }
}
