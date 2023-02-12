package com.lsm1998.im.imjob;

import com.lsm1998.im.imjob.user.dao.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ImJobApplication.class)
class ImJobApplicationTests
{
    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads()
    {
        System.out.println(userMapper);
    }
}