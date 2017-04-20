package example;

/**
 * Created by lyk on 2017/4/20.
 * Package name: example
 * Porject name: untitled1
 */
public class testbit {
    public static void main(String[] args) {
        char a = 'a';
        System.out.println(a - 'a');
        System.out.println(1 << (a - 'a'));
        System.out.println(1 << ('b' - 'a'));
        System.out.println(1 << ('c' - 'a'));
        System.out.println(1 << ('d' - 'a'));


    }
}
