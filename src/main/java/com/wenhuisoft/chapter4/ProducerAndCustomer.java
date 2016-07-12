package com.wenhuisoft.chapter4;

/**
 * Created by lyk on 2016/7/12.
 * Package name: com.wenhuisoft.chapter4
 * Porject name: untitled1
 */

class NumberFactory {
    private int i = 0;
    private Object lock = new Object();
    private boolean created = false;

    public void create() {
        synchronized (lock) {
            if (!created) {
                i++;
                System.out.println("create:" + i);
                lock.notify();
                created = true;
            } else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consume() {
        synchronized (lock) {
            if (created) {
                System.out.println("consume:" + i);
                created = false;
                lock.notify();
            } else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ProducerAndCustomer {
    final static NumberFactory numberFactory = new NumberFactory();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    numberFactory.create();
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    numberFactory.consume();
                }
            }
        }).start();
    }
}