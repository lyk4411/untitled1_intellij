package leetcode;

/**
 * Created by lyk on 2017/5/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class StudentAttendanceRecordII {
    public static void main(String[] args) {
        StudentAttendanceRecordII sarii = new StudentAttendanceRecordII();
        System.out.println(sarii.checkRecord(2));
        //System.out.println(sarii.checkRecord(3));
    }

    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] f = new int[n + 1][2][3];

        f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                for (int k = 0; k < f[0][0].length; k++) {
                    System.out.print("i:" + i + " j:" + j  + " k:" + k + " f[i][j][k]:" +  f[i][j][k] + "  " );
                }
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++) {
                    int val = f[i - 1][j][2]; // ...P
                    if (j > 0) val = (val + f[i - 1][j - 1][2]) % MOD; // ...A
                    if (k > 0) val = (val + f[i - 1][j][k - 1]) % MOD; // ...L
                    f[i][j][k] = val;
                }
        return f[n][1][2];
    }
}
