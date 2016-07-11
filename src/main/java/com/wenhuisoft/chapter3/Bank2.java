package com.wenhuisoft.chapter3;

/**
 * Created by lyk on 2016/7/11.
 * Package name: com.wenhuisoft.chapter3
 * Porject name: untitled1
 */

public class Bank2 {
    public static void main(String[] args) {
        TicketWindow2 tw2 = new TicketWindow2();
        Thread t1 = new Thread(tw2);
        Thread t2 = new Thread(tw2);
        Thread t3 = new Thread(tw2);
        t1.start();
        t2.start();
        t3.start();
    }
}