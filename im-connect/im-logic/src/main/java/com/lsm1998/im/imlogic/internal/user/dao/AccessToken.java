package com.lsm1998.im.imlogic.internal.user.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@TableName("access_token")
@Data
public class AccessToken extends BaseModel
{
    private String appid;

    private String accessKey;

    private String secretKey;
}
