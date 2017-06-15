package leetcode;

/**
 * Created by lyk on 2017/6/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BurstBalloons {
    public static void main(String[] args) {
        BurstBalloons bb = new BurstBalloons();
        int[] nums1 = new int[]{1,3,5,8};
        int[] nums2 = new int[]{3,1,5,8};
        System.out.println(bb.maxCoins(nums1));
        System.out.println(bb.maxCoins(nums2));
    }
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}
