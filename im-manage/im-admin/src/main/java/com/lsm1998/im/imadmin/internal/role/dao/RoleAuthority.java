package com.lsm1998.im.imadmin.internal.role.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("role_authority")
public class RoleAuthority extends BaseModel
{
    private Long roleId;

    private String authorityKey;
}
