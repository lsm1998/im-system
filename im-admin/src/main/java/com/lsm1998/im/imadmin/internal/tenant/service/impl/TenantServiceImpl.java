package com.lsm1998.im.imadmin.internal.tenant.service.impl;

import com.lsm1998.im.common.exception.ServiceException;
import com.lsm1998.im.imadmin.internal.tenant.dao.TenantEntity;
import com.lsm1998.im.imadmin.internal.tenant.dao.mapper.TenantMapper;
import com.lsm1998.im.imadmin.internal.tenant.service.TenantService;
import com.lsm1998.im.imadmin.middleware.rabbitmq.RabbitPublish;
import com.lsm1998.im.imadmin.utils.StringUtil;
import jakarta.annotation.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.lsm1998.im.common.Code.APPID_INSERT_ERROR_CODE;
import static com.lsm1998.im.common.Code.APPID_INSERT_ERROR_MESSAGE;

@Service
public class TenantServiceImpl implements TenantService
{
    private static final char[] appidSeed = new char[62];

    private static final int appidLength = 8;

    static
    {
        int index = 0;
        for (int i = '0'; i <= '9'; i++)
        {
            appidSeed[index++] = (char) i;
        }
        for (int i = 'A'; i <= 'Z'; i++)
        {
            appidSeed[index++] = (char) i;
        }
        for (int i = 'a'; i <= 'z'; i++)
        {
            appidSeed[index++] = (char) i;
        }
    }

    @Resource
    private TenantMapper tenantMapper;

    @Resource
    private RabbitPublish publish;

    @Transactional
    protected String generateWithFixed(String appid) throws ServiceException
    {
        TenantEntity tenant = new TenantEntity();
        tenant.setAppid(appid);
        try
        {
            tenantMapper.insert(tenant);
            publish.publish("tenant_create", tenant);
        } catch (DuplicateKeyException e)
        {
            throw new ServiceException(APPID_INSERT_ERROR_CODE, APPID_INSERT_ERROR_MESSAGE);
        }
        return tenant.getAppid();
    }

    @Transactional
    @Override
    public String generateAppid(String appid) throws ServiceException
    {
        if (appid != null)
        {
            return this.generateWithFixed(appid);
        }
        TenantEntity tenant = new TenantEntity();
        for (int i = 0; i < 5; i++)
        {
            tenant.setAppid(StringUtil.randomStr(appidLength, appidSeed));
            try
            {
                tenantMapper.insert(tenant);
                publish.publish("tenant_create", tenant);
            } catch (DuplicateKeyException e)
            {
                continue;
            }
            return tenant.getAppid();
        }
        throw new ServiceException(APPID_INSERT_ERROR_CODE, APPID_INSERT_ERROR_MESSAGE);
    }
}
