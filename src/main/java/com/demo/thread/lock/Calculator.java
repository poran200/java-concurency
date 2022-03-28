package com.demo.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Calculator {
    private static final int UNSPECIFIED = -1;
    private static final int ADDITION = 0;
    private static final int SUBTRACTION = 1;
    int type = UNSPECIFIED;
    public double value;

    public Calculator(int type, double value) {
        this.type = type;
        this.value = value;
    }

    private double result = 0.0D;
    Lock lock = new ReentrantLock();

    public void add(double value) {
        try {
            lock.lock();
            this.result += value;
        }finally {
            lock.unlock();
        }
    }
    public void subtract(double value) {
        try {
            lock.lock();
            this.result -= value;
        }finally {
            lock.unlock();
        }
    }
    public void calculate(Calculation ... calculations){
      try{
          lock.lock();
          for (Calculation calculation : calculations) {
              switch (calculation.type){
                  case Calculation.ADDITION : add(calculation.value); break;
                  case Calculation.SUBTRACTION: subtract(calculation.value); break;
                  default: throw  new IllegalArgumentException(" the operation not specifics");
              }
          }
      }finally {
          lock.unlock();
      }
    }

    public class Calculation{

        public static final int ADDITION = 0;
        public static final int SUBTRACTION = 1;
        public int type;
        public double value;

        public Calculation(int type, double value) {
            this.type = type;
            this.value = value;
        }
    }
}
