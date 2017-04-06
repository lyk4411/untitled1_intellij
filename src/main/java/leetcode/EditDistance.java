package leetcode;

/**
 * Created by lyk on 2017/4/5.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class EditDistance {
    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("abcdafdafahk","iiiiabcdaf"));

    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化空字符串的情况
        for(int i = 1; i <= m; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= n; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                // 增加操作：str1a变成str2后再加上b，得到str2b
                int insertion = dp[i][j-1] + 1;
                // 删除操作：str1a删除a后，再由str1变为str2b
                int deletion = dp[i-1][j] + 1;
                // 替换操作：先由str1变为str2，然后str1a的a替换为b，得到str2b
                int replace = dp[i-1][j-1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                // 三者取最小
                dp[i][j] = Math.min(replace, Math.min(insertion, deletion));
            }
        }
        return dp[m][n];
    }
//    public static int minDistance(String word1, String word2) {
//        int len1 = word1.length();
//        int len2 = word2.length();
//
//        // len1+1, len2+1, because finally return dp[len1][len2]
//        int[][] dp = new int[len1 + 1][len2 + 1];
//
//        for (int i = 0; i <= len1; i++) {
//            dp[i][0] = i;
//        }
//
//        for (int j = 0; j <= len2; j++) {
//            dp[0][j] = j;
//        }
//
//        //iterate though, and check last char
//        for (int i = 0; i < len1; i++) {
//            char c1 = word1.charAt(i);
//            for (int j = 0; j < len2; j++) {
//                char c2 = word2.charAt(j);
//
//                //if last two chars equal
//                if (c1 == c2) {
//                    //update dp value for +1 length
//                    dp[i + 1][j + 1] = dp[i][j];
//                } else {
//                    int replace = dp[i][j] + 1;
//                    int insert = dp[i][j + 1] + 1;
//                    int delete = dp[i + 1][j] + 1;
//
//                    int min = replace > insert ? insert : replace;
//                    min = delete > min ? min : delete;
//                    dp[i + 1][j + 1] = min;
//                }
//            }
//        }
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j] + "  ");
//            }
//            System.out.println();
//        }
//        return dp[len1][len2];
//    }
}
