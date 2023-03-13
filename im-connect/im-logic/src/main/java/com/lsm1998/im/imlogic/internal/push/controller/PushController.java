package com.lsm1998.im.imlogic.internal.push.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.imlogic.internal.push.dto.request.BroadcastRequest;
import com.lsm1998.im.imlogic.internal.push.dto.request.PushGroupRequest;
import com.lsm1998.im.imlogic.internal.push.dto.request.PushRequest;
import com.lsm1998.im.imlogic.internal.push.service.PushService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("im")
public class PushController
{
    @Resource
    private PushService pushService;

    @PostMapping("push")
    public AjaxResponse push(@RequestBody PushRequest request)
    {
        pushService.push(request);
        return AjaxResponse.success("ok");
    }

    @PostMapping("broadcast")
    public AjaxResponse broadcast(@RequestBody BroadcastRequest request)
    {
        pushService.broadcast(request);
        return AjaxResponse.success("ok");
    }

    @PostMapping("pushGroup")
    public AjaxResponse pushGroup(@RequestBody PushGroupRequest request)
    {
        pushService.pushGroup(request);
        return AjaxResponse.success("ok");
    }
}
