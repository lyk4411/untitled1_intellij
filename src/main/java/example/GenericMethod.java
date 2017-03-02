package example;

/**
 * Created by lyk on 2017/3/1.
 * Package name: example
 * Porject name: untitled1
 */
public class GenericMethod {
    public <K,V> void f(K k,V v) {
        System.out.println(k.getClass().getSimpleName());
        System.out.println(v.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.f(new Integer(0),new String("generic"));
    }
}

