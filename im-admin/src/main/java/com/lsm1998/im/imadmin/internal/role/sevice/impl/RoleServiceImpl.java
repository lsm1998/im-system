package com.lsm1998.im.imadmin.internal.role.sevice.impl;

import com.lsm1998.im.common.enums.RoleType;
import com.lsm1998.im.imadmin.internal.role.dao.RoleEntity;
import com.lsm1998.im.imadmin.internal.role.dao.mapper.RoleMapper;
import com.lsm1998.im.imadmin.internal.role.sevice.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService
{
    @Resource
    private RoleMapper roleMapper;

    private static final String BASE_ADMIN_ROLE_NAME = "管理员";
    private static final String BASE_ADMIN_ROLE_KEY = "role:system:admin";

    private static final String BASE_READONLY_ROLE_NAME = "基础用户";
    private static final String BASE_READONLY_ROLE_KEY = "role:system:readonly";

    @Transactional
    @Override
    public void createBaseRole(Long tenantId)
    {
        // 超管
        RoleEntity admin = new RoleEntity();
        admin.setSort(10);
        admin.setType(RoleType.BaseRole);
        admin.setTenantId(tenantId);
        admin.setRoleKey(BASE_ADMIN_ROLE_KEY);
        admin.setRoleName(BASE_ADMIN_ROLE_NAME);
        roleMapper.insert(admin);

        // 基础用户
        RoleEntity readonly = new RoleEntity();
        readonly.setSort(1);
        readonly.setType(RoleType.BaseRole);
        readonly.setTenantId(tenantId);
        readonly.setRoleKey(BASE_READONLY_ROLE_KEY);
        readonly.setRoleName(BASE_READONLY_ROLE_NAME);
        roleMapper.insert(readonly);
    }

    @Override
    public void createUseRole(RoleEntity role)
    {
        role.setType(RoleType.UseRole);
        roleMapper.insert(role);
    }
}
