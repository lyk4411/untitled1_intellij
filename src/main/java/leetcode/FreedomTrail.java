package leetcode;

/**
 * Created by lyk on 2017/7/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FreedomTrail {
    public static void main(String[] args) {
        FreedomTrail ft = new FreedomTrail();
        String ring = new String("godding");
        System.out.println(ft.findRotateSteps(ring,"gd"));
        System.out.println(ft.findRotateSteps(ring,"gdg"));

    }
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];
        //dp[i][j] 表示key中第i个字条，ring中第j个字符在12点时，所需的最小步数。
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }
        //倒序，所以是dp[0][0]
        return dp[0][0] + m;
    }
}
