package leetcode;

/**
 * Created by lyk on 2018-7-2.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LargestSumofAverages {
    public double largestSumOfAverages(int[] A, int K) {
        int len = A.length;
        double[] pre = new double[len + 1];
        //区间和预处理 sum[i, j] = pre[j + 1] - pre[i]
        for (int i = 1; i <= len; ++i) {
            pre[i] = pre[i - 1] + A[i - 1];
        }
        double[][] dp = new double[K][len];
        for (int k = 0; k < K; ++k) {
            for (int i = 0; i < len; ++i) {
                dp[k][i] = k == 0 ? pre[i + 1]/(i + 1) : dp[k - 1][i];
                if (k > 0) {
                    for (int j = i - 1; j >= 0; --j) {
                        dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] + (pre[i + 1] - pre[j + 1]) / (i - j));
                    }
                }
            }
        }
        return dp[K - 1][len - 1];
    }

    public static void main(String[] args) {
        LargestSumofAverages lsa = new LargestSumofAverages();
        System.out.println(
                lsa.largestSumOfAverages(new int[]{9,1,2,3,9}, 3));
    }
}
