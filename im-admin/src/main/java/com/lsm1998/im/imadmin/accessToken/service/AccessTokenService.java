package com.lsm1998.im.imadmin.accessToken.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsm1998.im.imadmin.accessToken.dao.AccessTokenEntity;

public interface AccessTokenService
{
    int saveAccessToken(AccessTokenEntity accessToken);

    int deleteAccessToken(Long id);

    Page<AccessTokenEntity> list(AccessTokenEntity find);
}
