package com.lsm1998.im;

import com.lsm1998.im.imadmin.utils.JwtUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class JwtUtilTests
{
    @Test
    public void testCreateToken()
    {
        Map<String, Object> claimMap = new HashMap<>();
        claimMap.put("userId", 100);
        String token = JwtUtil.createToken("uGlrwikdKkdasijwinxzcnmpLKkkpoplmiiKsdasd", 500, claimMap);
        System.out.println(token);
    }

    @Test
    public void testParseToken()
    {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmMzkxYWQ4MS0wMjI5LTQwMTctYjQ2My1lYWRlYmI3OGUwMWQiLCJpYXQiOjE2NzU2MTE4ODMsImV4cCI6MTY3NTYxMTg4MywidXNlcklkIjoxMDB9.0jqiuAElHwVk70aWNAPAunYclPN8aZfthog3m12tr6Y";
        JwtUtil.ClaimsParse claimsParse = JwtUtil.parseToken("uGlrwikdKkdasijwinxzcnmpLKkkpoplmiiKsdasd", token);
        System.out.println(claimsParse);
    }
}
