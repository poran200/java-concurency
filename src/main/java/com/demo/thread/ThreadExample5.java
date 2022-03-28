package com.demo.thread;

public class ThreadExample5 {
    public static class StoppableRunnable implements  Runnable{
        private boolean stopRequested= false;
        @Override
        public void run() {
            System.out.println("StoppableRunnable running");
            while (!isStopRequested()){
                sleep();
                System.out.println("....");
            }
            System.out.println("StoppableRunnable Stopped");
        }
        public synchronized void requestStop(){
            this.stopRequested = true;
        }
        public synchronized boolean isStopRequested() {
            return stopRequested;
        }
        private void sleep(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread =new Thread(stoppableRunnable,"Stoppable Thread");
        thread.start();
        Thread.sleep(5000);

        System.out.println("requesting stop");
        stoppableRunnable.requestStop();
        System.out.println("stop requested");

    }
}
