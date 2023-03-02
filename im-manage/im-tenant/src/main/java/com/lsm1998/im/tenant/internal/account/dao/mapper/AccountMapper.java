package com.lsm1998.im.tenant.internal.account.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsm1998.im.tenant.internal.account.dao.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper extends BaseMapper<Account>
{
    @Select("select * from tenant_account where appid=#{appid} AND username=#{username}")
    Account findByUsername(@Param("appid") String appid, @Param("username") String username);
}
