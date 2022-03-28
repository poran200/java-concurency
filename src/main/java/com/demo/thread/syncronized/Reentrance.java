package com.demo.thread.syncronized;

public class Reentrance {
    private int count = 0;

    public synchronized  void  inc(){
        this.count++;
    }
    public synchronized int intAndGet(){
        inc();
        return this.count;
    }
}
