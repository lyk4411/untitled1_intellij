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
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] memo = new int[n][n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dp(grid, memo, n - 1, n - 1, n - 1));

    }

    private int dp(int[][] grid, int[][][] memo, int x1, int y1, int x2) {
        int y2 = x1 + y1 - x2;
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) return -1;
        if (grid[y1][x1] < 0 || grid[y2][x2] < 0) return -1;
        if (x1 == 0 && y1 == 0) return grid[y1][x1];
        if (memo[x1][y1][x2] != Integer.MIN_VALUE) return memo[x1][y1][x2];
        int ans =  Math.max(Math.max(dp(grid, memo,x1 - 1, y1, x2 - 1), dp(grid, memo,x1, y1 - 1, x2)),
                Math.max(dp(grid, memo,x1, y1 - 1, x2 - 1), dp(grid, memo,x1 - 1, y1, x2)));
        if (ans < 0) return memo[x1][y1][x2] = -1;
        ans += grid[y1][x1];
        if (x1 != x2) ans += grid[y2][x2];
        return memo[x1][y1][x2] = ans;
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
        int[][] g4 = new int[][]{
                {0, 1, -1},
                {1, -1, -1},
                {-1, 1,  1},
        };
        int[][] g5 = new int[][]{
                {1,   1,  1, 1, 1},
                {1,   1, -1, 1, 1},
                {-1, -1,  1, 1, 1},
                {1,   1,  1, 1, 1},
                {-1,  1,  1, 1, 1}
        };

        CherryPickup cp = new CherryPickup();
        System.out.println(cp.cherryPickup(g1));
        System.out.println(cp.cherryPickup(g2));
        System.out.println(cp.cherryPickup(g3));
        System.out.println(cp.cherryPickup(g4));
        System.out.println(cp.cherryPickup(g5));
    }
}
