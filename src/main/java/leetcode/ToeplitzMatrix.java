package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2018-4-18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap();
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (!groups.containsKey(r-c))
                    groups.put(r-c, matrix[r][c]);
                else if (groups.get(r-c) != matrix[r][c])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ToeplitzMatrix tm = new ToeplitzMatrix();
        int[][] matrix1 = new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };
        int[][] matrix2 = new int[][]{
                {1,2},
                {2,2}
        };
        System.out.println(tm.isToeplitzMatrix(matrix1));
        System.out.println(tm.isToeplitzMatrix(matrix2));
    }
}
