package com.lsm1998.im.imadmin.internal.account.model.request;

import com.lsm1998.im.imadmin.internal.account.dao.AccountEntity;
import com.lsm1998.im.imadmin.internal.role.dao.RoleEntity;
import lombok.Data;

import java.util.List;

@Data
public class AccountCreateRequest
{
    /**
     * account账户
     */
    private AccountEntity account;

    /**
     * 权限
     */
    private List<RoleEntity> roles;
}
