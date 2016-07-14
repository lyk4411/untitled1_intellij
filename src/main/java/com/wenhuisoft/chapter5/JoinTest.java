package com.wenhuisoft.chapter5;

/**
 * Created by lyk on 2016/7/12.
 * Package name: com.wenhuisoft.chapter5
 * Porject name: untitled1
 */

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                int i = 0;
                while (i++ < 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1:" + i);
                }
            }
        };


        Thread t2 = new Thread( () ->{
                int i = 0;
                while (i++ < 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2:" + i);
                }
            });

        t2.start();
        t1.start();

        //t1.join();
        for (int i = 0; i < 100; i++) {
            Thread.sleep(10);
            System.out.println("main:" + i);
        }
    }
}