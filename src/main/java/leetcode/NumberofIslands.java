package leetcode;

/**
 * Created by lyk on 2017/3/29.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberofIslands {
    public static void main(String[] args) {
        NumberofIslands nil = new NumberofIslands();
        char[][] grid = new char[][]{{'0','1','0','1'},
                {'0','0','0','0'},{'1','0','0','1'},{'0','1','0','1'}};
        System.out.println(nil.numIslands(grid));
    }
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if(n==0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1'){
                    DFS(grid,i,j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void DFS(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFS(grid,i + 1,j);
        DFS(grid,i - 1,j);
        DFS(grid,i,j + 1);
        DFS(grid,i,j - 1);
    }
}

