package com.demo.thread;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        Thread thread = new Thread(() -> {
            threadLocal.set("thread 1");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        });
        Thread thread2= new Thread(() -> {
            threadLocal.set("thread 2");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        });
        thread.start();
        thread2.start();

    }
}
