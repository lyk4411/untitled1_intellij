package leetcode;

/**
 * Created by lyk on 2018-7-6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class StrangePrinter {
//    public int strangePrinter(String s) {
//        int dp[][] = new int[110][110];
//        int n = s.length();
//        if(n == 0) return 0;
//        for(int[] t :dp) {
//            Arrays.fill(t, 0x3f3f3f3f);
//        }
//        for(int i = 0; i < n; ++i){
//            dp[i][i] = 1;
//        }
//        for(int p = 1; p < n; ++p){
//            for(int i = 0; i < n - p; ++i){
//                int j = i + p;
//                for (int k = i; k < j; ++k){
//                    int w = dp[i][k] + dp[k + 1][j];
//                    if (s.substring(i, i + 1).equals(s.substring(k + 1,k + 2))) --w; // 第一段的起点 和第二段的起点一样 执行--
//                    dp[i][j] = Math.min(dp[i][j], w);
//                }
//            }
//        }
//        return dp[0][n - 1];
//    }
    public int strangePrinter(String s) {
        int len = s.length();
        if(len <= 1) return len;
        int dp[][] = new int[100][100];
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                dp[i][j]= j - i + 1;
            }
        }
        for(int i = 1; i < len; i++){//间隔遍历
            for(int j = 0; j+i < len; j++){//层数遍历
                for(int k = j; k < j+i; k++){
                    int tem = dp[j][k] + dp[k + 1][j + i];
                    if(s.substring(k, k + 1).equals(s.substring(j + i, j + i + 1))) tem--;
                    dp[j][j+ i] = Math.min(dp[j][j + i], tem);
                }
            }
        }
        return dp[0][ len - 1];
    }


    public static void main(String[] args) {
        StrangePrinter sp = new StrangePrinter();
        System.out.println(sp.strangePrinter("aaabbb"));
        System.out.println(sp.strangePrinter("aba"));
        System.out.println(sp.strangePrinter("abc"));
    }
}
