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
        System.out.println(sarii.checkRecord(3));

    }
//    利用dp[n][A][L]表示长度为n，包含A个字符'A'，以L个连续的'L'结尾的字符串的个数。
//
//    状态转移方程：
//
//    dp[n][0][0] = sum(dp[n - 1][0])
//    dp[n][0][1] = dp[n - 1][0][0]
//    dp[n][0][2] = dp[n - 1][0][1]
//    dp[n][1][0] = sum(dp[n - 1][0]) + sum(dp[n - 1][1])
//    dp[n][1][1] = dp[n - 1][1][0]
//    dp[n][1][2] = dp[n - 1][1][1]
//
//    初始令dp[1] = [[1, 1, 0], [1, 0, 0]]
//
//    由于dp[n]只和dp[n - 1]有关，因此上述转移方程可以使用滚动数组，将空间复杂度降低一维。
        final int MOD = 1000000007;
        public long sum(int[] nums) {
            long ans = 0;
            for (int n : nums) ans += n;
            return ans % MOD;
        }

        public int checkRecord(int n) {
            int dp[][] = {{1, 1, 0}, {1, 0, 0}};
            for (int i = 2; i <= n; i++) {
                int ndp[][] = {{0, 0, 0}, {0, 0, 0}};
                ndp[0][0] = (int)sum(dp[0]);
                ndp[0][1] = dp[0][0];
                ndp[0][2] = dp[0][1];
                ndp[1][0] = (int)((sum(dp[0]) + sum(dp[1])) % MOD);
                ndp[1][1] = dp[1][0];
                ndp[1][2] = dp[1][1];
                dp = ndp;
            }
            return (int)((sum(dp[0]) + sum(dp[1])) % MOD);
        }

}
