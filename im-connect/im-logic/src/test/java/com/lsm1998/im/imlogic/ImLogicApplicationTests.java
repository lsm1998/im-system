package com.lsm1998.im.imlogic;

import com.lsm1998.im.common.enums.MessageStatus;
import com.lsm1998.im.common.enums.MessageType;
import com.lsm1998.im.imlogic.internal.message.dao.Message;
import com.lsm1998.im.imlogic.internal.message.dao.repo.MessageRepo;
import com.lsm1998.im.imlogic.internal.message.service.MessageService;
import com.lsm1998.im.imlogic.middleware.redis.OnlineRedisFacade;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ImLogicApplication.class)
class ImLogicApplicationTests
{

    @Resource
    private OnlineRedisFacade onlineRedisFacade;

    @Resource
    private MessageRepo messageRepo;

    @Resource
    private MessageService messageService;

    @Test
    void addOnline()
    {
        for (int i = 1; i <= 100; i++)
        {
            onlineRedisFacade.addOnline((long) i);
        }
    }

    @Test
    void getOnlineCount()
    {
        System.out.println(onlineRedisFacade.getOnlineCount());
    }

    @Test
    void getOnlineList()
    {
        System.out.println(onlineRedisFacade.getOnlineList());
    }

    @Test
    void saveMessage()
    {
        Message message = new Message();
        message.setId(1L);
        message.setFromId(1L);
        message.setToId(2L);
        message.setType(MessageType.TEXT);
        message.setContent("测试消息");
        message.setFormStatus(MessageStatus.UNREAD);
        message.setToStatus(MessageStatus.READ);
        System.out.println(messageRepo.save(message));
    }

    @Test
    void readMessage()
    {
        messageService.readMessage(2L,1L);
    }
}
