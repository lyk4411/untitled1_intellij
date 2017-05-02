package leetcode;

/**
 * Created by lyk on 2017/4/26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = new int[]{2,3,5};
        System.out.println(cc.coinChange(coins,17));
        System.out.println(cc.coinChange(coins,16));

    }

    public int coinChange(int[] coins, int amount) {
        // 无效输入的处理
        if (amount == 0)
            return 0;
        if (coins == null || coins.length == 0)
            return -1;

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1)
                    min = Math.min(min, dp[i - coins[j]] + 1);
            }

            // 根据min的值判断是否能兑换
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }

}
