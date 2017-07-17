package leetcode;

/**
 * Created by lyk on 2017/7/17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        MaximumAverageSubarrayI masi = new MaximumAverageSubarrayI();
        int[] nums = new int[]{1,12,-5,-6,50,3};
        System.out.println(masi.findMaxAverage(nums,4));
    }

    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];
        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
    }
}
