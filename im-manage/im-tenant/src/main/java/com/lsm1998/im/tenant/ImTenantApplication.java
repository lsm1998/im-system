package com.lsm1998.im.tenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({com.lsm1998.im.webcommon.exception.GlobalExceptionHandler.class})
public class ImTenantApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ImTenantApplication.class, args);
    }
}
