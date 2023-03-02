package com.lsm1998.im.tenant.internal.user.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@TableName("t_user")
@Data
public class User extends BaseModel
{
    private String username;

    private String password;

    private String nickname;

    private String email;

    private String mobile;

    private String avatar;

    private Integer gender;

    private String birthday;

    private String money;

    private Integer score;

    private Long lastLoginTime;

    private String lastLoginIp;

    private Long joinTime;

    private String motto;
}
