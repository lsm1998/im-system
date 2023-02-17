package com.lsm1998.im.imcomet.connect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Bucket
{
    private ReadWriteLock rwLock;

    private final Map<String, Channel> chs;

    public Bucket()
    {
        this.rwLock = new ReentrantReadWriteLock();
        this.chs = new ConcurrentHashMap<>();
    }

    public Channel get(String key)
    {
        return chs.get(key);
    }
    // c     *conf.Bucket
    //	cLock sync.RWMutex        // protect the channels for chs
    //	chs   map[string]*Channel // map sub key to a channel
    //	// room
    //	rooms       map[string]*Room // bucket room channels
    //	routines    []chan *pb.BroadcastRoomReq
    //	routinesNum uint64
    //
    //	ipCnts map[string]int32
}
