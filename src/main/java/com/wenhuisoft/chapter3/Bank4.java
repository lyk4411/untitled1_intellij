package com.wenhuisoft.chapter3;

/**
 * Created by lyk on 2016/7/12.
 * Package name: com.wenhuisoft.chapter3
 * Porject name: untitled1
 */

class TicketWindow4 implements Runnable {
    private static int max_value = 0;
    private boolean flag = true;
    private Object lock = new Object();


    public void run() {
        if (flag) {
            while (true) {
                synchronized (TicketWindow4.class) {
                    if (max_value > 500) {
                        break;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread().getName() + ":lock..." + max_value++);
                }
            }
        } else {
            while (true) if (ticket()) break;
        }
    }

    private synchronized static boolean ticket() {
        if (max_value > 500) {
            return true;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + ": method.." + max_value++);
        return false;
    }

    public void change() throws InterruptedException {
        Thread.sleep(30);//读者可以自行思考为什么要sleep
        this.flag = false;
    }
}

public class Bank4 {
    public static void main(String[] args) throws InterruptedException {
        TicketWindow4 tw4 = new TicketWindow4();
        Thread t1 = new Thread(tw4);
        Thread t2 = new Thread(tw4);
        t1.start();
        tw4.change();
        t2.start();
    }
}