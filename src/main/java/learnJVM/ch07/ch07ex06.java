package learnJVM.ch07;

/**
 * Created by lyk on 2018-11-8.
 * Package name: learnJVM.ch07
 * Porject name: untitled1
 */
public class ch07ex06 {
    static class Parent {
        public static int A = 1;
//        static {
//            A = 2;
//        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }


}
