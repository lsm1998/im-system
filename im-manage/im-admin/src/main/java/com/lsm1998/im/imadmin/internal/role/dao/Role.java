package com.lsm1998.im.imadmin.internal.role.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.enums.RoleType;
import com.lsm1998.im.webcommon.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("role")
public class Role extends BaseModel
{
    private Long tenantId;

    private RoleType type;

    private String roleName;

    private String roleKey;

    private Integer sort;
}
