package com.wenhuisoft.chapter6;
import com.wenhuisoft.chapter6.ThreadPoolManager.RunnableTask;
/**
 * Created by lyk on 2016/7/12.
 * Package name: com.wenhuisoft.chapter6
 * Porject name: untitled1
 */

public class ThreadPoolTest1 {
    public static void main(String[] args) {
        final RunnableTask task = new RunnableTask() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "...is execute...");
            }
        };
        ThreadPoolManager poolManager = new ThreadPoolManager();
        for (int i = 0; i < 100; i++) {
            poolManager.execute(task);
        }
    }
}