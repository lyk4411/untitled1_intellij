package com.wenhuisoft.chapter7;

/**
 * Created by lyk on 2016/7/13.
 * Package name: com.wenhuisoft.chapter7
 * Porject name: untitled1
 */
public class Test extends RunnableWarper {
    @Override
    public void handler() {
        System.out.println("business handler");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Test());
        t.start();
        Thread t1 = new Thread(new Test());
        t1.start();
    }
}