package com.demo.thread;

public class ThreadExample2 {
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("my thread is running");
            System.out.println("my thread is finished");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
