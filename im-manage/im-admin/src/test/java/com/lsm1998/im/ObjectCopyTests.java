package com.lsm1998.im;

import com.lsm1998.im.common.utils.ObjectCopy;
import com.lsm1998.im.imadmin.internal.accessToken.dao.AccessToken;
import com.lsm1998.im.imadmin.internal.account.dao.Account;
import org.junit.jupiter.api.Test;

public class ObjectCopyTests
{
    @Test
    void objectCopyTests()
    {
        Account account = new Account();
        account.setId(1L);

        AccessToken token = ObjectCopy.copy(account, AccessToken.class);
        System.out.println(token.getId());
    }
}
