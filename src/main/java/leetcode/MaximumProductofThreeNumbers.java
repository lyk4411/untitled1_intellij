package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/6/26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximumProductofThreeNumbers {
    public static void main(String[] args) {
        MaximumProductofThreeNumbers mptn = new MaximumProductofThreeNumbers();
        int[] nums = new int[]{1,2,3,4,6};
        System.out.println(mptn.maximumProduct(nums));
    }
    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        //One of the Three Numbers is the maximum value in the array.

        int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int b = nums[0] * nums[1] * nums[nums.length - 1];
        return a > b ? a : b;
    }
}
