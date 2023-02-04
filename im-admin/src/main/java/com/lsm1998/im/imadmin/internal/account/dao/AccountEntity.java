package com.lsm1998.im.imadmin.internal.account.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("account")
public class AccountEntity extends BaseModel
{
    private Long tenantId;

    private String username;

    private String password;

    private String salt;
}
