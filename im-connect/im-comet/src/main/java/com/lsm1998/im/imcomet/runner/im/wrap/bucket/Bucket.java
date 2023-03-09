package com.lsm1998.im.imcomet.runner.im.wrap.bucket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bucket
{
    private final Map<String, NetChannel> chs;

    private final Map<String, Room> rooms;

    private int routinesNum;

    public Bucket()
    {
        // this.rwLock = new ReentrantReadWriteLock();
        this.chs = new ConcurrentHashMap<>();
        this.rooms = new ConcurrentHashMap<>();
    }

    public NetChannel getChannel(String key)
    {
        return chs.get(key);
    }
}
