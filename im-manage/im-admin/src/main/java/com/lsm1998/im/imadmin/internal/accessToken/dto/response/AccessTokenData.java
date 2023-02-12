package com.lsm1998.im.imadmin.internal.accessToken.dto.response;

import com.lsm1998.im.imadmin.internal.accessToken.dao.AccessRole;
import com.lsm1998.im.imadmin.internal.accessToken.dao.AccessToken;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccessTokenData extends AccessToken
{
    private List<AccessRole> roles;
}
