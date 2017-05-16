package leetcode;

/**
 * Created by lyk on 2017/5/16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray sucs
                = new ShortestUnsortedContinuousSubarray();
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(sucs.findUnsortedSubarray(nums));
    }
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n-1], max = nums[0];
        for (int i=1;i<nums.length;i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-1-i]);
            if (nums[i] < max) end = i;
            if (nums[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }
}
