package com.lsm1998.im.imadmin.internal.accessToken.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsm1998.im.imadmin.internal.accessToken.dao.AccessRole;
import com.lsm1998.im.imadmin.internal.accessToken.dao.AccessToken;
import com.lsm1998.im.imadmin.internal.accessToken.dao.mapper.AccessRoleMapper;
import com.lsm1998.im.imadmin.internal.accessToken.dao.mapper.AccessTokenMapper;
import com.lsm1998.im.imadmin.internal.accessToken.dto.request.AccessTokenCreateReq;
import com.lsm1998.im.imadmin.internal.accessToken.dto.request.AccessTokenListReq;
import com.lsm1998.im.imadmin.internal.accessToken.dto.request.AccessTokenUpdateReq;
import com.lsm1998.im.imadmin.internal.accessToken.dto.response.AccessTokenData;
import com.lsm1998.im.imadmin.internal.accessToken.service.AccessTokenService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AccessTokenServiceImpl implements AccessTokenService
{
    @Resource
    private AccessTokenMapper accessTokenMapper;

    @Resource
    private AccessRoleMapper accessRoleMapper;

    @Override
    public int saveAccessToken(AccessTokenCreateReq request)
    {
        AccessToken token = new AccessToken();
        token.setAppid(request.getAppId());
        token.setAccessKey(request.getAccessKey());
        token.setSecretKey(request.getSecretKey());
        int result = accessTokenMapper.insert(token);
        request.getRoles().forEach(e ->
        {
            AccessRole accessRole = new AccessRole();
            accessRole.setAccessTokenId(token.getId());
            accessRole.setRoleId(e.getRoleId());
            accessRoleMapper.insert(accessRole);
        });
        return result;
    }

    @Override
    public int deleteAccessToken(Long id)
    {
        return accessTokenMapper.deleteById(id);
    }

    @Override
    public int updateAccessToken(AccessTokenUpdateReq request)
    {
        QueryWrapper<AccessRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("access_token_id", request.getId());
        accessRoleMapper.delete(queryWrapper);
        request.getRoles().forEach(e ->
        {
            AccessRole accessRole = new AccessRole();
            accessRole.setAccessTokenId(request.getId());
            accessRole.setRoleId(e.getRoleId());
            accessRoleMapper.insert(accessRole);
        });
        return 1;
    }

    @Override
    public Page<AccessTokenData> list(AccessTokenListReq request)
    {
        QueryWrapper<AccessToken> wrapper = new QueryWrapper<>();
        wrapper.eq("app_id", request.getAppid());
        Page<AccessToken> page = accessTokenMapper.selectPage(request.pageInfo(), wrapper);
        Page<AccessTokenData> result = new Page<>();
        result.setTotal(page.getTotal());
        page.getRecords().forEach(e ->
        {
            AccessTokenData data = new AccessTokenData();
            data.setId(e.getId());
            data.setAppid(e.getAppid());
            data.setAccessKey(e.getAccessKey());
            data.setSecretKey(e.getSecretKey());
            data.setRoles(accessRoleMapper.selectRoleByAccessTokenId(e.getId()));
            result.getRecords().add(data);
        });
        return result;
    }
}
