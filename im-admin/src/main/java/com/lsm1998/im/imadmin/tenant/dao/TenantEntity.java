package com.lsm1998.im.imadmin.tenant.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("admin_tenant")
public class TenantEntity extends BaseModel
{
    private String appId;

    private Long balance;

    private Date expire;

    private Long maxTeamSize;

    private Long currentTeamSize;
}
