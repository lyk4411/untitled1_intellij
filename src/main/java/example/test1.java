package example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/4/7.
 * Package name: example
 * Porject name: untitled1
 */
public class test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list);
        list.add(null);
        System.out.println(list.size());
        System.out.println(list);
        list.add(null);
        System.out.println(list.size());
        System.out.println(list);
    }
}
