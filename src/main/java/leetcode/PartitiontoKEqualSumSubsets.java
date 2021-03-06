package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2018-6-7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PartitiontoKEqualSumSubsets {
    public boolean search(int[] groups, int row, int[] nums, int target) {
//        IntStream.of(groups).forEach(n -> System.out.print(n + " : "));
//        System.out.println();
        if (row < 0) return true;
        int v = nums[row--];
//        System.out.println(row + 1);
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if (groups[i] == 0) break;  // return false;
        }
//        System.out.println("false...");
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }

    public static void main(String[] args) {
        PartitiontoKEqualSumSubsets pkess = new PartitiontoKEqualSumSubsets();
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
//        System.out.println(pkess.canPartitionKSubsets(nums, 4));
//        System.out.println(pkess.canPartitionKSubsets(nums, 3));
        int[] nums1 = new int[]{2, 2, 2, 2, 3, 4, 5};
        System.out.println(pkess.canPartitionKSubsets(nums1, 4));
    }
}
