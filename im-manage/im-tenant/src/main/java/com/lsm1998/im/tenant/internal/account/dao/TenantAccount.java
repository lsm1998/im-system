package com.lsm1998.im.tenant.internal.account.dao;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.enums.GenderType;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@TableName("tenant_account")
@Data
public class TenantAccount extends BaseModel
{
    private String username;

    private String password;

    private String nickname;

    private String email;

    private String mobile;

    private String avatar;

    private String salt;

    @EnumValue
    private GenderType genderType;

    private String birthday;

    private String money;

    private Integer integral;

    private Date lastLoginTime;

    private String lastLoginIp;

    private String motto;
}
