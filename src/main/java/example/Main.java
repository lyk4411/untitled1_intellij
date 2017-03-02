package example;

import java.lang.reflect.Array;

/**
 * Created by lyk on 2017/3/1.
 * Package name: example
 * Porject name: untitled1
 */


public class Main<T> {

    public T[] create(Class<T> type) {
        return (T[]) Array.newInstance(type, 10);
    }

    public static void main(String[] args) {
        Main<String> m = new Main<String>();
        String[] strings = m.create(String.class);
    }
}