package com.lsm1998.im.imadmin.internal.role.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsm1998.im.imadmin.internal.role.dao.RoleAuthority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleAuthorityMapper extends BaseMapper<RoleAuthority>
{
    @Select("SELECT * FROM role_authority ra INNER JOIN role r ON ra.role_id = r.id WHERE r.id IN (#{roleIds})")
    List<RoleAuthority> findAllByRoles(List<Long> roleIds);

    @Select("SELECT 1 FROM role_authority ra INNER JOIN role r ON ra.role_id = r.id WHERE r.id IN (#{roleIds}) AND ra.authority_key = #{authorityKey} LIMIT 1")
    Integer hasAuthority(@Param("authorityKey") String authorityKey, @Param("roleIds") List<Long> roleIds);
}
