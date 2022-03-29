package com.demo.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Lock lock1 = new ReentrantLock();
        Runnable runnable1 = new Runnable1(lock, lock1);
        Runnable runnable2 = new Runnable2(lock, lock1);
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
    }
}
