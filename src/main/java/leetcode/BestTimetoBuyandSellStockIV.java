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
//    //https://aaronice.gitbooks.io/lintcode/content/high_frequency/best_time_to_buy_and_sell_stock_iv.html
//    //对于局部变量的维护，递推式是
//    //local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
//    //也就是看两个量，第一个是全局到i-1天进行j-1次交易，然后加上今天的交易，
//    //如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天），
//    //第二个量则是取local第i-1天j次交易，然后加上今天的差值
//    //（这里因为local[i-1][j]比如包含第i-1天卖出的交易，所以现在变成第i天卖出，
//    //并不会增加交易次数，而且这里无论diff是不是大于0都一定要加上，因为否则就
//    //不满足local[i][j]必须在最后一天卖出的条件了）。
//    //局部（在第i天交易后，总共交易了j次） = max{情况2，情况1}
//    //情况1：在第i-1天时，恰好已经交易了j次（local[i-1][j]），那么如果i-1天到i天
//    //再交易一次：即在第i-1天买入，第i天卖出（diff），则这不并不会增加交易次数！
//    //【例如我在第一天买入，第二天卖出；然后第二天又买入，第三天再卖出的行为 和
//    //第一天买入，第三天卖出 的效果是一样的，其实只进行了一次交易！因为有连续性】
//    //情况2：第i-1天后，共交易了j-1次（global[i-1][j-1]），因此为了满足“第i天过
//    //后共进行了j次交易，且第i天必须进行交易”的条件：我们可以选择1：在第i-1天买入，
//    //然后再第i天卖出（diff），或者选择在第i天买入，然后同样在第i天卖出（收益为0）
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
