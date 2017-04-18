package leetcode;

import java.util.TreeSet;

/**
 * Created by lyk on 2017/4/18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaxSumofRectangleNoLargerThanK {
    public static void main(String[] args) {
        MaxSumofRectangleNoLargerThanK msrnlt = new MaxSumofRectangleNoLargerThanK();
        int[][] matrixes = new int[][]{
                {1, 0, 1, -2, 3},
                {-1, 1, 1, 2, -3},
                {1, 1, -1, 2, -3},
                {6, -2, 1, -2, -1},
                {1, -2, -1, 2, 3},
        };
        System.out.println(msrnlt.maxSumSubmatrix(matrixes,4));
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int global = Integer.MIN_VALUE;
        // m >> n
        for(int j = 0; j < n; j++) {
            int[] col = new int[m];
            for(int p = j; p < n; p++) {
                // cumulative sum
                for(int i = 0; i < m; i++) col[i] += matrix[i][p];
                // maximum array sum < k
                TreeSet<Integer> set = new TreeSet();
                // include 1 line
                set.add(0);
                int prefixSum = 0, local = Integer.MIN_VALUE;
                for(int sum : col) {
                    prefixSum += sum;
                    // upper_bound
                    Integer cum = set.ceiling(prefixSum - k);
                    if(cum != null) local = Math.max(local, prefixSum - cum);
                    set.add(prefixSum);
                }
                global = Math.max(global, local);
            }
        }

        return global;
    }
}
