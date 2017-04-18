package leetcode;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2017/4/18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class IntersectionofTwoArrays {
    public static void main(String[] args) {
        IntersectionofTwoArrays ita = new IntersectionofTwoArrays();
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{1,1,2,2};
        IntStream.of(ita.intersection(nums1,nums2)).forEach(a -> System.out.print(a + ":"));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();

        IntStream.of(nums1).forEach(a -> set1.add(a));

        HashSet<Integer> set2 = new HashSet<Integer>();

        IntStream.of(nums2).filter(a -> set1.contains(a)).forEach(a -> set2.add(a));

        return set2.stream().mapToInt(Integer::intValue).toArray();

    }
}
