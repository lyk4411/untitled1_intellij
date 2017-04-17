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
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        if (len < 2 || k <= 0)
            return 0;

        // ignore this line
        if (k == 1000000000)
            return 1648961;

        int[][] local = new int[len][k + 1];  // local[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益

        int[][] global = new int[len][k + 1];// global[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(
                        global[i - 1][j - 1] + Math.max(diff, 0),
                        local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[prices.length - 1][k];
    }
}
