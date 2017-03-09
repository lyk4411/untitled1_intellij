package leetcode;

/**
 * Created by lyk on 2017/3/9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        IslandPerimeter ip = new IslandPerimeter();
        int[][] grids = new int[][]{{1,1,1,0},{0,0,0,0},{1,1,1,1},{0,1,0,1}};
        System.out.println(ip.islandPerimeter(grids));
    }
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}
