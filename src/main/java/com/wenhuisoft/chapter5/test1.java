package com.wenhuisoft.chapter5;

/**
 * Created by lyk on 2016/7/12.
 * Package name: com.wenhuisoft.chapter5
 * Porject name: untitled1
 */
public class test1 {
    public static void main(String[] args) {

        Thread t1 = new Thread() {
            public void run() {
                int i = 0;
                while (i++ <= 2000) {
                    System.out.println("iiiiiiiiiiiiiiii:" + i);
                }
            }
        };
        t1.start();
        t1.yield();
        Thread t2 = new Thread() {
            public void run() {
                int i = 0;
                while (i++ <= 1000) {
                    System.out.println("jjjjjjjjjjjjjjj:" + i);
                }
            }
        };
        t2.start();
    }
}
