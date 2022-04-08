package com.demo.thread.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            long timeMillis = System.currentTimeMillis();
            try {
                this.blockingQueue.put("" + timeMillis);
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
            sleep(1000);
        }
    }

    private void sleep(int timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException ignored) {

        }
    }
}

