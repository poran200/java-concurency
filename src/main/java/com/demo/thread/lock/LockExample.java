package com.demo.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    /* lock is similar to java synchronized block but is more simplified */
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        /*
        1.Synchronized block must be contained within a single method
          lock.lock() and lock.unlock() can be called from different methods
        2. lock.lock() and lock.unlock() provide the same visibility and happens before
           guarantees as entering and the exiting a synchronized block
        3. Synchronized blocks are always reentrant.Lock could decide not to be.
        4. Synchronized blocks do not guarantee fairness . Lock can.
         */
        lock.lock();
        // do something

        lock.unlock();
    }
}
