package leetcode;

/**
 * Created by lyk on 2018-5-29.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FlippinganImage {
    public static void main(String[] args) {
        FlippinganImage fi = new FlippinganImage();
        int[][] a = new int[][]{
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        int[][] result = fi.flipAndInvertImage(a);
        for(int[] temp : result){
            for(int k : temp){
                System.out.print(k + "  ");
            }
            System.out.println();
        }
    }
    public int[][] flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }
}
