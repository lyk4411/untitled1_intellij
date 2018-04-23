package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2018-4-23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximumLengthofPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int N = pairs.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int j = 1; j < N; ++j) {
            for (int i = 0; i < j; ++i) {
                if (pairs[i][1] < pairs[j][0])
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }

        int ans = 0;
        for (int x: dp) if (x > ans) ans = x;
        return ans;
    }

    public static void main(String[] args) {
        MaximumLengthofPairChain mlpc = new MaximumLengthofPairChain();
        int[][] pairs = new int[][]{
                {1,2},
                {2,3},
                {3,4}
        };
        System.out.println(mlpc.findLongestChain(pairs));
    }
}
