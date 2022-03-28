package com.demo.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample1_1 {


    private int corePoolSize=3;
    private int maxPoolSize=10;
    private long keepAliveTime=300;
    ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
            corePoolSize,
            maxPoolSize, keepAliveTime,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(128)
    );

    public ExecutorServiceExample1_1() {
     runExample();
    }
    public void runExample(){
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println(name);
            }
        });
        threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) {
        new ExecutorServiceExample1_1();
    }


}
