package JavaConcurrencyinPractice;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by lyk on 2018-12-19.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */
class Athlete implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String name;

    public Athlete(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "就位");
        try {
            cyclicBarrier.await();
            Random random =new Random();
            double time = random.nextDouble() + 9;
            System.out.println(name + ": "+ time);
        } catch (Exception e) {
        }
    }
}
