package example;

import java.util.*;

/**
 * Created by lyk on 2017/3/14.
 * Package name: example
 * Porject name: untitled1
 */
public class testTreeset {
    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        List<Integer> a3 = new ArrayList<>();

        a1.add(1);
        a1.add(5);
        a1.add(10);
        a2.add(10);
        a2.add(5);
        a2.add(1);
        a3.add(1);
        a3.add(5);
        a3.add(10);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);


        Set<List<Integer>> result = new TreeSet<List<Integer>>(new Comparator<List<Integer>>() {
        public int compare(List<Integer> o1, List<Integer> o2) {
            if(!o1.isEmpty() && !o2.isEmpty()){
                if(o1.size() != o2.size()){return 1;}
                int n = o1.size();
                for (int i = 0; i < n; i++) {
                    if(o1.get(i) != o2.get(i)){return 1;}
                    }
            }
            return 0;
            }
        });
        result.add(a1);
        result.add(a2);
        result.add(a3);

        System.out.println(result);
    }
}
