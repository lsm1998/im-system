package com.lsm1998.im.imadmin.interceptor;

import com.lsm1998.im.imadmin.internal.account.dao.Account;
import com.lsm1998.im.imadmin.internal.role.dao.Role;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ContextHolder
{
    private String remoteIp;

    private Account account;

    private List<Role> roles;
}
