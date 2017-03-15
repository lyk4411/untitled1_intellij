package leetcode;

/**
 * Created by lyk on 2017/3/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        SetMatrixZeroes smz = new SetMatrixZeroes();
        int[][] matrixs = new int[][]{{1,2,3},{4,0,6,},{7,8,0}};
        smz.setZeroes(matrixs);
        for (int i = 0; i < matrixs.length; i++) {
            for (int j = 0; j < matrixs[0].length; j++) {
                System.out.print(matrixs[i][j]);
            }
            System.out.println();
        }
    }
    public void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (fr) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
