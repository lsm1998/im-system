package com.lsm1998.im.imadmin.accessToken.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("access_token")
public class AccessTokenEntity extends BaseModel
{
    private String appId;

    private String accessKey;

    private String secureKey;
}
