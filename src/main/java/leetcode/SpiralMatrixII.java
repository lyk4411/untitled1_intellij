package leetcode;

/**
 * Created by lyk on 2017/3/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        SpiralMatrixII smii = new SpiralMatrixII();
        int[][] a = smii.generateMatrix(4);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int left = 0,top = 0;
        int right = n -1,down = n - 1;
        int count = 1;
        while (left <= right) {
            for (int j = left; j <= right; j ++) {
                ret[top][j] = count++;
            }
            top ++;
            for (int i = top; i <= down; i ++) {
                ret[i][right] = count ++;
            }
            right --;
            for (int j = right; j >= left; j --) {
                ret[down][j] = count ++;
            }
            down --;
            for (int i = down; i >= top; i --) {
                ret[i][left] = count ++;
            }
            left ++;
        }
        return ret;
    }
}
