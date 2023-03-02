package com.lsm1998.im.tenant.internal.account.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsm1998.im.tenant.internal.account.dao.TenantAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TenantAccountMapper extends BaseMapper<TenantAccount>
{
    @Select("select * from tenant_account where appid=#{appid} AND username=#{username}")
    TenantAccount findByUsername(@Param("appid") String appid, @Param("username") String username);
}
