package com.wenhuisoft.chapter5;

/**
 * Created by lyk on 2016/7/12.
 * Package name: com.wenhuisoft.chapter5
 * Porject name: untitled1
 */

public class DaemonThreadTest1 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                int i = 0;
                while (i++ <= 100) {
                    System.out.println("jjjjjjjjjjjjj:" + i);
                }
            }
        };
        t1.setDaemon(true);
        t1.start();
        int i = 0;
        while (i++ <= 10) {
            System.out.println("iiiiiiiii:" + i);
        }
    }
}
