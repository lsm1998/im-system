package com.lsm1998.im.imadmin.internal.account.service;

import com.lsm1998.im.imadmin.internal.account.dao.Account;
import com.lsm1998.im.imadmin.internal.account.dto.request.AccountCreateRequest;
import com.lsm1998.im.imadmin.internal.account.dto.request.LoginOutRequest;
import com.lsm1998.im.imadmin.internal.account.dto.request.LoginRequest;
import com.lsm1998.im.imadmin.internal.account.dto.response.AccountCreateResponse;
import com.lsm1998.im.imadmin.internal.account.dto.response.LoginResponse;

public interface AccountService
{
    LoginResponse login(LoginRequest request);

    void loginOut(LoginOutRequest loginOutRequest);

    Account getAccount(String token);

    AccountCreateResponse create(AccountCreateRequest request);

    void createBaseAccount(Long tenantId);
}
