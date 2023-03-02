package com.lsm1998.im.tenant.internal.account.dto.response;

import com.lsm1998.im.tenant.internal.account.dao.TenantAccount;
import lombok.Data;

@Data
public class LoginResponse
{
    private String token;

    private String refreshToken;

    private TenantAccount userInfo;

    private Long expire;
}
