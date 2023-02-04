package com.lsm1998.im.imadmin.internal.tenant.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("tenant")
public class TenantEntity extends BaseModel
{
    private String appid;
}
