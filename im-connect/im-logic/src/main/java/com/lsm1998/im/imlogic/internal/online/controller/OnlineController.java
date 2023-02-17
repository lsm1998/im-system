package com.lsm1998.im.imlogic.internal.online.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.imlogic.middleware.redis.OnlineRedisFacade;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在线服务
 */
@RestController
@RequestMapping("im/online")
public class OnlineController
{
    @Resource
    private OnlineRedisFacade onlineRedisFacade;

    @GetMapping("count")
    public AjaxResponse onlineCount()
    {
        return AjaxResponse.success(onlineRedisFacade.getOnlineCount());
    }
}
