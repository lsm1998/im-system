package com.lsm1998.im.tenant.internal.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsm1998.im.tenant.internal.base.dao.Menu;
import com.lsm1998.im.tenant.internal.base.dao.mapper.MenuMapper;
import com.lsm1998.im.tenant.internal.base.dto.response.MenuData;
import com.lsm1998.im.tenant.internal.base.service.MenuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService
{
    @Resource
    private MenuMapper menuMapper;

    private List<MenuData> buildTree(List<Menu> menus)
    {
        List<MenuData> dataList = menus.stream().filter(menu -> menu.getPid() == 0).map(MenuData::new).toList();
        Map<Long, MenuData> menuDataMap = dataList.stream().
                filter(menu -> menu.getPid() > 0).
                collect(Collectors.toMap(MenuData::getId, menuData -> menuData));
        menus.forEach(menu ->
        {
            if (menu.getPid() == 0)
            {
                return;
            }
            MenuData data = menuDataMap.get(menu.getPid());
            if (data == null)
            {
                return;
            }
            data.getChildren().add(new MenuData(menu));
        });
        return null;
    }

    @Override
    public List<MenuData> menuTreeList()
    {
        List<Menu> menus = menuMapper.menuListOrderLevelAndSort();
        return this.buildTree(menus);
    }
}
