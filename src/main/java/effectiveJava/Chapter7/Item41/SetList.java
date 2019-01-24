package effectiveJava.Chapter7.Item41;// What does this program print? - Page 194

import java.util.*;

public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
            list1.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
            list1.remove(Integer.valueOf(i));
        }

        System.out.println(set + " " + list + " " + list1);
    }
}
