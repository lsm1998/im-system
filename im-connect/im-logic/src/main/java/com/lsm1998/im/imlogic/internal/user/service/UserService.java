package com.lsm1998.im.imlogic.internal.user.service;

import com.lsm1998.im.imlogic.internal.user.dto.request.CreateAccessTokenRequest;
import com.lsm1998.im.imlogic.internal.user.dto.response.CreateAccessTokenResponse;

public interface UserService
{
    CreateAccessTokenResponse createAccessToken(CreateAccessTokenRequest tokenRequest);

    void handshake(String appid, String token, String nodeId);
}
