package leetcode;

/**
 * Created by lyk on 2017/3/2.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class UniquePaths {
    public static  void  main(String[] args){
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(2,2));
    }

    public int uniquePaths(int m, int n) {
        // DP with 2 dimensions array
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            a[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            a[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] = a[i-1][j] + a[i][j-1];
            }
        }

//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[0].length; j++) {
//                System.out.println("a[" + i + "][" + j + "]:" + a[i][j]);
//            }
//        }
        return a[m-1][n-1];
    }
}
