package com.lsm1998.im.imcomet.im.bucket;

import com.lsm1998.im.imcomet.grpc.protobuf.Comet;
import lombok.Getter;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Room
{
    @Getter
    private final String id;

    private final ReadWriteLock rwLock;

    private Channel next;

    private boolean drop;

    @Getter
    private int online;

    public Room(String id)
    {
        this.id = id;
        this.rwLock = new ReentrantReadWriteLock();
    }

    public void put(Channel channel)
    {
        if (this.drop)
            throw new RuntimeException("房间已经关闭");
        try
        {
            rwLock.writeLock().lock();
            if (next != null)
            {
                next.setPrev(channel);
            }
            channel.setNext(next);
            channel.setPrev(null);
            next = channel;
            this.online++;
        } finally
        {
            rwLock.writeLock().unlock();
        }
    }

    public void delete(Channel channel)
    {
        try
        {
            rwLock.writeLock().lock();
            if (channel.getNext() != null)
            {
                channel.getNext().setPrev(channel.getPrev());
            }
            if (channel.getPrev() != null)
            {
                channel.getPrev().setNext(channel.getNext());
            } else
            {
                next = channel.getNext();
            }
            channel.setNext(null);
            channel.setPrev(null);
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
            for (Channel ch = next; ch != null; ch = ch.getNext())
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
            for (Channel ch = next; ch != null; ch = ch.getNext())
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
