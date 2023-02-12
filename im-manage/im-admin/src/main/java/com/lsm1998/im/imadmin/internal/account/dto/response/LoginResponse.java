package com.lsm1998.im.imadmin.internal.account.dto.response;

import com.lsm1998.im.imadmin.internal.account.dao.Account;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse
{
    private Account account;

    private String token;

    private Long expire;

    public static LoginResponse of(Account account, String token, Long expire)
    {
        return LoginResponse.
                builder().
                account(account).
                token(token).
                expire(expire).
                build();
    }
}
