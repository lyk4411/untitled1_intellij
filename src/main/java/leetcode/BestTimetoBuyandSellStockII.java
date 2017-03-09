package leetcode;

/**
 * Created by lyk on 2017/3/9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockII btbssii = new BestTimetoBuyandSellStockII();
        int[] prices = new int[]{1,2,3,4,5,6,7,8,9,1,2,3,2,1,2,3,4,5};
        System.out.println(btbssii.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }
}