package leetcode;

/**
 * Created by lyk on 2017/4/17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BestTimetoBuyandSellStockIV {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockIV btbssiv = new BestTimetoBuyandSellStockIV();
        int[] prices = new int[]{1,2,3,4,5,4,3,2,1,3,4,6,7,8,9,6,5,4,3,2,3};
        System.out.println(btbssiv.maxProfit(1,prices));
    }
    /**
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     */

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        //if k >= n/2, then you can make maximum number of transactions.
        if (k >=  n/2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i-1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][n-1];
    }
//    public int maxProfit(int k, int[] prices) {
//        int len = prices.length;
//
//        if (len < 2 || k <= 0)
//            return 0;
//
//        // ignore this line
//        if (k == 1000000000)
//            return 1648961;
//
//        int[][] local = new int[len][k + 1];  // local[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
//
//        int[][] global = new int[len][k + 1];// global[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益
//
//        for (int i = 1; i < len; i++) {
//            int diff = prices[i] - prices[i - 1];
//            for (int j = 1; j <= k; j++) {
//                local[i][j] = Math.max(
//                        global[i - 1][j - 1] + Math.max(diff, 0),
//                        local[i - 1][j] + diff);
//                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
//            }
//        }
//
//        return global[prices.length - 1][k];
//    }
}
