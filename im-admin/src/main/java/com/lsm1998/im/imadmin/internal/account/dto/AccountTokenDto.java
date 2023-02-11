package com.lsm1998.im.imadmin.internal.account.dto;

import com.lsm1998.im.imadmin.internal.account.dao.Account;
import com.lsm1998.im.imadmin.internal.role.dao.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountTokenDto extends Account
{
    private Account account;

    private List<Role> roles;
}
