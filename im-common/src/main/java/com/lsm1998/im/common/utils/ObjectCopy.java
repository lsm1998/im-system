package com.lsm1998.im.common.utils;

import org.modelmapper.ModelMapper;

public class ObjectCopy
{
    private static final ModelMapper instance = new ModelMapper();

    public static <T> T copy(Object src, Class<T> dest)
    {
        return instance.map(src, dest);
    }
}
