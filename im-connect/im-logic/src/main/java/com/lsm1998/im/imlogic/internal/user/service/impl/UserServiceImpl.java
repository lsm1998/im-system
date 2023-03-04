package com.lsm1998.im.imlogic.internal.user.service.impl;

import com.lsm1998.im.common.exception.ServiceException;
import com.lsm1998.im.imlogic.internal.user.dto.request.CreateAccessTokenRequest;
import com.lsm1998.im.imlogic.internal.user.dto.response.CreateAccessTokenResponse;
import com.lsm1998.im.imlogic.internal.user.service.UserService;
import org.springframework.stereotype.Service;

import static com.lsm1998.im.common.Code.*;

@Service
public class UserServiceImpl implements UserService
{
    private static final int CREATE_EXPIRE = 1000 * 10;

    private boolean checkSignature(CreateAccessTokenRequest tokenRequest)
    {
        return true;
    }

    @Override
    public CreateAccessTokenResponse createAccessToken(CreateAccessTokenRequest tokenRequest)
    {
        // 检查请求是否过期
        if (tokenRequest.getCreateTime() + CREATE_EXPIRE < System.currentTimeMillis())
        {
            throw new ServiceException(ACCESS_TOKEN_CREATE_EXPIRE_CODE, ACCESS_TOKEN_CREATE_EXPIRE_MESSAGE);
        }
        // 检查签名是否正确
        if (!checkSignature(tokenRequest))
        {
            throw new ServiceException(SIGNATURE_ERROR_CODE, SIGNATURE_ERROR_MESSAGE);
        }
        return null;
    }
}
