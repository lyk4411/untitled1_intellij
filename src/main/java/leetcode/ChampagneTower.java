package leetcode;

/**
 * Created by lyk on 2018-6-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] A = new double[102][102];
        A[0][0] = (double) poured;
        for (int r = 0; r <= query_row; ++r) {
            for (int c = 0; c <= r; ++c) {
                double q = (A[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    A[r+1][c] += q;
                    A[r+1][c+1] += q;
                }
            }
        }

        return Math.min(1, A[query_row][query_glass]);
    }

    public static void main(String[] args) {
        ChampagneTower ct = new ChampagneTower();
        System.out.println(ct.champagneTower(10,3,1));
        System.out.println(ct.champagneTower(100,8,1));
    }
}
