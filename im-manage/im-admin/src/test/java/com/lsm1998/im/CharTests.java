package com.lsm1998.im;

import com.lsm1998.im.common.utils.StringUtil;
import org.junit.jupiter.api.Test;

public class CharTests
{
    private static final char[] appidSeed = new char[62];

    static
    {
        int index = 0;
        for (int i = '0'; i <= '9'; i++)
        {
            appidSeed[index++] = (char) i;
        }
        for (int i = 'A'; i <= 'Z'; i++)
        {
            appidSeed[index++] = (char) i;
        }
        for (int i = 'a'; i <= 'z'; i++)
        {
            appidSeed[index++] = (char) i;
        }
    }

    @Test
    public void testChar() throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            Thread.sleep(1);
            System.out.println(StringUtil.randomStr(8, appidSeed));
        }
    }
}
