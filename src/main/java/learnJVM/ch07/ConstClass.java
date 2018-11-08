package learnJVM.ch07;

/**
 * Created by lyk on 2018-11-8.
 * Package name: learnJVM.ch07
 * Porject name: untitled1
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world";
}
