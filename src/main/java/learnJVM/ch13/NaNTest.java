package learnJVM.ch13;

/**
 * Created by lyk on 2018-12-3.
 * Package name: learnJVM.ch13
 * Porject name: untitled1
 */
public class NaNTest {
    public static void main(String[] args) {
        Float a = Float.NaN;
        Float b = Float.NaN;
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(1.0 != b);

    }
}
