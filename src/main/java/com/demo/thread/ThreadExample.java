package com.demo.thread;

public class ThreadExample {

    public static class MyRunnable implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread());
            System.out.println("Running my Thread");
            System.out.println("Finish myThread ");

        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();

    }
}
