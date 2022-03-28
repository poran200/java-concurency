package com.demo.thread;

public class ThreadExample3 {
    public static void main(String[] args) {
        Runnable runnable = ()-> {
            System.out.println("Runnable lambda running");
            System.out.println("Runnable lambda finished");
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
