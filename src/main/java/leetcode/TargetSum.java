package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2017/5/18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TargetSum {
    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] nums = new int[]{1,2,3,4,5,1,2,3,4,5};
        System.out.println(ts.findTargetSumWays(nums,6));
    }
//递归解法 start//////////////////////////////////////////////////////////
//    public int findTargetSumWays(int[] nums, int s) {
//        int[] res = new int[]{0};
//        help(nums,s,0,res);
//        return  res[0];
//    }
//
//    public void help(int[] nums, int s,int start, int[] res) {
//        if(start >= nums.length){
//            if(s == 0) ++res[0];
//            return;
//        }
//        help(nums,s - nums[start],start + 1,res);
//        help(nums,s + nums[start],start + 1,res);
//    }
//递归解法 end//////////////////////////////////////////////////////////

//动态规划////////////////////////////////////////////////////////
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        return helper(nums, 0, 0, S, new HashMap<>());
    }
    private int helper(int[] nums, int index, int sum, int S, Map<String, Integer> map){
        String encodeString = index + "->" + sum;
        if (map.containsKey(encodeString)){
            return map.get(encodeString);
        }
        if (index == nums.length){
            if (sum == S){
                return 1;
            }else {
                return 0;
            }
        }
        int curNum = nums[index];
        int add = helper(nums, index + 1, sum - curNum, S, map);
        int minus = helper(nums, index + 1, sum + curNum, S, map);
        map.put(encodeString, add + minus);
        return add + minus;
    }
}
