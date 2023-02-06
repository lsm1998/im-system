package com.lsm1998.im.imadmin.internal.account.service;

import com.lsm1998.im.imadmin.internal.account.dao.AccountEntity;
import com.lsm1998.im.imadmin.internal.account.model.request.AccountCreateRequest;
import com.lsm1998.im.imadmin.internal.account.model.request.LoginOutRequest;
import com.lsm1998.im.imadmin.internal.account.model.request.LoginRequest;
import com.lsm1998.im.imadmin.internal.account.model.response.AccountCreateResponse;
import com.lsm1998.im.imadmin.internal.account.model.response.LoginResponse;

public interface AccountService
{
    LoginResponse login(LoginRequest request);

    void loginOut(LoginOutRequest loginOutRequest);

    AccountEntity getAccount(String token);

    AccountCreateResponse create(AccountCreateRequest request);

    void createBaseAccount(Long tenantId);
}
