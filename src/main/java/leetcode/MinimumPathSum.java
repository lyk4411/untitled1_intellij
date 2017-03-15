package leetcode;

/**
 * Created by lyk on 2017/3/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum mps = new MinimumPathSum();
        int[][] grids = new int[][]{{11,20,30,40,50,60,70},
                                    {10,11,11,20,30,40,10},
                                    {70,60,50,40,30,20,10},
                                    {22,22,54,31,2,21,31},
                                    {70,11,20,10,50,31,40},
                                    {10,21,31,40,40,50,60},
                                    {10,40,50,50,40,30,20}};
        System.out.println(mps.minPathSum(grids));
    }
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n]; //dp[i][j]表示从start到[i,j]位置不同路径条
        // 不需要初始化，默认初始化。
        //for(int i=0;i<m;i++)
        // for(int j=0;j<n;j++)
        //dp[i][j]=0;
        dp[0][0] = grid[0][0];
        for(int i=1;i<n;i++)   //第一行障碍处理
        {
            dp[0][i]=grid[0][i] + dp[0][i-1];
        }
        for(int j=1;j<m;j++)   //第一列障碍处理
        {
            dp[j][0]=grid[j][0] + dp[j-1][0];
        }

        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
            {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(" " + dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[m-1][n-1];
    }
}
