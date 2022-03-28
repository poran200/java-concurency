package com.demo.thread.syncronized;

public class SynchronizeExchangerMain {
    public static void main(String[] args) {
        SyncronizedExchnger exchnger = new SyncronizedExchnger();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                exchnger.setObj("" + i);
            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(exchnger.getObj());
            }
        });
       thread.start();
       thread1.start();

    }
}
