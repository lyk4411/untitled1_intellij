package com.wenhuisoft.chapter3;

/**
 * Created by lyk on 2016/7/11.
 * Package name: com.wenhuisoft.chapter3
 * Porject name: untitled1
 */
class TicketWindow2 implements Runnable {
    private int max_value = 0;

    public void run() {
        while (true) {
            if (ticket()) break;
        }
    }

    /** * */
    private synchronized boolean ticket() {
        if (max_value > 500) {
            return true;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + ":" + max_value++);
        return false;
    }
}