package leetcode;

/**
 * Created by lyk on 2017/3/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class UniquePathsII {
    public static void main(String[] args) {
        UniquePathsII upii = new UniquePathsII();
        int[][] obstacleGrids = new int[][]{{0,0,0,0,0,0,0},
                                            {0,1,1,0,0,0,0},
                                            {0,0,0,0,0,0,0},
                                            {0,0,0,0,0,0,0},
                                            {0,1,0,0,0,1,0},
                                            {0,1,1,0,0,0,0},
                                            {0,0,0,0,0,0,0}};
        System.out.println(upii.uniquePathsWithObstacles(obstacleGrids));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0)
            return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n]; //dp[i][j]表示从start到[i,j]位置不同路径条
        // 不需要初始化，默认初始化。
        //for(int i=0;i<m;i++)
        // for(int j=0;j<n;j++)
        //dp[i][j]=0;
        for(int i=0;i<n;i++)   //第一行障碍处理
        {
            if(obstacleGrid[0][i]!=1)
                dp[0][i]=1;
            else
                break;
        }

        for(int j=0;j<m;j++)   //第一列障碍处理
        {
            if(obstacleGrid[j][0]!=1)
                dp[j][0]=1;
            else
                break;
        }
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]==1)   //如果该位置是障碍，则到达该点的路径条数为0
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
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
