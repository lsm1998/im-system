package com.lsm1998.im.imadmin.internal.accessToken.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsm1998.im.imadmin.internal.accessToken.dao.AccessToken;

public interface AccessTokenService
{
    int saveAccessToken(AccessToken accessToken);

    int deleteAccessToken(Long id);

    Page<AccessToken> list(AccessToken find);
}
