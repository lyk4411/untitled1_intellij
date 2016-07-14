package com.wenhuisoft.chapter7;

/**
 * Created by lyk on 2016/7/14.
 * Package name: com.wenhuisoft.chapter7
 * Porject name: untitled1
 */
public class FetalException {
    static class MyRunnable implements Runnable {
        public void run() {
            throw new Error();
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName());
                System.out.println(e);
            }
        });
        t.start();
    }
}