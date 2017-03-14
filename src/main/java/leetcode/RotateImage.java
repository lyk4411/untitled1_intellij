package leetcode;

/**
 * Created by lyk on 2017/3/14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RotateImage {
    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] matrixs = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        ri.rotate(matrixs);
        for (int i = 0; i < matrixs.length; i++) {
            for (int j = 0; j < matrixs[i].length; j++) {
                System.out.print(matrixs[i][j] + ":");
            }
            System.out.println();
        }
    }
    public void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
