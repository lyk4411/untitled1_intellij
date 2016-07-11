package com.wenhuisoft.chapter3;

/**
 * Created by lyk on 2016/7/11.
 * Package name: com.wenhuisoft.chapter3
 * Porject name: untitled1
 */

class ClassA {
    public synchronized void A() {
        System.out.println("AAAAAAAAAAAAAAAAA");
        while (true) { // do nothing
        }
    }

    public synchronized void B() {
        System.out.println("BBBBBBBBBBBBBBBBB");
        while (true) {
// do nothing
        }
    }
}

public class MethodSynchronizedTest {
    public static void main(String[] args) {
        final ClassA clazz = new ClassA(); //启动一个线程
        new Thread(new Runnable() {
            public void run() {
                clazz.A();//调用A方法
            }
        }).start(); //启动另一个线程
        new Thread(new Runnable() {
            public void run() {
                clazz.B();// 调用B方法
            }
        }).start();
    }
}