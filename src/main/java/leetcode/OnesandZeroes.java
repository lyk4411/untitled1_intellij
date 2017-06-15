package leetcode;

/**
 * Created by lyk on 2017/6/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class OnesandZeroes {
    public static void main(String[] args) {
        OnesandZeroes oz = new OnesandZeroes();
        String[] strs1 = new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(oz.findMaxForm(strs1,5,4));
        System.out.println(oz.findMaxForm(strs1,5,1));
    }
    // 我们建立一个二位的DP数组，其中dp[i][j]表示有i个0和j个1时能组成的最
    // 多字符串的个数，而对于当前遍历到的字符串，我们统计出其中0和1的个数为
    // zeros和ones，然后dp[i - zeros][j - ones]表示当前的i和j减去zeros和ones
    // 之前能拼成字符串的个数，那么加上当前的zeros和ones就是当前dp[i][j]可以
    // 达到的个数，我们跟其原有数值对比取较大值即可，所以递推式如下：

    // dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1);
    // 有了递推式，我们就可以很容易的写出代码如下：
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s : strs) {
            int[] count = count(s);
            for (int i=m;i>=count[0];i--)
                for (int j=n;j>=count[1];j--)
                    dp[i][j] = Math.max(1 + dp[i-count[0]][j-count[1]], dp[i][j]);
        }
        return dp[m][n];
    }

    public int[] count(String str) {
        int[] res = new int[2];
        for (int i=0;i<str.length();i++)
            res[str.charAt(i) - '0']++;
        return res;
    }
}

