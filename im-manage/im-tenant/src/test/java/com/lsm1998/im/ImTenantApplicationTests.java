package com.lsm1998.im;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.lsm1998.im.tenant.ImTenantApplication;
import com.lsm1998.im.tenant.internal.base.dao.Menu;
import com.lsm1998.im.tenant.internal.base.dao.mapper.MenuMapper;
import com.lsm1998.im.tenant.internal.base.service.MenuService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ImTenantApplication.class)
public class ImTenantApplicationTests
{
    @Resource
    private MenuService menuService;

    @Test
    public void initMenuData()
    {
        List<Menu> menus = new ArrayList<>();
        Menu menu1 = new Menu();
        menu1.setId(3L);
        menu1.setPid(0L);
        menu1.setType("menu");
        menu1.setTitle("账户概览");
        menu1.setName("account/overview");
        menu1.setPath("account/overview");
        menu1.setIcon("fa fa-home");
        menu1.setMenuType("tab");
        menu1.setUrl("");
        menu1.setComponent("/src/views/frontend/user/account/overview.vue");
        menu1.setExtend("none");
        menu1.setLevel(1);
        menus.add(menu1);

        Menu menu2 = new Menu();
        menu2.setId(4L);
        menu2.setPid(0L);
        menu2.setType("menu");
        menu2.setTitle("个人资料");
        menu2.setName("account/profile");
        menu2.setPath("account/profile");
        menu2.setIcon("fa fa-user-circle-o");
        menu2.setMenuType("tab");
        menu2.setUrl("");
        menu2.setComponent("/src/views/frontend/user/account/profile.vue");
        menu2.setExtend("none");
        menu2.setLevel(1);
        menus.add(menu2);

        Menu menu3 = new Menu();
        menu3.setId(5L);
        menu3.setPid(0L);
        menu3.setType("menu");
        menu3.setTitle("修改密码");
        menu3.setName("account/changePassword");
        menu3.setPath("account/changePassword");
        menu3.setIcon("fa fa-shield");
        menu3.setMenuType("tab");
        menu3.setUrl("");
        menu3.setComponent("/src/views/frontend/user/account/changePassword.vue");
        menu3.setExtend("none");
        menu3.setLevel(1);
        menus.add(menu3);

        Menu menu4 = new Menu();
        menu4.setId(6L);
        menu4.setPid(0L);
        menu4.setType("menu");
        menu4.setTitle("积分记录");
        menu4.setName("account/integral");
        menu4.setPath("account/integral");
        menu4.setIcon("fa fa-tag");
        menu4.setMenuType("tab");
        menu4.setUrl("");
        menu4.setComponent("/src/views/frontend/user/account/integral.vue");
        menu4.setExtend("none");
        menu4.setLevel(1);
        menus.add(menu4);

        Menu menu5 = new Menu();
        menu5.setId(7L);
        menu5.setPid(0L);
        menu5.setType("menu");
        menu5.setTitle("余额记录");
        menu5.setName("account/balance");
        menu5.setPath("account/balance");
        menu5.setIcon("fa fa-money");
        menu5.setMenuType("tab");
        menu5.setUrl("");
        menu5.setComponent("/src/views/frontend/user/account/balance.vue");
        menu5.setExtend("none");
        menu5.setLevel(1);
        menus.add(menu5);

        menuService.saveBatch(menus);
    }
}
