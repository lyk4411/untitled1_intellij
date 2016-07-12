package com.wenhuisoft.chapter3;

/**
 * Created by lyk on 2016/7/12.
 * Package name: com.wenhuisoft.chapter3
 * Porject name: untitled1
 */
public class SingleTest {
    private static SingleTest instance = null;

    private SingleTest() {
    }

    public static SingleTest newInstance() {
        if (null == instance) {
            synchronized (SingleTest.class) {
                if (null == instance) {
                    instance = new SingleTest();
                }
            }
        }
        return instance;
    }
}