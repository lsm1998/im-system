package com.lsm1998.im.imadmin.internal.account.dto.request;

import com.lsm1998.im.imadmin.internal.account.dao.Account;
import com.lsm1998.im.imadmin.internal.role.dao.Role;
import lombok.Data;

import java.util.List;

@Data
public class AccountCreateRequest
{
    /**
     * account账户
     */
    private Account account;

    /**
     * 权限
     */
    private List<Role> roles;
}
