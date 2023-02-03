package com.lsm1998.im.imadmin.account.service;

import com.lsm1998.im.imadmin.account.model.request.LoginRequest;
import com.lsm1998.im.imadmin.account.model.response.LoginResponse;

public interface AccountService
{
    LoginResponse login(LoginRequest loginData);
}
