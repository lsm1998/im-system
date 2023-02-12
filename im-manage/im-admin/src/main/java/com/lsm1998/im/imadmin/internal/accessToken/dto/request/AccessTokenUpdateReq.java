package com.lsm1998.im.imadmin.internal.accessToken.dto.request;

import com.lsm1998.im.imadmin.internal.accessToken.dao.AccessRole;
import lombok.Data;

import java.util.List;

@Data
public class AccessTokenUpdateReq
{
    private Long id;

    private List<AccessRole> roles;
}
