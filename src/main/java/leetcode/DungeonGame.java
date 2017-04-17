package leetcode;

/**
 * Created by lyk on 2017/4/17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DungeonGame {
    public static void main(String[] args) {
        DungeonGame dg = new DungeonGame();
        int[][] dungeons = new int[][]{
                {-2,-5,-7,-5,-1},
                {-6,-8,-8,-2,-9},
                {-4,-3,-4,-7,-7},
                {-3,-1,-2,-8,-6},
                {-2,-2,-9,-2,-7},};
        System.out.println(dg.calculateMinimumHP(dungeons));
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        //init dp table
        int[][] h = new int[m][n];

        h[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        //init last row
        for (int i = m - 2; i >= 0; i--) {
            h[i][n - 1] = Math.max(h[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        //init last column
        for (int j = n - 2; j >= 0; j--) {
            h[m - 1][j] = Math.max(h[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        //calculate dp table
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(h[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(h[i][j + 1] - dungeon[i][j], 1);
                h[i][j] = Math.min(right, down);
            }
        }

        return h[0][0];
    }
}
