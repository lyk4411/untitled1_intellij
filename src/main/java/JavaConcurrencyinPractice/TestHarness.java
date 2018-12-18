package JavaConcurrencyinPractice;

import java.util.concurrent.*;

/**
 * TestHarness
 * <p/>
 * Using CountDownLatch for starting and stopping threads in timing tests
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        System.out.println("start:" + start);
        System.out.println("end:" + end);
        System.out.println("duration:" + (end - start)/1000000000.0);
        return end - start;
    }

    public static void main(String[] args) {
        TestHarness th = new TestHarness();
        try {
            th.timeTasks(10,new Thread(() -> {
                try {
                    int i = 0;
                    while (i <= 3) {
                        Thread.sleep(100); // 休眠100ms
                        i++;
                        System.out.println(Thread.currentThread().getName()+" ("+ ") loop " + i);
                    }
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() +" (catch InterruptedException.");
                }
            }));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
