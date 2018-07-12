package leetcode;

/**
 * Created by lyk on 2018-7-6.
 * Package name: leetcode
 * Porject name: untitled1
 */


//        https://blog.csdn.net/biglethz/article/details/78036081
//解题思路：
//        1）对长度为Len的字符串，可以将其分解为两部分单独打印，安装切分点的不同，共有Len-1种组合，
//        所有组合中最小的打印次数即为该字符串的最少打印次数。对字符串的第i+1个字符到j+1个字符组成
//        的子串，用p(i,j)表示其最少打印次数，则本题的解为p(0,Len-1)，且有递推表达式
//        这里写图片描述
//        由于具有最优子结构的特点，显然可以用动态规划求解的，麻烦的捋清楚填表顺序。对字符串S的第i+1
//        个字符到第j+1个字符组成的子串，还是P(i,j)用表示其最少打印次数。以长度为4的字符串，演示填表
//        顺序
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
//                    int t = i + j;
//                    System.out.println("dp[" + j + "][" + j + " " + k  + " " + t + "]:" + dp[j][j+ i]);
                }
            }
        }
        return dp[0][ len - 1];
    }


    public static void main(String[] args) {
        StrangePrinter sp = new StrangePrinter();
        System.out.println(sp.strangePrinter("aaabbb"));
        System.out.println(sp.strangePrinter("aba"));
        System.out.println(sp.strangePrinter("abcd"));
    }
}
