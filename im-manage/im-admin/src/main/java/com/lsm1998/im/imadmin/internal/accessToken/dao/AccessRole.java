package com.lsm1998.im.imadmin.internal.accessToken.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.webcommon.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("access_role")
public class AccessRole extends BaseModel
{
    private Long accessTokenId;

    private Long roleId;
}
