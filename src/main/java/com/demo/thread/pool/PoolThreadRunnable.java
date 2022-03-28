package com.demo.thread.pool;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable{
    private Thread thread = null;
    private boolean isStopped = false;
    private BlockingQueue<Runnable> taskQueue;

    public PoolThreadRunnable(BlockingQueue taskQueue) {

        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
         this.thread = Thread.currentThread();
         while (!isStopped()){
             try {
                 Runnable runnable = taskQueue.take();
                 runnable.run();
             } catch (InterruptedException e) {

             }
         }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.thread.interrupt();
    }
    public synchronized boolean isStopped(){
        return isStopped;
    }
}
