package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/7/14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class OutofBoundaryPaths {
    public static void main(String[] args) {
        OutofBoundaryPaths obp = new OutofBoundaryPaths();
        System.out.println(obp.findPaths(2,2,3,1,1));
    }

    int M=1000000007;
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] memo=new int[m][n][N+1];
        for(int[][] l:memo)
            for(int[] sl:l)
                Arrays.fill(sl,-3);
        return findPaths(m,n,N,i,j,memo);
    }
    public int findPaths(int m, int n, int N, int i, int j,int[][][] memo) {
        if(i==m || j==n || i<0 ||j<0)
            return 1;
        if(N==0)
            return 0;
        if(memo[i][j][N]>=0)
            return memo[i][j][N];
        memo[i][j][N]=((findPaths(m,n,N-1,i-1,j,memo)+findPaths(m,n,N-1,i+1,j,memo))%M+
                (findPaths(m,n,N-1,i,j-1,memo)+findPaths(m,n,N-1,i,j+1,memo))%M)%M;
        return memo[i][j][N];
    }


}
