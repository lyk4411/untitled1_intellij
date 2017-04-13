package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2017/4/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ContiguousArray {
    public static void main(String[] args) {
        ContiguousArray ca = new ContiguousArray();
        int[] nums = new int[]{0,0,0,1,1,1};
        System.out.println(ca.findMaxLength(nums));
    }
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            }
            else {
                sumToIndex.put(sum, i);
            }
        }
        return max;
    }
}
