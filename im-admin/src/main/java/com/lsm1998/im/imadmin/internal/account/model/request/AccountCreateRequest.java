package com.lsm1998.im.imadmin.internal.account.model.request;

import com.lsm1998.im.imadmin.internal.account.dao.AccountEntity;
import com.lsm1998.im.imadmin.internal.role.dao.RoleEntity;
import lombok.Data;

import java.util.List;

@Data
public class AccountCreateRequest
{
    private AccountEntity account;

    private List<RoleEntity> roles;
}
