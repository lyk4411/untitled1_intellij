package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2018-7-26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CherryPickup {
//    首先我们知道，正反两次走，等价于分别做两次正着走。问题就变成分别走两次找最大收益，其中第一次走过的1会变成0。
//    然后我们进一步，简化理解，可以是2个人同时正着走，且速度一样，希望两人总体的收益最大，如果它们同时走到一个格
//    子上，那它们只能拿一次。可以简单理解一下为什么这个问题，和刚才的问题等价：设速度都是1，则第t个时刻，设第一个
//    人走到(x1, y1)，第二个人走到(x2, y2)，那么一定有x1 + y1 = t，x2 + y2 = t，假如x1 != x2，那么这一次行程中，第
//    一个人永远不会走到(x2, y2)，同理第二人永远不会走到(x1, y1)。因此，拿重的问题只会在它们同时走到一个格子的时候
//    遇到，因此我们判断他们每个时刻是否会到达同一个格子就可以去重了。
//    把这个思想转换成dp的状态，则可以表示为dp(t, x1, x2)，也就是第t时刻第一个人走到(x1, t - x1)，第二个人走到
//    (x2, t - x2)时两人的最大收益。
//    状态转移也非常简单：
//    dp(t, x1, x2) = grid(x1, t - x1) + (x1 == x2 ? 0 : grid(x2, t - x2)) +
//              max(dp(t-1, x1, x2), dp(t - 1, x1, x2 - 1), dp(t - 1, x1 - 1, x2), dp(t - 1, x1 - 1, x2 - 1))
//    最后就是t这一维我们可以通过滚动数组压掉，注意这样的话需要反向遍历更新dp
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }
        dp[0][0] = grid[0][0];
        for (int k = 1; k < (n << 1) - 1; k++){
            for (int i = Math.min(n - 1, k); i >= 0 && i >= k - n + 1; i--){
                for (int j = Math.min(n - 1, k); j >= 0 && j >= k - n + 1; j--){
                    int p = k - i, q = k - j;
                    if (grid[i][p] == -1  || grid[j][q] == -1){
                        dp[i][j] = -1;
                        continue;
                    }
                    if (p > 0 && j > 0){
                        dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                    }
                    if (i > 0){
                        if (j > 0)
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);
                        if (q > 0)
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                    }
                    if (dp[i][j] == -1)
                        continue;
                    if (i == j)
                        dp[i][j] += grid[i][p];
                    else
                        dp[i][j] += grid[i][p] + grid[j][q];
                }
            }
        }
        return Math.max(dp[n-1][n-1], 0);
    }


    public static void main(String[] args) {
        int[][] g1 = new int[][]{
                {1, 1},
                {1, 1}
        };
        int[][] g2 = new int[][]{
                {0, 1, -1},
                {1, 0, -1},
                {1, 1,  1},
        };
        int[][] g3 = new int[][]{
                {1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1}
        };
        CherryPickup cp = new CherryPickup();
        System.out.println(cp.cherryPickup(g1));
        System.out.println(cp.cherryPickup(g2));
        System.out.println(cp.cherryPickup(g3));
    }
}
