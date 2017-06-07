package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2017/6/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        ContinuousSubarraySum css = new ContinuousSubarraySum();
        int[] nums = new int[]{2,14,15,7,5,23,21,34};
        System.out.println(css.checkSubarraySum(nums,6));
        System.out.println(css.checkSubarraySum(nums,17));
        System.out.println(css.checkSubarraySum(nums,19));
        System.out.println(css.checkSubarraySum(nums,197));
    }
    //若数字a和b分别除以数字c，若得到的余数相同，那么(a-b)必定能够整除c。
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){};
        map.put(0,-1);
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }
}
