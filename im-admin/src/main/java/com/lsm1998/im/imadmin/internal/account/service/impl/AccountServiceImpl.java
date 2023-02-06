package com.lsm1998.im.imadmin.internal.account.service.impl;

import com.lsm1998.im.common.exception.ServiceException;
import com.lsm1998.im.imadmin.internal.account.dao.AccountEntity;
import com.lsm1998.im.imadmin.internal.account.dao.mapper.AccountMapper;
import com.lsm1998.im.imadmin.internal.account.model.dto.AccountTokenDto;
import com.lsm1998.im.imadmin.internal.account.model.request.AccountCreateRequest;
import com.lsm1998.im.imadmin.internal.account.model.request.LoginOutRequest;
import com.lsm1998.im.imadmin.internal.account.model.request.LoginRequest;
import com.lsm1998.im.imadmin.internal.account.model.response.AccountCreateResponse;
import com.lsm1998.im.imadmin.internal.account.model.response.LoginResponse;
import com.lsm1998.im.imadmin.internal.account.service.AccountService;
import com.lsm1998.im.imadmin.utils.JwtUtil;
import com.lsm1998.im.imadmin.utils.PasswordEncrypt;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;

import static com.lsm1998.im.common.Code.*;

@Service
public class AccountServiceImpl implements AccountService
{
    private static final String REDIS_TOKEN_KEY = "account:token:";

    private static final Duration DEFAULT_EXPIRE_TIME = Duration.ofHours(24);

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("#{${jwt.expire}}")
    private Long expire;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private RedisTemplate<String, AccountTokenDto> redisTemplate;

    @Override
    public LoginResponse login(LoginRequest request)
    {
        AccountEntity account = accountMapper.findAllByUsername(request.getUsername());
        if (account == null)
        {
            throw new ServiceException(USER_NOT_EXIST_ERROR_CODE, USER_NOT_EXIST_ERROR_MESSAGE);
        }
        if (!PasswordEncrypt.equals(request.getPassword(), account.getPassword(), account.getSalt()))
        {
            throw new ServiceException(LOGIN_ERROR_CODE, LOGIN_ERROR_MESSAGE);
        }
        String token = JwtUtil.createToken(secretKey, expire, Map.of("userId", account.getId()));
        redisTemplate.opsForValue().set(String.format("%s%s", REDIS_TOKEN_KEY, token), new AccountTokenDto(), DEFAULT_EXPIRE_TIME);
        return LoginResponse.of(account , token , System.currentTimeMillis() + expire);
    }

    @Override
    public void loginOut(LoginOutRequest loginOutRequest)
    {
        redisTemplate.delete(loginOutRequest.getToken());
    }

    @Override
    public AccountEntity getAccount(String token)
    {
        return redisTemplate.opsForValue()
                .get(String.format("%s%s", REDIS_TOKEN_KEY, token));
    }

    @Override
    public AccountCreateResponse create(AccountCreateRequest request)
    {
        return null;
    }

    @Override
    public void createBaseAccount(Long tenantId)
    {

    }
}
