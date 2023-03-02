package com.lsm1998.im.tenant.internal.account.dto.request;

import lombok.Data;

@Data
public class LoginRequest
{
    private String appid;

    private String username;

    private String password;

    private String captchaId;

    private String captchaCode;

    private String remoteIp;
}
