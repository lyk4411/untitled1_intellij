package leetcode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

/**
 * Created by lyk on 2017/7/12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SmallestRange {

    public static void main(String[] args) {
        SmallestRange sr = new SmallestRange();
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        List<Integer> a3 = new ArrayList<>();
        a1.add(0,26);
        a1.add(0,24);
        a1.add(0,15);
        a1.add(0,10);
        a1.add(0,4);
        a2.add(0,20);
        a2.add(0,12);
        a2.add(0,9);
        a2.add(0,0);
        a3.add(0,30);
        a3.add(0,22);
        a3.add(0,18);
        a3.add(0,5);
        nums.add(0,a1);
        nums.add(0,a2);
        nums.add(0,a3);
        int[] results = sr.smallestRange(nums);
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " : ");
        }
        System.out.println();
    }
    public static int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> list = IntStream.range(0, nums.size())
                .mapToObj( i -> nums.get(i).stream().map(x -> new int[]{x, i}))
                .flatMap(y -> y)
                .sorted(Comparator.comparingInt(p -> p[0])).collect(toList());
//        for (int[] temp:list) {
//            for (int i = 0; i < temp.length; i++) {
//                System.out.print(temp[i] + " : ");
//            }
//            System.out.println();
//        }
//        IntStream.range(0, nums.size())
//                .mapToObj( i -> nums.get(i).stream().map(x -> new int[]{x, i})).collect(toList()).forEach(System.out::println);

        int[] counts = new int[nums.size()];
        BitSet set = new BitSet(nums.size());
        int start = -1;
        int[] res = new int[2];
        for(int i = 0; i < list.size(); i++) {
            int[] p = list.get(i);
            set.set(p[1]);
            counts[p[1]] += 1;
            if(start == -1) { start = 0; }
            while(start < i && counts[list.get(start)[1]] > 1) {
                counts[list.get(start)[1]]--;
                start++;
            }
            if(set.cardinality() == nums.size()) {
                if( (res[0] == 0 && res[1] == 0) || (list.get(i)[0] - list.get(start)[0]) < res[1] - res[0]) {
                    res[0] = list.get(start)[0];
                    res[1] = list.get(i)[0];
                }
            }
        }
        return res;
    }
}
