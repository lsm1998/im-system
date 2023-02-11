package com.lsm1998.im.imadmin.internal.role.sevice;

import com.lsm1998.im.imadmin.internal.role.dao.Role;

public interface RoleService
{
    void createBaseRole(Long tenantId);

    void createUseRole(Role role);
}
