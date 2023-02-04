package com.lsm1998.im.imadmin.internal.accessToken.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsm1998.im.imadmin.internal.accessToken.dao.AccessTokenEntity;
import com.lsm1998.im.imadmin.internal.accessToken.dao.mapper.AccessTokenMapper;
import com.lsm1998.im.imadmin.internal.accessToken.service.AccessTokenService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenServiceImpl implements AccessTokenService
{
    @Resource
    private AccessTokenMapper accessTokenMapper;

    @Override
    public int saveAccessToken(AccessTokenEntity accessToken)
    {
        return accessTokenMapper.insert(accessToken);
    }

    @Override
    public int deleteAccessToken(Long id)
    {
        return accessTokenMapper.deleteById(id);
    }

    @Override
    public Page<AccessTokenEntity> list(AccessTokenEntity find)
    {
        return null;
    }
}
