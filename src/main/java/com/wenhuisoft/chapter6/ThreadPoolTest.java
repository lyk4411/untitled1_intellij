package com.wenhuisoft.chapter6;

/**
 * Created by lyk on 2016/7/13.
 * Package name: com.wenhuisoft.chapter6
 * Porject name: untitled1
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThreadPoolTest {
    private ThreadPool pool = null;

    @Before
    public void init() {
        pool = new ThreadPool(10, 15, 30); //default value
    }

    @After
    public void release() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.destory();
        pool = null;
    }

    @Test
    public void testnormal() {
        for (int i = 0; i < 50; i++) {
            TestTask tt = new TestTask();
            pool.execute(tt);
        }
    }

    private static class TestTask implements ThreadPool.Task {
        public void run() {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) { // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}

