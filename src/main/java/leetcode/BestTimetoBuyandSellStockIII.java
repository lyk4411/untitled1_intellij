package leetcode;

/**
 * Created by lyk on 2017/3/9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockIII btbssiii = new BestTimetoBuyandSellStockIII();
        int[] prices = new int[]{1,2,3,4,5,6,7,8,9,1,2,3,2,1,2,3,4,5};
        System.out.println(btbssiii.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        //highest profit in 0 ... i
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        // DP from left to right
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        for (int i = 0; i < left.length; i++) {
            System.out.print(left[i] + " : ");
        }
        System.out.println();

        // DP from right to left
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        for (int i = 0; i < right.length; i++) {
            System.out.print(right[i] + " : ");
        }
        System.out.println();


        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }

        return profit;
    }
}
