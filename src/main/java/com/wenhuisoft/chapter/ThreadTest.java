package com.wenhuisoft.chapter;

/**
 * Created by lyk on 2016/7/5.
 */
class ThreadTest extends Thread {
    private final static int DEFAULT_VALUE = 100;
    private int maxValue = 0;
    private String threadName = "";

    public ThreadTest(String threadName) {
        this(threadName, DEFAULT_VALUE);
    }

    public ThreadTest(String threadName, int defaultValue) {
        this.maxValue = defaultValue;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < maxValue) {
            i++;
            System.out.println("Thread:" + threadName + ":" + i);
        }
    }
}
