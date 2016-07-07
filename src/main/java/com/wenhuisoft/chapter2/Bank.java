package com.wenhuisoft.chapter2;

/**
 * Created by lyk on 2016/7/5.
 */
public class Bank {
    public static void main(String[] args) {
        TicketWindow t1 = new TicketWindow();
        TicketWindow t2 = new TicketWindow();
        TicketWindow t3 = new TicketWindow();
        t1.start();
        t2.start();
        t3.start();
    }
}
