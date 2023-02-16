package com.lsm1998.im.imlogic.internal.message.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.imlogic.internal.message.dto.request.BroadcastRequest;
import com.lsm1998.im.imlogic.internal.message.dto.request.PushGroupRequest;
import com.lsm1998.im.imlogic.internal.message.dto.request.PushRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushController
{
    @PostMapping("push")
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
