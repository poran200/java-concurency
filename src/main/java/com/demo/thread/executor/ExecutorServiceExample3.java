package com.demo.thread.executor;

import java.util.concurrent.*;

public class ExecutorServiceExample3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(newCallable("Task 1.1"));
        System.out.println(future.isDone());

        try {
            String message = future.get();
            System.out.println(message);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    private static Callable<String> newCallable(String s) {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                String message = Thread.currentThread().getName() + " " + s;
                System.out.println("message = " + message);
                return message;
            }

        };
    }
}
