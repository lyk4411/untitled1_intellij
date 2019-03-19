package example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lyk on 2019-3-19.
 * Package name: example
 * Porject name: untitled1
 */
public class ThreadPoolexample {
    public static void ExecutorServiceTest() {
        ExecutorService es = Executors.newFixedThreadPool(100);
        for(int i = 0;i<100;i++) {    // 进行初始化各个线程，所以现用Runnable进行补充
            es.execute(new Runnable() {
                int i = 9;
                @Override
                public void run() {
                    int b =  i*9;
                    Math.acos(b);
                    Math.sin(b);
                    Math.acos(b);
                    Math.sin(b);
                    Math.acos(b);
                    Math.sin(b);
                    Math.acos(b);
                    Math.sin(b);
                }
            });
        }
        long time  = System.currentTimeMillis();
        int count = 10000000;
        while(count>0) {
            es.execute(new Runnable() {

                int i = 9;
                @Override
                public void run() {
                    int b =  i*9;
                    Math.acos(b);
                    Math.sin(b);
                    Math.acos(b);
                    Math.sin(b);
                    Math.acos(b);
                    Math.sin(b);
                    Math.acos(b);
                    Math.sin(b);
                }
            });
            count--;
        }
        es.shutdown();
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void SelfThreadTest() {
        final ConcurrentLinkedQueue<Integer> queue1 = new ConcurrentLinkedQueue<>();

        final List<Thread> threadlist = new ArrayList<>(100);
        for(int i = 0;i<100;i++) {
            Thread t = new Thread(new Runnable() {

                Integer b ;
                boolean next = true;
                @Override
                public void run() {
                    while(true) {
                        b = queue1.poll();
                        if(b == null) {
                            if(!next) {return;}
                            continue;
                        }
                        int c = b*9;
                        Math.acos(b);
                        Math.sin(b);
                        Math.acos(b);
                        Math.sin(b);
                        Math.acos(b);
                        Math.sin(b);
                        Math.acos(b);
                        Math.sin(b);
                        next = false;
                    }

                }
            });

            threadlist.add(t);
        }


        for(int i = 0;i<100;i++) {
            threadlist.get(i).start();
        }

        int count = 10000000;
        long time  = System.currentTimeMillis();
        while(count>0) {
            queue1.offer(count);
            count --;

        }

        while(true) {
            if(threadlist.get(99).getState() == Thread.State.TERMINATED) {  // 这里没有做太详细的判断略
                break;
            }
        }

        System.out.println(System.currentTimeMillis() - time);
    }

    public static void main(String[] args) {

        ExecutorServiceTest();
        SelfThreadTest();
    }
}
