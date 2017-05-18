package leetcode;

/**
 * Created by lyk on 2017/5/18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PredicttheWinner {
    public static void main(String[] args) {
        PredicttheWinner pw = new PredicttheWinner();
        int[] nums1 = new int[]{1,4,77,5};
        int[] nums2 = new int[]{1,9,5};
        System.out.println(pw.PredictTheWinner(nums1));
        System.out.println(pw.PredictTheWinner(nums2));
    }

    //动态规划解决～建立dp[len][len]数组，dp[i][j]表示
    // nums数组中i～j下标间player1能够获得的分数-player2能够获得的分数
    // ～最后dp[0][len-1]的正负性即可表明player1是否能赢～

    //dp[0][len-1]的值通过递归动态规划可得：func(begin, end)返回dp[begin][end]的值，
    // 当begin和end相等的时候，dp[begin][end]的值即为nums[begin]（或者nums[end]），
    // 如果begin和end不等，那么如果取begin，结果为nums[begin] – dp[begin+1][end];
    // 如果取end，结果为nums[end] – dp[begin][end-1]，
    // dp[begin][end]取它俩中较大的一个～

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
