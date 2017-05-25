package leetcode;

/**
 * Created by lyk on 2017/5/25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Searcha2DMatrixII {
    public static void main(String[] args) {
        Searcha2DMatrixII smii = new Searcha2DMatrixII();
        int[][] matrix = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(smii.searchMatrix(matrix,5));
        System.out.println(smii.searchMatrix(matrix,19));
        System.out.println(smii.searchMatrix(matrix,20));
        System.out.println(smii.searchMatrix(matrix,26));
        System.out.println(smii.searchMatrix(matrix,27));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
