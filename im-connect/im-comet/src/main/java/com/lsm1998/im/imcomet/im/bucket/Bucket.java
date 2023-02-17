package com.lsm1998.im.imcomet.im.bucket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Bucket
{
    private final Map<String, Channel> chs;

    private final Map<String, Room> rooms;

    private int routinesNum;

    public Bucket()
    {
        // this.rwLock = new ReentrantReadWriteLock();
        this.chs = new ConcurrentHashMap<>();
        this.rooms = new ConcurrentHashMap<>();
    }

    public Channel getChannel(String key)
    {
        return chs.get(key);
    }
}
