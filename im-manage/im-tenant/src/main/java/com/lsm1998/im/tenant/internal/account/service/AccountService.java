package com.lsm1998.im.tenant.internal.account.service;

import com.lsm1998.im.tenant.internal.account.dto.request.LoginRequest;
import com.lsm1998.im.tenant.internal.account.dto.response.LoginResponse;
import com.lsm1998.im.tenant.internal.account.dto.response.ProfileResponse;

public interface AccountService
{
    LoginResponse login(LoginRequest request);

    ProfileResponse profile(Long userId);
}
