package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2017/6/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        SubarraySumEqualsK ssek = new SubarraySumEqualsK();
        int[] nums = new int[]{1,1,1};
        System.out.println(ssek.subarraySum(nums,2));
    }
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
