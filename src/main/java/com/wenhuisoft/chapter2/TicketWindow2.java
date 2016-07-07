package com.wenhuisoft.chapter2;

/**
 * Created by lyk on 2016/7/5.
 */

class TicketWindow2 implements Runnable {
    private int max_value = 0;

    public void run() {
        while (true) {
            if (max_value > 50) break;
            System.out.println(Thread.currentThread().getName() + ":" + max_value++);
        }
    }
}