package JavaConcurrencyinPractice;

/**
 * Created by lyk on 2018-12-11.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */
public class ThreadLocalExample {
    public static class MyRunnable implements Runnable {

        private ThreadLocal threadLocal = new ThreadLocal();
        private ThreadLocal threadLocal1 = new ThreadLocal();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));
            threadLocal1.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            System.out.println(threadLocal.get());
            System.out.println(threadLocal1.get());
        }
    }

    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();

    }


}
