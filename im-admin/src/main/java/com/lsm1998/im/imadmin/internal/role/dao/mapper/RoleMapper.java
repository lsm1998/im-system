package com.lsm1998.im.imadmin.internal.role.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsm1998.im.imadmin.internal.role.dao.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role>
{
    @Select("select r.* from role r,role_account ar where r.id=ar.role_id and ar.account_id=#{id}")
    List<Role> findAllByAccountId(Long id);
}
