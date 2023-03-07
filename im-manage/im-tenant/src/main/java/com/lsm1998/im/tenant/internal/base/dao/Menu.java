package com.lsm1998.im.tenant.internal.base.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@TableName("tenant_menu")
@Data
public class Menu extends BaseModel
{
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
     * 排序
     */
    private Integer sort;

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
     * 层级
     */
    private Integer level;
}
