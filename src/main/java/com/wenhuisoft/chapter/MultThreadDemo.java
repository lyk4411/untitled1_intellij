package com.wenhuisoft.chapter;

/**
 * Created by lyk on 2016/7/5.
 */

public class MultThreadDemo {
    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest("t1");
        ThreadTest t2 = new ThreadTest("t2", 200);
        t1.start();
        t2.start();
    }
}