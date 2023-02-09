package com.lsm1998.im.imadmin.internal.account.model.request;

import lombok.Data;

@Data
public class LoginRequest
{
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private String loginIp;

    /**
     * 验证码ID
     */
    private String captchaId;

    /**
     * 验证码
     */
    private String captcha;
}
