package com.lsm1998.im.imlogic.internal.message.service;

import com.lsm1998.im.imlogic.internal.message.dao.Message;

import java.util.List;

public interface MessageService
{
    /**
     * 阅读消息
     *
     * @param userId    用户ID
     * @param messageId 消息ID
     * @return int
     */
    int readMessage(Long userId, Long messageId);

    /**
     * 删除消息
     *
     * @param userId    用户ID
     * @param messageId 消息ID
     * @return int
     */
    int deleteMessage(Long userId, Long messageId);

    /**
     * 删除用户的所有消息
     *
     * @param userId 用户ID
     * @return int
     */
    int deleteMessageByUserId(Long userId);

    /**
     * 删除群组的所有消息
     *
     * @param groupId 群组ID
     * @param userId  用户ID
     * @return int
     */
    int deleteMessageByGroupIdAndUserId(Long groupId, Long userId);

    /**
     * 消息列表
     *
     * @param userId 用户ID
     * @return List<Message>
     */
    List<Message> getMessageByUserId(Long userId);

    /**
     * 群组消息列表
     *
     * @param groupId 群组ID
     * @return List<Message>
     */
    List<Message> getMessageByGroupId(Long groupId);

    /**
     * 获取未读消息数量
     *
     * @param userId 用户ID
     * @return int
     */
    int getUnreadMessageCount(Long userId);

    /**
     * 获取消息数量
     *
     * @param userId 用户ID
     * @return int
     */
    int getMessageCount(Long userId);
}
