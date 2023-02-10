package com.lsm1998.im.imadmin.internal.accessToken.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsm1998.im.imadmin.internal.accessToken.dao.AccessToken;
import com.lsm1998.im.imadmin.internal.accessToken.dto.request.AccessTokenCreateReq;
import com.lsm1998.im.imadmin.internal.accessToken.dto.request.AccessTokenListReq;
import com.lsm1998.im.imadmin.internal.accessToken.dto.request.AccessTokenUpdateReq;
import com.lsm1998.im.imadmin.internal.accessToken.dto.response.AccessTokenData;

public interface AccessTokenService
{
    int saveAccessToken(AccessTokenCreateReq request);

    int deleteAccessToken(Long id);

    Page<AccessTokenData> list(AccessTokenListReq request);

    int updateAccessToken(AccessTokenUpdateReq request);
}
