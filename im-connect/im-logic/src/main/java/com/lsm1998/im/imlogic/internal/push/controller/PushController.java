package com.lsm1998.im.imlogic.internal.push.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.imlogic.internal.push.dto.request.BroadcastRequest;
import com.lsm1998.im.imlogic.internal.push.dto.request.PushGroupRequest;
import com.lsm1998.im.imlogic.internal.push.dto.request.PushRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("im/push")
public class PushController
{
    @PostMapping
    public AjaxResponse push(@RequestBody PushRequest request)
    {
        return null;
    }

    @PostMapping("broadcast")
    public AjaxResponse broadcast(@RequestBody BroadcastRequest request)
    {
        return null;
    }

    @PostMapping("pushGroup")
    public AjaxResponse pushGroup(@RequestBody PushGroupRequest request)
    {
        return null;
    }
}
