package com.lsm1998.im.tenant.internal.base.dto.response;

import com.lsm1998.im.tenant.internal.base.dao.Menu;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuData implements Serializable
{
    private Long id;

    /**
     * 父级id
     */
    private Long pid;

    /**
     * 类型
     */
    private String type;

    /**
     * 标题
     */
    private String title;

    /**
     * 名称
     */
    private String name;

    /**
     * 路径
     */
    private String path;

    /**
     * 图标
     */
    private String icon;

    /**
     * 菜单类型
     */
    private String menuType;

    /**
     * 路由地址
     */
    private String url;

    /**
     * 组件
     */
    private String component;

    /**
     * 扩展字段
     */
    private String extend;

    /**
     * 子菜单
     */
    private List<MenuData> children;

    public MenuData()
    {
    }

    public MenuData(Menu menu)
    {
        this.pid = menu.getPid();
        this.type = menu.getType();
        this.title = menu.getTitle();
        this.name = menu.getName();
        this.path = menu.getPath();
        this.icon = menu.getIcon();
        this.menuType = menu.getMenuType();
        this.url = menu.getUrl();
        this.component = menu.getComponent();
        this.extend = menu.getExtend();
    }
}
