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
        for(int i: nums1){
            set1.add(i);
        }

        HashSet<Integer> set2 = new HashSet<Integer>();
        for(int i: nums2){
            if(set1.contains(i)){
                set2.add(i);
            }
        }

        int[] result = new int[set2.size()];
        int i=0;
        for(int n: set2){
            result[i++] = n;
        }

        return result;
    }
}
