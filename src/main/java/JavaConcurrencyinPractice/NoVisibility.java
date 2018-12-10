package JavaConcurrencyinPractice;

/**
 * Created by lyk on 2018-12-10.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {

        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
