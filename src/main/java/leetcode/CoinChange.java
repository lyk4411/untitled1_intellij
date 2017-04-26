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
        if(amount<1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if(rem<0) return -1; // not valid
        if(rem==0) return 0; // completed
        if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, rem-coin, count);
            if(res>=0 && res < min)
                min = 1+res;
        }
        count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }

}
