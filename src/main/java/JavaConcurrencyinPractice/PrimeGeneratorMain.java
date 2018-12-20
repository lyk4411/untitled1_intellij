package JavaConcurrencyinPractice;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by lyk on 2018-12-20.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */
public class PrimeGeneratorMain {
    public static void main(String[] args){
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            Thread.sleep(100);
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            generator.cancel();
        }
        List<BigInteger> ls = generator.get();
        for(int i= 0;i<ls.size();i++){
            System.out.println(ls.get(i));
        }
    }
}
