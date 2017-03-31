package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/3/31.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KthLargestElementinanArray {
    public static void main(String[] args) {
        KthLargestElementinanArray kea = new KthLargestElementinanArray();
        int[] nums = new int[]{5,4,6,8,2,7,9,1,4};
        System.out.println(kea.findKthLargest(nums,5));
    }
    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}
