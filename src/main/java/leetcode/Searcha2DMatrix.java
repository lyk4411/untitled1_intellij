package leetcode;

/**
 * Created by lyk on 2017/3/16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Searcha2DMatrix {
    public static void main(String[] args) {
        Searcha2DMatrix sm = new Searcha2DMatrix();
        int[][] matrixs = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int a = 5;
        int b = 10;
        System.out.println(sm.searchMatrix(matrixs,a));
        System.out.println(sm.searchMatrix(matrixs,b));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
