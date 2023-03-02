package com.lsm1998.im.tenant.internal.account.service;

import com.lsm1998.im.tenant.internal.account.dto.request.LoginRequest;
import com.lsm1998.im.tenant.internal.account.dto.response.LoginResponse;

public interface TenantAccountService
{
    LoginResponse login(LoginRequest request);
}
