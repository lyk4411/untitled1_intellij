package leetcode;

/**
 * Created by lyk on 2017/6/26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KInversePairsArray {
    public static void main(String[] args) {
        KInversePairsArray kipa = new KInversePairsArray();
        System.out.println(kipa.kInversePairs(10,4));
    }
    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n+1][k+1];

        for(int i=0; i<=n; i++)
            dp[i][0] = 1;

        for(int i=1; i<=n; i++)
            for(int j=1; j<=k; j++) {
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
                if(j-i >= 0) dp[i][j] -= dp[i-1][j-i];
                dp[i][j] += 1000000007;
                dp[i][j] %= 1000000007;
            }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j] + "  :");
//            }
//            System.out.println();
//        }

        return (int) dp[n][k];
    }
}
