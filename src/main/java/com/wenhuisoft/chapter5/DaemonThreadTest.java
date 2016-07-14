package com.wenhuisoft.chapter5;

/**
 * Created by lyk on 2016/7/12.
 * Package name: com.wenhuisoft.chapter5
 * Porject name: untitled1
 */

public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                int i = 0;
                while (i++ <= 1000) {
                    System.out.println("jjjjjjjjjjjjj:" + i);
                }
            }
        };
        t1.setDaemon(true);


        Thread t2 =  new Thread( () -> {
            int i = 0;
            while (i++ <= 1000) {
                System.out.println("kkkkkkkkkkkkkk:" + i);
            }
        } );
        t2.setDaemon(true);

        t2.start();
        t1.start();

        int i = 0;
        while (i++ <= 10) {
            System.out.println("iiiiiiiii:" + i);
        }
    }
}