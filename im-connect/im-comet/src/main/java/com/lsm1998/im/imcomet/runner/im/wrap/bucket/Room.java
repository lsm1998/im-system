package com.lsm1998.im.imcomet.runner.im.wrap.bucket;

import com.lsm1998.im.protobuf.comet.Comet;
import lombok.Getter;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Room
{
    @Getter
    private final String id;

    private final ReadWriteLock rwLock;

    private NetChannel next;

    private boolean drop;

    @Getter
    private int online;

    public Room(String id)
    {
        this.id = id;
        this.rwLock = new ReentrantReadWriteLock();
    }

    public void put(NetChannel netChannel)
    {
        if (this.drop)
            throw new RuntimeException("房间已经关闭");
        try
        {
            rwLock.writeLock().lock();
            if (next != null)
            {
                next.setPrev(netChannel);
            }
            netChannel.setNext(next);
            netChannel.setPrev(null);
            next = netChannel;
            this.online++;
        } finally
        {
            rwLock.writeLock().unlock();
        }
    }

    public void delete(NetChannel netChannel)
    {
        try
        {
            rwLock.writeLock().lock();
            if (netChannel.getNext() != null)
            {
                netChannel.getNext().setPrev(netChannel.getPrev());
            }
            if (netChannel.getPrev() != null)
            {
                netChannel.getPrev().setNext(netChannel.getNext());
            } else
            {
                next = netChannel.getNext();
            }
            netChannel.setNext(null);
            netChannel.setPrev(null);
            if (--this.online == 0)
                this.drop = true;
        } finally
        {
            rwLock.writeLock().unlock();
        }
    }

    public void push(Comet.Proto proto)
    {
        try
        {
            rwLock.readLock().lock();
            for (NetChannel ch = next; ch != null; ch = ch.getNext())
            {
                ch.push(proto);
            }
        } finally
        {
            rwLock.readLock().unlock();
        }
    }

    public void close()
    {
        try
        {
            rwLock.readLock().lock();
            for (NetChannel ch = next; ch != null; ch = ch.getNext())
            {
                ch.close();
            }
        } finally
        {
            rwLock.readLock().unlock();
        }
    }

    public int onlineNum()
    {
        return this.online;
    }
}
