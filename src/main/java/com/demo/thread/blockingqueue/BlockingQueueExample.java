package com.demo.thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        Thread consumerThread1 = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
        consumerThread1.start();
    }
}
