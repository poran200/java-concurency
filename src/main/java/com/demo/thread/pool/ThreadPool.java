package com.demo.thread.pool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
    private BlockingQueue<Runnable> taskQueue = null;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();
    private boolean isStopped = false;
    public ThreadPool(int noOfThreads, int maxNoOfThreads){
       this.taskQueue = new ArrayBlockingQueue<>(maxNoOfThreads);
        for (int i = 0; i < noOfThreads; i++) {
            PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);
            runnables.add(poolThreadRunnable);
        }
        for (PoolThreadRunnable runnable : runnables) {
            new Thread(runnable).start();
        }
    }
    public synchronized void execute(Runnable task){
        if (this.isStopped){
            throw  new IllegalStateException("Thread pool is stopped");
        }
        this.taskQueue.offer(task);
    }
    public synchronized void stop(){
        this.isStopped = true;
        runnables.forEach(PoolThreadRunnable::doStop);
    }
    public synchronized void waitUntilAllTasksFinished(){
        while (!this.taskQueue.isEmpty()){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
