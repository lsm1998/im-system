package com.lsm1998.im.imlogic.middleware.interceptor;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ContextHolder
{
    private String remoteIp;

    private Long userId;

    private String appid;
}
