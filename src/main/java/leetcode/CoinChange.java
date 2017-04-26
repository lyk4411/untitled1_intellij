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
        if(amount==0) return 0;

        int[] dp = new int [amount+1];
        dp[0]=0; // do not need any coin to get 0 amount
        for(int i=1;i<=amount; i++)
            dp[i]= Integer.MAX_VALUE;

        for(int i=0; i<=amount; i++){
            for(int coin: coins){
                if(i+coin <=amount){
                    if(dp[i]==Integer.MAX_VALUE){
                        dp[i+coin] = dp[i+coin];
                    }else{
                        dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
                    }
                }
            }
        }

        if(dp[amount] >= Integer.MAX_VALUE)
            return -1;

        return dp[amount];
    }

}
