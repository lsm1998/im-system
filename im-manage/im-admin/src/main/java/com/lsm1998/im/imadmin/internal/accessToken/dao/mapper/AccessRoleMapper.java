package com.lsm1998.im.imadmin.internal.accessToken.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsm1998.im.imadmin.internal.accessToken.dao.AccessRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccessRoleMapper extends BaseMapper<AccessRole>
{
    @Select("select * from access_role where access_token_id=#{id}")
    List<AccessRole> selectRoleByAccessTokenId(Long id);
}
