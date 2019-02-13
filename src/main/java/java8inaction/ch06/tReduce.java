package java8inaction.ch06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by lyk on 2019-2-13.
 * Package name: java8inaction.ch06
 * Porject name: untitled1
 */
public class tReduce {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6,7,8).stream();
        myList<Integer> numbers = stream.reduce(
                new myList<>(),
                 (myList<Integer> l, Integer e) -> {
                     System.out.println("l:" + l + " and e:" + e);
                     l.add(e);
                     return l;
                 },
                (myList<Integer> l1, myList<Integer> l2) -> {
                    System.out.println("l1: " + l1);
                    System.out.println("l2: " + l2);
                    return new myList<>();
                }

        );
        System.out.println("numbers: " + numbers);
    }
    static class myList<Integer> extends ArrayList<Integer>{
        myList(){
            super();
            System.out.println("init...");
        }
    }
}
