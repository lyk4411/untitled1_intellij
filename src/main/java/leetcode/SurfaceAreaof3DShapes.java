package leetcode;


/**
 * Created by lyk on 2018-9-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SurfaceAreaof3DShapes {
    public int surfaceArea(int[][] grid) {
        int N = grid.length;
        int ans = 0;

        for (int r = 0; r <= N - 1; ++r){
            for (int c = 0; c <= N - 1; ++c) {
                if (grid[r][c] > 0) {
                    ans += 2 + grid[r][c] * 4;
                }
                if(r > 0) {
                    ans -= Math.min(grid[r][c], grid[r - 1][c]) * 2;
                }
                if(c > 0) {
                    ans -= Math.min(grid[r][c], grid[r][c - 1]) * 2;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SurfaceAreaof3DShapes sas = new SurfaceAreaof3DShapes();
        int[][] grid1 = new int[][]{{2}};
        int[][] grid2 = new int[][]{{1, 2}, {3, 4}};
        int[][] grid3 = new int[][]{{1, 0}, {0, 2}};
        int[][] grid4 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] grid5 = new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};

        System.out.println(sas.surfaceArea(grid1));
        System.out.println(sas.surfaceArea(grid2));
        System.out.println(sas.surfaceArea(grid3));
        System.out.println(sas.surfaceArea(grid4));
        System.out.println(sas.surfaceArea(grid5));
    }
}
