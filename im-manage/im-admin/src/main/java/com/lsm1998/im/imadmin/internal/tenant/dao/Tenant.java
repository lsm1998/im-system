package com.lsm1998.im.imadmin.internal.tenant.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("tenant")
public class Tenant extends BaseModel
{
    private String appid;
}
