package leetcode;

/**
 * Created by lyk on 2017/5/24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.longestPalindromeSubseq("abcdedcbaaa"));
    }

//    dp[i][j]: the longest palindromic subsequence's length of substring(i, j)
//    State transition:
//    dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
//    otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
//    Initialization: dp[i][i] = 1
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " : ");
            }
            System.out.println();
        }
        return dp[0][s.length()-1];
    }
}
