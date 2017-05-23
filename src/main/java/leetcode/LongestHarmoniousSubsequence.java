package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2017/5/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        LongestHarmoniousSubsequence lhs = new LongestHarmoniousSubsequence();
        int[] nums = new int[]{1,3,2,2,5,2,3,7};
        System.out.println(lhs.findLHS(nums));
    }
    public int findLHS(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (long num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (long key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                result = Math.max(result, map.get(key + 1) + map.get(key));
            }
        }
        return result;
    }
}
