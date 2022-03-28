package com.demo.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    /* lock is similar to java synchronized block but is more simplified */
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        // do something

        lock.unlock();
    }
}
