package leetcode;

/**
 * Created by lyk on 2018-8-24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ProjectionAreaof3DShapes {
    public int projectionArea(int[][] grid) {
        int N = grid.length;
        int ans = 0;

        for (int i = 0; i < N;  ++i) {
            int bestRow = 0;  // largest of grid[i][j]
            int bestCol = 0;  // largest of grid[j][i]
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] > 0) ans++;  // top shadow
                bestRow = Math.max(bestRow, grid[i][j]);
                bestCol = Math.max(bestCol, grid[j][i]);
            }
            ans += bestRow + bestCol;
        }

        return ans;
    }

    public static void main(String[] args) {
        ProjectionAreaof3DShapes pas = new ProjectionAreaof3DShapes();
        int[][] grid1 = new int[][]{
                {2}
        };
        int[][] grid2 = new int[][]{
                {1,2},{3,4}
        };
        int[][] grid3 = new int[][]{
                {1,0},{0,2}
        };
        System.out.println(pas.projectionArea(grid1));
        System.out.println(pas.projectionArea(grid2));
        System.out.println(pas.projectionArea(grid3));
    }
}
