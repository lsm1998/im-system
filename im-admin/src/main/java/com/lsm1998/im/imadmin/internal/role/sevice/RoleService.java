package com.lsm1998.im.imadmin.internal.role.sevice;

import com.lsm1998.im.imadmin.internal.role.dao.Role;

import java.util.List;

public interface RoleService
{
    void createBaseRole(Long tenantId);

    void createUseRole(Role role);

    // List<RoleData> scanRole();
}
