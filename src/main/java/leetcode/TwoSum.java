package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2017/3/9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        int target = 8;
        int[] result = ts.twoSum(nums,target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i + 1);
        }
        return result;
    }
}
