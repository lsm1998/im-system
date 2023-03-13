package com.lsm1998.im.imlogic.internal.push.service;

import com.lsm1998.im.imlogic.internal.push.dto.request.BroadcastRequest;
import com.lsm1998.im.imlogic.internal.push.dto.request.PushGroupRequest;
import com.lsm1998.im.imlogic.internal.push.dto.request.PushRequest;

public interface PushService
{
    void push(PushRequest request);

    void broadcast(BroadcastRequest request);

    void pushGroup(PushGroupRequest request);
}
