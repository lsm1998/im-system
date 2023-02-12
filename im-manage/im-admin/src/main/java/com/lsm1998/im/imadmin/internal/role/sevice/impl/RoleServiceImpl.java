package com.lsm1998.im.imadmin.internal.role.sevice.impl;

import com.lsm1998.im.common.annotations.AccessPermission;
import com.lsm1998.im.common.enums.RoleType;
import com.lsm1998.im.imadmin.internal.role.dao.Role;
import com.lsm1998.im.imadmin.internal.role.dao.mapper.RoleMapper;
import com.lsm1998.im.imadmin.internal.role.dto.response.AuthorityScanData;
import com.lsm1998.im.imadmin.internal.role.sevice.RoleService;
import com.lsm1998.im.imadmin.utils.AnnotatedClassFinder;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService
{
    @Resource
    private RoleMapper roleMapper;

    public static final String BASE_ADMIN_ROLE_NAME = "管理员";
    public static final String BASE_ADMIN_ROLE_KEY = "role:system:admin";

    public static final String BASE_READONLY_ROLE_NAME = "基础用户";
    public static final String BASE_READONLY_ROLE_KEY = "role:system:readonly";

    @Transactional
    @Override
    public void createBaseRole(Long tenantId)
    {
        // 超管
        Role admin = new Role();
        admin.setSort(10);
        admin.setType(RoleType.BaseRole);
        admin.setTenantId(tenantId);
        admin.setRoleKey(BASE_ADMIN_ROLE_KEY);
        admin.setRoleName(BASE_ADMIN_ROLE_NAME);
        roleMapper.insert(admin);

        // 基础用户
        Role readonly = new Role();
        readonly.setSort(1);
        readonly.setType(RoleType.BaseRole);
        readonly.setTenantId(tenantId);
        readonly.setRoleKey(BASE_READONLY_ROLE_KEY);
        readonly.setRoleName(BASE_READONLY_ROLE_NAME);
        roleMapper.insert(readonly);
    }

    @Override
    public void createUseRole(Role role)
    {
        role.setType(RoleType.UseRole);
        roleMapper.insert(role);
    }

    @Override
    public List<AuthorityScanData> authorityAll()
    {
        List<AuthorityScanData> result = new ArrayList<>();
        try
        {
            List<Class<?>> classes = AnnotatedClassFinder.findClasses("com.lsm1998.im.imadmin", RestController.class, Contract.class);
            classes.forEach(c ->
                    {
                        for (Method method : c.getDeclaredMethods())
                        {
                            AccessPermission accessPermission = method.getDeclaredAnnotation(AccessPermission.class);
                            if (accessPermission == null)
                            {
                                continue;
                            }
                            result.add(AuthorityScanData.builder().authorityKey(accessPermission.value()).build());
                        }
                    }
            );
        } catch (Exception e)
        {
            log.error("扫描权限失败 err={}", e.getMessage());
            throw new RuntimeException("扫描权限失败");
        }
        return result;
    }
}
