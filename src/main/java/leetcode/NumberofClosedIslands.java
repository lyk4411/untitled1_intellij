package leetcode;

/**
 * Created by lyk on 2020-1-10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberofClosedIslands {
    public int closedIsland(int[][] grid) {
        int res=0;
        for(int i=1; i<grid.length-1; i++){
            for(int j=1; j<grid[0].length-1; j++){
                if(grid[i][j]==0 && dfs(i,j,grid))
                    res++;
            }
        }
        return res;
    }
    boolean dfs(int i, int j, int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
            return false;

        if(grid[i][j]==1 || grid[i][j]==2)
            return true;
        grid[i][j]=2;
        boolean d = dfs(i+1, j, grid), u = dfs(i-1, j, grid),
                r = dfs(i, j+1, grid), l = dfs(i, j-1, grid);
        return d&&u&&r&&l;
    }

    public static void main(String[] args) {
        NumberofClosedIslands nci = new NumberofClosedIslands();
        int[][] g1 = new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        int[][] g2 = new int[][]{{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        int[][] g3 = new int[][]{{1,1,1,1,1,1,1},{1,0,0,0,0,0,1},{1,0,1,1,1,0,1},{1,0,1,0,1,0,1},{1,0,1,1,1,0,1},{1,0,0,0,0,0,1},{1,1,1,1,1,1,1}};
        System.out.println(nci.closedIsland(g1));
        System.out.println(nci.closedIsland(g2));
        System.out.println(nci.closedIsland(g3));
    }
}
