package com.demo.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {
    private long count =0;
    public Lock lock = new ReentrantLock();
    public void inc(){
        try {
            lock.lock();
            this.count++;

        }finally {
            lock.unlock();
        }
    }
    public long getCount(){
        try {
            lock.lock();
            return this.count;
        }finally {
            lock.unlock();
        }
    }
}
