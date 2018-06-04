package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2018-6-4.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LargestPlusSign {
//    http://www.cnblogs.com/grandyang/p/8679286.html
//    可以对于每一个点，都计算好其上下左右连续1的个数。博主最先用的方法是建立四个方
//    向的dp数组，dp[i][j]表示 (i, j) 位置上该特定方向连续1的个数，那么就需要4个二
//    维dp数组，举个栗子，比如：
//
//    原数组：
//
//            1  0  1  0
//            1  1  1  1
//            1  0  1  1
//
//    那么我们建立left数组是当前及其左边连续1的个数，如下所示：
//
//            1  0  1  0
//            1  2  3  4
//            1  0  1  2
//
//    right数组是当前及其右边连续1的个数，如下所示：
//
//            1  0  1  0
//            4  3  2  1
//            1  0  2  1
//
//    up数组是当前及其上边连续1的个数，如下所示：
//
//            1  0  1  0
//            2  1  2  1
//            3  0  3  2
//
//    down数组是当前及其下边连续1的个数，如下所示：
//
//            3  0  3  0
//            2  1  2  2
//            1  0  1  1
//
//    我们需要做的是在这四个dp数组中的相同位置的四个值中取最小的一个，然后在所有的
//    这些去除的最小值中选最大一个返回即可。为了节省空间，我们不用四个二维dp数组，
//    而只用一个就可以了，因为对于每一个特定位置，我们只需要保留较小值，所以在更新
//    的时候，只需要跟原来值相比取较小值即可。在计算down数组的时候，我们就可以直接
//    更新结果res了，因为四个值都已经计算过了，我们就不用再重新在外面开for循环了，
//    参见代码如下：
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> banned = new HashSet();
        int[][] dp = new int[N][N];

        for (int[] mine: mines){
//            System.out.println("mine[0]:" + mine[0]);
//            System.out.println("mine[1]:" + mine[1]);
            banned.add(mine[0] * N + mine[1]);
        }
//        System.out.println("banned:" + banned);
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
        int[][] mines1 = new int[][]{{4, 2},{4,1}};
        int[][] mines2 = new int[][]{};
        int[][] mines3 = new int[][]{{0,0}};
        System.out.println(lps.orderOfLargestPlusSign(5,mines1));
        System.out.println(lps.orderOfLargestPlusSign(2,mines2));
        System.out.println(lps.orderOfLargestPlusSign(1,mines3));

    }
}
