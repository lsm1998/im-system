package com.lsm1998.im.imadmin.internal.tenant.service;

import com.lsm1998.im.common.exception.ServiceException;

public interface TenantService
{
    String generateAppid(String appid) throws ServiceException;

    int delete(Long id);
}
