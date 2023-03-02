package com.lsm1998.im.tenant.internal.user.dto.response;

import com.lsm1998.im.tenant.internal.user.dao.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResponse extends User
{
    private String token;

    private String refreshToken;
}
