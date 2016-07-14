package com.wenhuisoft.chapter6;

/**
 * Created by lyk on 2016/7/12.
 * Package name: com.wenhuisoft.chapter6
 * Porject name: untitled1
 */

public class ThreadGroupCopy {
    public static void main(String[] args) { //local inner class extends Thread
        class MyThread extends Thread {
            public MyThread(ThreadGroup tg, String name) {
                super(tg, name);
            }

            private boolean flag = true;

            @Override
            public void run() {
                while (flag) {
                    try {
                        System.out.println(currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            public void close() {
                this.flag = false;
            }
        }
        ThreadGroup tg = new ThreadGroup("tg");
        MyThread t1 = new MyThread(tg, "t1");
        t1.start();
        MyThread t2 = new MyThread(tg, "t2");
        t2.start();
        MyThread t3 = new MyThread(tg, "t3");
        t3.start(); //copy
        Thread[] ts = new Thread[tg.activeCount()];
        System.out.println("before close:current active Count:" + tg.activeCount());
        tg.enumerate(ts);
        for (Thread t : ts) {
            ((MyThread) t).close();
            //break;
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println(" after close: current active Count:" + tg.activeCount());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}