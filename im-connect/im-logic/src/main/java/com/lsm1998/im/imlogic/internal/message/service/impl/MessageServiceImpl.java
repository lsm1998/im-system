package com.lsm1998.im.imlogic.internal.message.service.impl;

import com.lsm1998.im.common.enums.MessageStatus;
import com.lsm1998.im.imlogic.internal.message.dao.Message;
import com.lsm1998.im.imlogic.internal.message.dao.repo.MessageRepo;
import com.lsm1998.im.imlogic.internal.message.service.MessageService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MessageServiceImpl implements MessageService
{
    @Resource
    private MessageRepo messageRepo;

    @Override
    public int readMessage(Long userId, Long messageId)
    {
        Optional<Message> message = messageRepo.findById(messageId);
        message.ifPresent(value ->
        {
            if (value.getFromId().equals(userId) && value.getFormStatus().equals(MessageStatus.UNREAD))
            {
                value.setFormStatus(MessageStatus.READ);
            } else if (value.getToId().equals(userId) && value.getToStatus().equals(MessageStatus.UNREAD))
            {
                value.setToStatus(MessageStatus.READ);
            } else
            {
                throw new RuntimeException("阅读消息操作失败");
            }
        });
        return 1;
    }

    @Override
    public int deleteMessage(Long userId, Long messageId)
    {
        Optional<Message> message = messageRepo.findById(messageId);
        message.ifPresent(value ->
        {
            if (value.getFromId().equals(userId) && !value.getFormStatus().equals(MessageStatus.DELETE))
            {
                value.setFormStatus(MessageStatus.DELETE);
            } else if (value.getToId().equals(userId) && !value.getToStatus().equals(MessageStatus.DELETE))
            {
                value.setToStatus(MessageStatus.DELETE);
            } else
            {
                throw new RuntimeException("删除消息操作失败");
            }
        });
        return 1;
    }

    @Override
    public int deleteMessageByUserId(Long userId)
    {
        List<Message> list = messageRepo.findAllByToId(userId)
                .stream()
                .filter(value -> !value.getFormStatus().equals(MessageStatus.DELETE))
                .peek(value -> value.setFormStatus(MessageStatus.DELETE))
                .toList();
        messageRepo.saveAll(list);
        return list.size();
    }

    @Override
    public int deleteMessageByGroupIdAndUserId(Long groupId, Long userId)
    {
        return 0;
    }

    @Override
    public List<Message> getMessageByUserId(Long userId)
    {
        return null;
    }

    @Override
    public List<Message> getMessageByGroupId(Long groupId)
    {
        return null;
    }

    @Override
    public int getUnreadMessageCount(Long userId)
    {
        return 0;
    }

    @Override
    public int getMessageCount(Long userId)
    {
        return 0;
    }
}
