package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/6/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class OneThreeTwoPattern {
    public static void main(String[] args) {
        OneThreeTwoPattern ottp = new OneThreeTwoPattern();
        int[] nums1 = new int[]{1,2,3,4,5};
        int[] nums2 = new int[]{1,3,2,5,4};
        System.out.println(ottp.find132pattern(nums1));
        System.out.println(ottp.find132pattern(nums2));
    }

    public boolean find132pattern(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.min(nums[i - 1], arr[i - 1]);
        }

        for (int j = nums.length - 1, top = nums.length; j >= 0; j--) {
            if (nums[j] <= arr[j]) continue;
            while (top < nums.length && arr[top] <= arr[j]) top++;
            if (top < nums.length && nums[j] > arr[top]) return true;
            arr[--top] = nums[j];
        }

        return false;
    }
}
