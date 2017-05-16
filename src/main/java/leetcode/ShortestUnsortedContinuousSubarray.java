package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/5/16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray sucs
                = new ShortestUnsortedContinuousSubarray();
        int[] nums = new int[]{2, 6, 4, 8, 10, 11, 15};
        System.out.println(sucs.findUnsortedSubarray(nums));
    }
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) temp[i] = nums[i];
        Arrays.sort(temp);
        int start = 0;
        while (start < n  && nums[start] == temp[start]) start++;

        int end = n - 1;
        while (end > start  && nums[end] == temp[end]) end--;

        return end - start + 1;
    }
}
