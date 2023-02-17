package com.lsm1998.im.imlogic.internal.message.dao.repo;

import com.lsm1998.im.imlogic.internal.message.dao.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends MongoRepository<Message, Long>
{
    List<Message> findAllByToId(Long userId);
}
