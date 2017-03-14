package example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lyk on 2017/3/14.
 * Package name: example
 * Porject name: untitled1
 */
public class testHashset {
    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l2.add(2);
        l2.add(1);
        l3.add(1);
        l3.add(2);
        set.add(l1);
        set.add(l2);
        set.add(l3);
        System.out.println(set);
        System.out.println(l1.hashCode());
        System.out.println(l2.hashCode());
        System.out.println(l3.hashCode());

    }
}
