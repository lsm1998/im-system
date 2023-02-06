package com.lsm1998.im.imadmin.internal.account.model.response;

import com.lsm1998.im.imadmin.internal.account.dao.AccountEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse
{
    private AccountEntity account;

    private String token;

    private Long expire;

    public static LoginResponse of(AccountEntity account, String token, Long expire)
    {
        return LoginResponse.
                builder().
                account(account).
                token(token).
                expire(expire).
                build();
    }
}
