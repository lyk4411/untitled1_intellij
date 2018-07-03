package leetcode;

/**
 * Created by lyk on 2018-7-2.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LargestSumofAverages {
//    https://www.jianshu.com/p/950a25796be3
//    思路
//
//    当看到Note里面A的lenth最大值是100的时候,这道题如果用dfs的话可能会超时(没有去试),用dp的话目测应
//    该需要三重循环,因此此时大概就会想到用dp[k][i]表示前i+1个元素(0~i)最多分k个组是平均数和最大,然后
//    就是自己手动写一个表可以简单推导一下.表格如下:
//
//            k\i   0 	    1 	    2 	    3 	    4
//            0 	9.00 	5.00 	4.00 	3.75 	4.80
//            1 	9.00 	10.00 	10.50 	11.00 	12.75
//            2 	9.00 	10.00 	12.00 	13.50 	20.00
//
//    自己认认真真打完表后很容易就可以dp的方程:
//    dp[k][i] = Math.max(dp[k - 1][i], dp[k - 1][j] + (sum[j + 1, i] / (i - j)); (k > = 1, sum[j + 1, i]
//    表示区间j+1到i中间所有数的和)
//    当然求区间和的话我们可以做一下预处理保证sum[j+1,i]是O(1)时间就可以.
//
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
