package com.lsm1998.im.imadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({com.lsm1998.im.webcommon.exception.GlobalExceptionHandler.class})
public class ImAdminApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ImAdminApplication.class, args);
    }
}
