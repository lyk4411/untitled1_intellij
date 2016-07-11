package com.wenhuisoft.chapter2;

/**
 * Created by lyk on 2016/7/5.
 */
class TicketWindow2 implements Runnable {
    private int max_value = 0;
    private Bank lock = new Bank();

    public void run() {
        while (true) {
            synchronized (lock) {
                if (max_value > 500) break;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + ":" + max_value++);
            }
        }
    }
}