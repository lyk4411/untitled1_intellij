package leetcode;

/**
 * Created by lyk on 2018-4-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[length];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();
        int[] cost1 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost2 = new int[]{10, 15, 20};
        System.out.println(mccs.minCostClimbingStairs(cost1));
        System.out.println(mccs.minCostClimbingStairs(cost2));
    }
}
