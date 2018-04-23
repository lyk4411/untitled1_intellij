package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-4-23.
 * Package name: leetcode
 * Porject name: untitled1
 */
//        Intuition
//
//          If a chain of length k ends at some pairs[i], and pairs[i][1] < pairs[j][0],
//          we can extend this chain to a chain of length k+1.
//        Algorithm
//
//          Sort the pairs by first coordinate, and let dp[i] be the length of the
//          longest chain ending at pairs[i]. When i < j and pairs[i][1] < pairs[j][0],
//          we can extend the chain, and so we have the candidate
//          answer dp[j] = max(dp[j], dp[i] + 1).
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
        return IntStream.of(dp).max().getAsInt();
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
