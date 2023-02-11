package com.lsm1998.im.imadmin.interceptor;

import com.lsm1998.im.common.annotations.AccessPermission;
import com.lsm1998.im.imadmin.internal.account.dto.AccountTokenDto;
import com.lsm1998.im.imadmin.utils.JwtUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor
{
    @Resource
    private ContextHolder contextHolder;

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Resource
    private RedisTemplate<String, AccountTokenDto> redisTemplate;

    private void setAccount(String token) throws RuntimeException
    {
        JwtUtil.ClaimsParse claimsParse = JwtUtil.parseToken(secretKey, token);
        if (!claimsParse.isVerify())
        {
            throw new RuntimeException("token校验失败");
        }else if(claimsParse.isExpire())
        {
            throw new RuntimeException("token已过期");
        }
        AccountTokenDto tokenDto = redisTemplate.opsForValue().get(token);
        if (tokenDto == null)
        {
            throw new RuntimeException("token缓存失效");
        }
        contextHolder.setAccount(tokenDto);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception
    {
        contextHolder.setRemoteIp(request.getRemoteAddr());
        if (handler instanceof HandlerMethod method)
        {
            AccessPermission permission = method.getMethodAnnotation(AccessPermission.class);
            if (permission == null)
            {
                return true;
            }
            try
            {
                // 设置当前用户
                setAccount(request.getHeader("token"));

                // 校验权限
                String uri = request.getRequestURI();
            }catch (RuntimeException e)
            {
                response.setStatus(401);
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
