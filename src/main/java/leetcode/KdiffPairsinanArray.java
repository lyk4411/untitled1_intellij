package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2017/4/12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KdiffPairsinanArray {
    public static void main(String[] args) {
        KdiffPairsinanArray kpa = new KdiffPairsinanArray();
        int[] nums = new int[]{3,1,4,1,5,1,1};
        System.out.println(kpa.findPairs(nums,0));
    }
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
