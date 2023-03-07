package com.lsm1998.im.tenant.internal.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsm1998.im.tenant.internal.base.dao.Menu;
import com.lsm1998.im.tenant.internal.base.dto.response.MenuData;

import java.util.List;

public interface MenuService extends IService<Menu>
{
    List<MenuData> menuTreeList();
}
