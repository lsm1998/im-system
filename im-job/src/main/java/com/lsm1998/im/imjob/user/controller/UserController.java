package com.lsm1998.im.imjob.user.controller;

import com.lsm1998.im.common.AjaxResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController
{
    @GetMapping("info")
    @CrossOrigin
    public AjaxResponse info(int offset, int limit)
    {
        List<Integer> result = new ArrayList<>();
        for (int i = offset; i < limit; i++)
        {
            result.add(i);
        }
        return AjaxResponse.success(Map.of("list",result,"count",32));
    }
}
