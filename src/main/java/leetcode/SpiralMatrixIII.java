package leetcode;

/**
 * Created by lyk on 2018-9-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int[][] ans = new int[R*C][2];
        int t = 0;

        ans[t++] = new int[]{r0, c0};
        if (R * C == 1) return ans;

        for (int k = 1; k < 2*(R+C); k += 2)
            for (int i = 0; i < 4; ++i) {  // i: direction index
                int dk = k + (i / 2);  // number of steps in this direction
                for (int j = 0; j < dk; ++j) {  // for each step in this direction...
                    // step in the i-th direction
                    r0 += dr[i];
                    c0 += dc[i];
                    if (0 <= r0 && r0 < R && 0 <= c0 && c0 < C) {
                        ans[t++] = new int[]{r0, c0};
                        if (t == R * C) return ans;
                    }
                }
            }

        throw null;
    }

    public static void main(String[] args) {
        SpiralMatrixIII smiii = new SpiralMatrixIII();
        int[][] result1 = smiii.spiralMatrixIII(1, 4, 0, 0);
        int[][] result2 = smiii.spiralMatrixIII(5, 6, 1, 4);
        for(int[] temp: result1){
            System.out.print("(");
            for(int i : temp){
                System.out.print(i + " , ");
            }
            System.out.print("), ");
        }
        System.out.println();
        for(int[] temp: result2){
            System.out.print("(");
            for(int i : temp){
                System.out.print(i + " , ");
            }
            System.out.print("), ");
        }
        System.out.println();
    }
}
