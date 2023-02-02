package com.lsm1998.im.imadmin.account.model.request;

import lombok.Data;

@Data
public class AccountLogin
{
    private String username;

    private String password;

    private String captchaId;

    private String captcha;
}
