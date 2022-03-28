package com.demo.thread;

public class ThreadExample4 {
    public static void main(String[] args) {
        Runnable runnable = ()-> {
            System.out.println(Thread.currentThread());
            System.out.println("Runnable lambda running");
            System.out.println("Runnable lambda finished");
        };
        Thread thread = new Thread(runnable,"Thread 1");
        thread.start();
        Thread thread1= new Thread(runnable,"Thread 2");
        thread1.start();
    }
}
