package learnJVM.ch13;

/**
 * Created by lyk on 2018-12-7.
 * Package name: learnJVM.ch13
 * Porject name: untitled1
 */
public class classtest {
    public static void main(String[] args) {
        classtest ct = new classtest();
        Class a =  ct.getClass();
        final String name = a.getName();
        System.out.println(name);
    }
}
