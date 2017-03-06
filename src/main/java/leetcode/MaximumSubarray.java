package leetcode;

/**
 * Created by lyk on 2017/3/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArray(new int[]{1,2,-9,2,3,4,-4,5,6,-7,2,3}));
    }
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            max = Math.max(max, sum[i]);
        }

        return max;
    }
}
