package com.lsm1998.im.tenant.internal.base.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsm1998.im.tenant.internal.base.dao.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu>
{
    @Select("select * from menu order by level,sort DESC")
    List<Menu> menuListOrderLevelAndSort();
}
