package com.demo.thread.memorymodel;

public class MyRunnable implements Runnable {
    private  int count = 0;
    private MyObject myObject = null;

    public MyRunnable(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {

        System.out.println(myObject);
        for (int i = 0; i < 1_000_000; i++) {
            // try to solve race condition
            synchronized (this){
                this.count++;
            }
        }
        System.out.println(
                Thread.currentThread().getName()
                        + ":" +this.count
        );

    }
}
