package JavaConcurrencyinPractice;

/**
 * Created by lyk on 2019-1-4.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */
public class NCPU {
    public static void main(String[] args) {
        System.out.println("CPU:" + Runtime.getRuntime().availableProcessors());
        System.out.println("max memory:" + Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println("free memory:" + Runtime.getRuntime().freeMemory() / 1024 / 1024);
    }
}
