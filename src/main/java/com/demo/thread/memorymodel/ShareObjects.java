package com.demo.thread.memorymodel;

public class ShareObjects {
    public static void main(String[] args) {
        //Race conditions problem
        MyObject myObject = new MyObject();
        MyRunnable myRunnable = new MyRunnable(myObject);
        Thread thread = new Thread(myRunnable, "Thread 1");
        Thread thread1 = new Thread(myRunnable, "Thread 1");
        thread.start();
        thread1.start();
    }
}
