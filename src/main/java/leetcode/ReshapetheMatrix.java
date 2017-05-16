package leetcode;

/**
 * Created by lyk on 2017/5/16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ReshapetheMatrix {
    public static void main(String[] args) {
        ReshapetheMatrix rm = new ReshapetheMatrix();
        int[][] nums = new int[][]{{1,2},{3,4}};
        int[][] resutl1 = rm.matrixReshape(nums,1,4);
        int[][] resutl2 = rm.matrixReshape(nums,4,1);
        for (int i = 0; i < resutl1.length; i++) {
            for (int j = 0; j < resutl1[i].length; j++) {
                System.out.print("resutl1[" + i +"][" + j + "]:" + resutl1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < resutl2.length; i++) {
            for (int j = 0; j < resutl2[i].length; j++) {
                System.out.print("resutl2[" + i +"][" + j + "]:" + resutl2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m) return nums;
        int[][] res = new int[r][c];
        for (int i=0;i<r*c;i++)
            res[i/c][i%c] = nums[i/m][i%m];
        return res;
    }
}
