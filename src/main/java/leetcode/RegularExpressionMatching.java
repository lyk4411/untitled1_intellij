package leetcode;

/**
 * Created by lyk on 2017/6/30.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        System.out.println(rem.isMatch("aa","aaa"));
        System.out.println(rem.isMatch("aa","aa"));
        System.out.println(rem.isMatch("aa","ca*ab"));
        System.out.println(rem.isMatch("aa","ca."));
        System.out.println(rem.isMatch("aa",".."));
        System.out.println(rem.isMatch("aa",".*"));

    }
    //动态规划解
    //
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {//就算p.charAt(i-1) == s.charAt(i) 也可以：a* counts as empty
                        dp[i+1][j+1] = (dp[i+1][j] // in this case, a* counts as single a
                                || dp[i][j+1]      //in this case, a* counts as multiple a
                                || dp[i+1][j-1]);  // in this case, a* counts as empty
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }




    //递归解
//    public boolean isMatch(String s, String p) {
//        if (s == null)
//            return p == null;
//        if (p == null)
//            return s == null;
//
//        int lenS = s.length();
//        int lenP = p.length();
//
//        if (lenP == 0)
//            return lenS == 0;
//
//        if (lenP == 1) {
//            if (p.equals(s) || p.equals(".") && s.length() == 1) {
//                return true;
//            } else
//                return false;
//        }
//        if (p.charAt(1) != '*') {
//            if (s.length() > 0
//                    && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
//                return isMatch(s.substring(1), p.substring(1));
//            }
//            return false;
//        } else {
//            while (s.length() > 0
//                    && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
//                if (isMatch(s, p.substring(2)))
//                    return true;
//                s = s.substring(1);
//            }
//            return isMatch(s, p.substring(2));
//        }
//    }
}
