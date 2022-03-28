package com.demo.thread.syncronized;

public class MixedSynchronization {
    public static  Object staticObject = null;

    public static synchronized void setStaticObject(Object object) {
        staticObject = object;
    }
    public Object instanceObj = null;

    public synchronized void setInstanceObj(Object instanceObj) {
        this.instanceObj = instanceObj;
    }
}
