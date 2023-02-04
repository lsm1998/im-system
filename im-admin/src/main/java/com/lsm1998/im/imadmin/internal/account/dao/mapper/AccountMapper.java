package com.lsm1998.im.imadmin.internal.account.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsm1998.im.imadmin.internal.account.dao.AccountEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<AccountEntity>
{
    default AccountEntity findAllByUsername(String username)
    {
        QueryWrapper<AccountEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("deleted_at", 0);
        return this.selectOne(wrapper);
    }
}
