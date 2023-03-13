package com.lsm1998.im.imlogic.internal.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lsm1998.im.common.exception.ServiceException;
import com.lsm1998.im.common.utils.JwtUtil;
import com.lsm1998.im.imlogic.internal.user.dao.AccessToken;
import com.lsm1998.im.imlogic.internal.user.dao.mapper.AccessTokenMapper;
import com.lsm1998.im.imlogic.internal.user.dto.request.CreateAccessTokenRequest;
import com.lsm1998.im.imlogic.internal.user.dto.response.CreateAccessTokenResponse;
import com.lsm1998.im.imlogic.internal.user.service.UserService;
import com.lsm1998.im.imlogic.utils.SignatureUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import static com.lsm1998.im.common.Code.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService
{
    private static final int CREATE_EXPIRE = 1000 * 10;

    private static final String USER_SERVER_NODE_PREFIX = "user:node:";

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private AccessTokenMapper accessTokenMapper;

    private boolean checkSignature(CreateAccessTokenRequest tokenRequest)
    {
        // 根据accessKey获取secretKey
        QueryWrapper<AccessToken> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("access_key", tokenRequest.getAccessKey());
        AccessToken accessToken = accessTokenMapper.selectOne(queryWrapper);
        if (accessToken == null)
        {
            throw new ServiceException(ACCESS_KEY_NOT_EXIST_CODE, ACCESS_KEY_NOT_EXIST_MESSAGE);
        }
        String signature = SignatureUtil.signature(tokenRequest.getCreateTime(), accessToken.getSecretKey(), tokenRequest.getBody());
        return tokenRequest.getSignature().equals(signature);
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

    @Override
    public void handshake(String appid, String token, String nodeId)
    {
        JwtUtil.ClaimsParse claimsParse = JwtUtil.parseToken(secretKey, token);
        if (!claimsParse.isVerify() && !claimsParse.isExpire())
        {
            log.error("token校验失败，token={}，appid={}，nodeId={}", token, appid, nodeId);
            return;
        }
        Claims claims = claimsParse.getClaims();
        redisTemplate.opsForValue().set(USER_SERVER_NODE_PREFIX +
                claims.get("mid", String.class), nodeId);
    }
}
