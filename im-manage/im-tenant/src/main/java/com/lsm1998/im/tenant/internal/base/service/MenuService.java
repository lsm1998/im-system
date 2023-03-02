package com.lsm1998.im.tenant.internal.base.service;

import com.lsm1998.im.tenant.internal.base.dto.response.MenuData;

import java.util.List;

public interface MenuService
{
    List<MenuData> menuTreeList();
}
