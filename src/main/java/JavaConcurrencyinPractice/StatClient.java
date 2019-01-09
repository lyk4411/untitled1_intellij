package JavaConcurrencyinPractice;

/**
 * Created by lyk on 2019-1-8.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class StatClient {
    public static void main(String[] args) {
        ThreadPoolExecutor exec = new StatThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        exec.execute(new Thread(new Printer(5),"ttt5"));
        exec.execute(new Thread(new Printer(4),"ttt4"));
        exec.execute(new Thread(new Printer(3),"ttt3"));
        exec.execute(new Thread(new Printer(2),"ttt2"));
        exec.execute(new Thread(new Printer(1),"ttt1"));
        exec.shutdown();
    }
}


class Printer implements Runnable {
    private int sleepTime;

    public Printer(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}