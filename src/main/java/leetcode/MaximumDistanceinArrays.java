package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/6/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximumDistanceinArrays {
    public static void main(String[] args) {
        MaximumDistanceinArrays mda = new MaximumDistanceinArrays();
        List<List<Integer>> arrays = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list1.add(3);list1.add(2);list1.add(1);
        list2.add(5);list2.add(4);
        list3.add(3);list3.add(2);list3.add(1);
        arrays.add(list1);arrays.add(list2);arrays.add(list3);

        System.out.println(mda.maxDistance(arrays));
    }
    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);

        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }

        return result;
    }
}
