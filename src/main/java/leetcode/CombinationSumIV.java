package leetcode;

/**
 * Created by lyk on 2017/4/21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CombinationSumIV {
    public static void main(String[] args) {
        CombinationSumIV csiv = new CombinationSumIV();
        int[] nums = new int[]{1,2,3,4};
        System.out.println(csiv.combinationSum4(nums,6));
    }
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSum4(nums, target - nums[i]);
            }
        }
        return res;
    }
}
