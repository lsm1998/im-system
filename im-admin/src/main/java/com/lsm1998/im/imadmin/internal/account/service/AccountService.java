package com.lsm1998.im.imadmin.internal.account.service;

import com.lsm1998.im.imadmin.internal.account.model.request.LoginOutRequest;
import com.lsm1998.im.imadmin.internal.account.model.request.LoginRequest;
import com.lsm1998.im.imadmin.internal.account.model.response.LoginResponse;

public interface AccountService
{
    LoginResponse login(LoginRequest loginData);

    void loginOut(LoginOutRequest loginOutRequest);
}
