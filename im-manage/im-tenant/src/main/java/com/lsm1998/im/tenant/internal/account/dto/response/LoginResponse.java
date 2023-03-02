package com.lsm1998.im.tenant.internal.account.dto.response;

import com.lsm1998.im.tenant.internal.account.dao.Account;
import lombok.Data;

@Data
public class LoginResponse
{
    private String token;

    private String refreshToken;

    private Account userInfo;

    private Long expire;
}
