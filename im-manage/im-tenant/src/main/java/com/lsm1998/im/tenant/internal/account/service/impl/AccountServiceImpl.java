package com.lsm1998.im.tenant.internal.account.service.impl;

import com.lsm1998.im.common.exception.ServiceException;
import com.lsm1998.im.common.utils.JwtUtil;
import com.lsm1998.im.common.utils.PasswordEncrypt;
import com.lsm1998.im.tenant.internal.account.dao.Account;
import com.lsm1998.im.tenant.internal.account.dao.mapper.AccountMapper;
import com.lsm1998.im.tenant.internal.account.dto.request.LoginRequest;
import com.lsm1998.im.tenant.internal.account.dto.response.LoginResponse;
import com.lsm1998.im.tenant.internal.account.dto.response.ProfileResponse;
import com.lsm1998.im.tenant.internal.account.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

import static com.lsm1998.im.common.Code.*;

@Service
public class AccountServiceImpl implements AccountService
{
    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("#{${jwt.expire}}")
    private Long expire;

    @Resource
    private AccountMapper accountMapper;

    @Override
    public LoginResponse login(LoginRequest request)
    {
        Account account = accountMapper.findByUsername(request.getAppid(), request.getUsername());
        if (account == null)
        {
            throw new ServiceException(USER_NOT_EXIST_ERROR_CODE, USER_NOT_EXIST_ERROR_MESSAGE);
        }
        if (!PasswordEncrypt.equals(request.getPassword(), account.getPassword(), account.getSalt()))
        {
            throw new ServiceException(LOGIN_ERROR_CODE, LOGIN_ERROR_MESSAGE);
        }
        account.setLastLoginIp(request.getRemoteIp());
        account.setLastLoginTime(new Date());
        accountMapper.updateById(account);
        String token = JwtUtil.createToken(secretKey, expire, Map.of(
                "userId", account.getId(), "appid", account.getAppid()));
        LoginResponse result = new LoginResponse();
        result.setUserInfo(account);
        result.setToken(token);
        result.setRefreshToken(token);
        result.setExpire(System.currentTimeMillis() + expire);
        return result;
    }

    @Override
    public ProfileResponse profile(Long userId)
    {

        return null;
    }
}
