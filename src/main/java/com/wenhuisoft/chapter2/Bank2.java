package com.wenhuisoft.chapter2;

/**
 * Created by lyk on 2016/7/5.
 */
public class Bank2 {
    public static void main(String[] args) {
        TicketWindow2 tw2 = new TicketWindow2();//1
        Thread t1 = new Thread(tw2);//2
        Thread t2 = new Thread(tw2);//3
        Thread t3 = new Thread(tw2);//4
        t1.start();
        t2.start();
        t3.start();
    }
}