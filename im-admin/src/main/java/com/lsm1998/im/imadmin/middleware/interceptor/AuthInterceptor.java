package com.lsm1998.im.imadmin.middleware.interceptor;

import com.lsm1998.im.common.annotations.AccessPermission;
import com.lsm1998.im.common.model.BaseModel;
import com.lsm1998.im.imadmin.internal.account.dto.AccountTokenDto;
import com.lsm1998.im.imadmin.internal.role.dao.Role;
import com.lsm1998.im.imadmin.internal.role.dao.RoleAuthority;
import com.lsm1998.im.imadmin.internal.role.dao.mapper.RoleAuthorityMapper;
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

import java.util.List;
import java.util.stream.Collectors;

import static com.lsm1998.im.imadmin.internal.role.sevice.impl.RoleServiceImpl.BASE_ADMIN_ROLE_KEY;

@Component
public class AuthInterceptor implements HandlerInterceptor
{
    @Resource
    private ContextHolder contextHolder;

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Resource
    private RoleAuthorityMapper roleAuthorityMapper;

    @Resource
    private RedisTemplate<String, AccountTokenDto> redisTemplate;

    private AccountTokenDto getAccount(String token) throws RuntimeException
    {
        JwtUtil.ClaimsParse claimsParse = JwtUtil.parseToken(secretKey, token);
        if (!claimsParse.isVerify())
        {
            throw new RuntimeException("token校验失败");
        } else if (claimsParse.isExpire())
        {
            throw new RuntimeException("token已过期");
        }
        AccountTokenDto tokenDto = redisTemplate.opsForValue().get(token);
        if (tokenDto == null)
        {
            throw new RuntimeException("token缓存失效");
        }
        return tokenDto;
    }

    private void checkAuthority(String authorityKey, List<Role> roles)
    {
        // 判断是否是超级管理员
        if (roles.stream().anyMatch(role -> role.getRoleKey().equals(BASE_ADMIN_ROLE_KEY)))
        {
            return;
        }
        // 判断是否有权限
        if (roleAuthorityMapper.hasAuthority(authorityKey, roles.stream().map(BaseModel::getId)
                .collect(Collectors.toList())) == null)
        {
            throw new RuntimeException("权限不足");
        }
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
                AccountTokenDto account = getAccount(request.getHeader("token"));
                contextHolder.setAccount(account.getAccount());

                // 校验权限
                checkAuthority(permission.value(), account.getRoles());
            } catch (RuntimeException e)
            {
                response.setStatus(401);
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
