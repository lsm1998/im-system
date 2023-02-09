package com.lsm1998.im.imadmin.internal.accessToken.dto.request;

import com.lsm1998.im.imadmin.internal.accessToken.dao.AccessRole;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class AccessTokenCreateReq
{
    @NotEmpty(message = "appid不得为空")
    private String appId;

    @NotEmpty(message = "accessKey不得为空")
    private String accessKey;

    @NotEmpty(message = "secretKey不得为空")
    private String secretKey;

    private List<AccessRole> roles;
}
