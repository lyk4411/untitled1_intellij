package leetcode;

/**
 * Created by lyk on 2017/6/12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DeleteOperationforTwoStrings {
    public static void main(String[] args) {
        DeleteOperationforTwoStrings dots = new DeleteOperationforTwoStrings();
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(dots.minDistance(word1,word2));
    }
    //Since the only operation allowed is deletion, this problem actually
    // becomes finding the longest common subsequence.
//    public int minDistance(String word1, String word2) {
//        int dp[][] = new int[word1.length()+1][word2.length()+1];
//        for(int i = 0; i <= word1.length(); i++) {
//            for(int j = 0; j <= word2.length(); j++) {
//                if(i == 0 || j == 0) dp[i][j] = 0;
//                else dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1)) ? dp[i-1][j-1] + 1
//                        : Math.max(dp[i-1][j], dp[i][j-1]);
//            }
//        }
//        int val =  dp[word1.length()][word2.length()];
//        return word1.length() - val + word2.length() - val;
//    }


    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;

        // dp[i][j] stands for distance of first i chars of word1 and first j chars of word2
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
            dp[i][0] = i;
        for (int j = 0; j <= len2; j++)
            dp[0][j] = j;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + 2, dp[i - 1][j] + 1), dp[i][j - 1] + 1);
            }
        }

        return dp[len1][len2];
    }
}
