package com.lsm1998.im.imadmin.internal.account.service.impl;

import com.lsm1998.im.common.exception.ServiceException;
import com.lsm1998.im.imadmin.internal.account.dao.AccountEntity;
import com.lsm1998.im.imadmin.internal.account.dao.mapper.AccountMapper;
import com.lsm1998.im.imadmin.internal.account.model.request.LoginRequest;
import com.lsm1998.im.imadmin.internal.account.model.response.LoginResponse;
import com.lsm1998.im.imadmin.internal.account.service.AccountService;
import com.lsm1998.im.imadmin.utils.PasswordEncrypt;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import static com.lsm1998.im.common.Code.*;

@Service
public class AccountServiceImpl implements AccountService
{
    @Resource
    private AccountMapper accountMapper;

    @Override
    public LoginResponse login(LoginRequest loginData)
    {
        AccountEntity account = accountMapper.findAllByUsername(loginData.getUsername());
        if (account == null)
        {
            throw new ServiceException(USER_NOT_EXIST_ERROR_CODE, USER_NOT_EXIST_ERROR_MESSAGE);
        }
        if (!PasswordEncrypt.equals(loginData.getPassword(), account.getPassword(), account.getSalt()))
        {
            throw new ServiceException(LOGIN_ERROR_CODE, LOGIN_ERROR_MESSAGE);
        }
        return null;
    }
}
