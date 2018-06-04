package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2018-6-4.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> banned = new HashSet();
        int[][] dp = new int[N][N];

        for (int[] mine: mines)
            banned.add(mine[0] * N + mine[1]);
        int ans = 0, count;

        for (int r = 0; r < N; ++r) {
            count = 0;
            for (int c = 0; c < N; ++c) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }

            count = 0;
            for (int c = N-1; c >= 0; --c) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }

        for (int c = 0; c < N; ++c) {
            count = 0;
            for (int r = 0; r < N; ++r) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }

            count = 0;
            for (int r = N-1; r >= 0; --r) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans, dp[r][c]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestPlusSign lps = new LargestPlusSign();
        int[][] mines1 = new int[][]{{4, 2}};
        int[][] mines2 = new int[][]{};
        int[][] mines3 = new int[][]{{0,0}};
        System.out.println(lps.orderOfLargestPlusSign(5,mines1));
        System.out.println(lps.orderOfLargestPlusSign(2,mines2));
        System.out.println(lps.orderOfLargestPlusSign(1,mines3));

    }
}
