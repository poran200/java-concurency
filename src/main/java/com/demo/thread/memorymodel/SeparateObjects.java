package com.demo.thread.memorymodel;

public class SeparateObjects {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        Runnable myRunnable = new MyRunnable(myObject);
        Runnable myRunnable1 = new MyRunnable(myObject);
        Thread thread = new Thread(myRunnable, "Thread 1");
        Thread thread1 = new Thread(myRunnable1, "Thread 2");
        thread.start();
        thread1.start();
    }
}