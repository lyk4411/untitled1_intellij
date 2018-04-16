package leetcode;

import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-4-16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SetMismatch {


//    public int[]  findErrorNums(int[] nums){
//        Set<Integer> set = new HashSet<>();
//        int duplicate = 0,n = nums.length;
//        long sum = (n * (n+1)) / 2;
//        for(int i : nums) {
//            if(set.contains(i))
//                duplicate = i;
//            sum -= i;
//            set.add(i);
//        } return new int[]{duplicate,(int)sum + duplicate};
//    }

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0)
                res[0] = Math.abs(i);
            else nums[Math.abs(i) - 1] *= -1;
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) res[1] = i+1;
        }
        return res;
    }

    public static void main(String[] args) {
        SetMismatch sm = new SetMismatch();
        int[] nums1 = new int[]{1,2,2,4};
        int[] nums2 = new int[]{1,2,3,4,5,6,7,7,8,9};
        int[] nums3 = new int[]{1,9,2,3,4,5,6,6,7,8};
        IntStream.of(sm.findErrorNums(nums1)).forEach(n -> System.out.print(n + " "));
        System.out.println();
        IntStream.of(sm.findErrorNums(nums2)).forEach(n -> System.out.print(n + " "));
        System.out.println();
        IntStream.of(sm.findErrorNums(nums3)).forEach(n -> System.out.print(n + " "));
    }
}
