package com.wenhuisoft.chapter2;

/**
 * Created by lyk on 2016/7/5.
 */
class TicketWindow extends Thread {
    static int max_value = 0;//最大的号码

    @Override
    public void run() {
        while (true) {
            if (max_value > 50) {
                break;
            }
            System.out.println(currentThread().getName() + ":" + max_value++);
        }
    }
}