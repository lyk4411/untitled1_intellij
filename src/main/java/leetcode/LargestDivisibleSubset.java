package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyk on 2017/4/21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        LargestDivisibleSubset lds = new LargestDivisibleSubset();
        int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println(lds.largestDivisibleSubset(nums));
    }
//    public  List<Integer> largestDivisibleSubset(int[] nums) {
//        List<Integer> res = new ArrayList<Integer>();
//        if (nums == null || nums.length == 0) return res;
//        Arrays.sort(nums);
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//
//        //for each element in nums, find the length of largest subset it has.
//        for (int i = 1; i < nums.length; i++){
//            for (int j = i-1; j >= 0; j--){
//                if (nums[i] % nums[j] == 0){
//                    dp[i] = Math.max(dp[i],dp[j] + 1);
//                }
//            }
//        }
//
//        //pick the index of the largest element in dp.
//        int maxIndex = 0;
//        for (int i = 1; i < nums.length; i++){
//            maxIndex = dp[i] > dp[maxIndex] ?  i :  maxIndex;
//        }
//
//        //from nums[maxIndex] to 0, add every element belongs to the largest subset.
//        int temp = nums[maxIndex];
//        int curDp = dp[maxIndex];
//        for (int i = maxIndex; i >= 0; i--){
//            if (temp % nums[i] == 0 && dp[i] == curDp){
//                res.add(nums[i]);
//                temp = nums[i];
//                curDp--;
//            }
//        }
//        return res;
//    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
