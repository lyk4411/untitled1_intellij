package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/3/25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(12));
        //System.out.println(ps.numSquares(123));
        //System.out.println(ps.numSquares(1230));

    }
    public int numSquares(int n) {
        int max = (int) Math.sqrt(n);

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);


        for(int i=1; i<=n; i++){
            for(int j=1; j<=max; j++){
                if(i==j*j){
                    dp[i]=1;
                }else if(i>j*j){
                    dp[i]=Math.min(dp[i], dp[i-j*j] + 1);
//                    dp[i]=dp[i-j*j] + 1;
//                    if(i==12){
//                        System.out.println(dp[12]);
//                    }
                }
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.print(dp[i] + ":");
//        }
//        System.out.println();

        return dp[n];
    }
}
