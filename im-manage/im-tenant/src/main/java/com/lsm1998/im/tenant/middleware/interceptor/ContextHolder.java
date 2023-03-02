package com.lsm1998.im.tenant.middleware.interceptor;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ContextHolder
{
    private String remoteIp;

    private Long userId;
}
