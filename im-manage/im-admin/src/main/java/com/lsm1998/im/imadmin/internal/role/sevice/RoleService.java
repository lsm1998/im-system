package com.lsm1998.im.imadmin.internal.role.sevice;

import com.lsm1998.im.imadmin.internal.role.dao.Role;
import com.lsm1998.im.imadmin.internal.role.dto.response.AuthorityScanData;

import java.util.List;

public interface RoleService
{
    void createBaseRole(Long tenantId);

    void createUseRole(Role role);

    List<AuthorityScanData> authorityAll();

    // List<RoleData> scanRole();
}
