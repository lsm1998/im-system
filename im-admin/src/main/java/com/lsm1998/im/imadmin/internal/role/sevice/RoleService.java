package com.lsm1998.im.imadmin.internal.role.sevice;

import com.lsm1998.im.imadmin.internal.role.dao.RoleEntity;

public interface RoleService
{
    void createBaseRole(Long tenantId);

    void createUseRole(RoleEntity role);
}
