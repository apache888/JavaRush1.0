package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread
{
    static AtomicInteger priority = new AtomicInteger(0);
    public MyThread()
    {
        super();
        if(priority.get() < Thread.currentThread().getThreadGroup().getMaxPriority())
        {
            setPriority(priority.incrementAndGet());
        }else priority = new AtomicInteger(1);
        setPriority(priority.get());
    }

    public MyThread(Runnable target)
    {
        super(target);
        if(priority.get() < Thread.currentThread().getThreadGroup().getMaxPriority())
        {
            setPriority(priority.incrementAndGet());
        }else priority = new AtomicInteger(1);
        setPriority(priority.get());
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        if(priority.get() < Thread.currentThread().getThreadGroup().getMaxPriority())
        {
            setPriority(priority.incrementAndGet());
        }else priority = new AtomicInteger(1);
        setPriority(priority.get());
    }

    public MyThread(String name)
    {
        super(name);
        if(priority.get() < Thread.currentThread().getThreadGroup().getMaxPriority())
        {
            setPriority(priority.incrementAndGet());
        }else priority = new AtomicInteger(1);
        setPriority(priority.get());
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        if(priority.get() < Thread.currentThread().getThreadGroup().getMaxPriority())
        {
            setPriority(priority.incrementAndGet());
        }else priority = new AtomicInteger(1);
        setPriority(priority.get());
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        if(priority.get() < Thread.currentThread().getThreadGroup().getMaxPriority())
        {
            setPriority(priority.incrementAndGet());
        }else priority = new AtomicInteger(1);
        setPriority(priority.get());
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        if(priority.get() < Thread.currentThread().getThreadGroup().getMaxPriority())
        {
            setPriority(priority.incrementAndGet());
        }else priority = new AtomicInteger(1);
        setPriority(priority.get());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        if(priority.get() < Thread.currentThread().getThreadGroup().getMaxPriority())
        {
            setPriority(priority.incrementAndGet());
        }else priority = new AtomicInteger(1);
        setPriority(priority.get());
    }
}
