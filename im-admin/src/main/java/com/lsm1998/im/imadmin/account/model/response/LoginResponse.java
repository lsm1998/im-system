package com.lsm1998.im.imadmin.account.model.response;

import com.lsm1998.im.imadmin.account.dao.AccountEntity;
import lombok.Data;

@Data
public class LoginResponse
{
    private AccountEntity account;

    private String token;

    private Long expire;
}
