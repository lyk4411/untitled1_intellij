package leetcode;

/**
 * Created by lyk on 2017/3/29.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] nums = new int[]{1,2,3,4,5,6,5,4,3,4,6,8,3,6,9,2};
        System.out.println(hr.rob(nums));
    }

    public int rob(int[] num) {
        if(num == null || num.length == 0) return 0;
        if(num.length == 1) return num[0];
        int[] dp = new int[num.length];
        dp[0] = num[0];
        dp[1] = Math.max(num[0],num[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(num[i] + dp[i-2],dp[i-1]);
        }
        return dp[num.length -1];
    }
}
