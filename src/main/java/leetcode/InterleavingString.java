package leetcode;

/**
 * Created by lyk on 2017/4/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class InterleavingString {
    public static void main(String[] args) {
        InterleavingString is = new InterleavingString();
        System.out.println(is.isInterleave("abc","def","adbecf"));
        //System.out.println(is.isInterleave("abc","def","acdebf"));
    }

//    http://blog.csdn.net/u011095253/article/details/9248073
//    DP解法：
//    关于DP里矩阵每一个格子所代表的意义看下面这一个图
//    （以下描述为 1 base）
//    dp[i][j]表示s1取前i位，s2取前j位，是否能组成s3的前i+j位
//    举个列子，注意左上角那一对箭头指向的格子dp[1][1], 表示s1取第1位a, s2取第1位d，是否能组成s3的前两位aa
//    从dp[0][1] 往下的箭头表示，s1目前取了0位，s2目前取了1位，我们添加s1的第1位，看看它是不是等于s3的第2位，( i + j 位）
//    从dp[1][0] 往右的箭头表示，s1目前取了1位，s2目前取了0位，我们添加s2的第1位，看看它是不是等于s3的第2位，( i + j 位)
//
//    那什么时候取True，什么时候取False呢？
//    False很直观，如果不等就是False了嘛。
//    那True呢？首先第一个条件，新添加的字符，要等于s3里面对应的位( i + j 位)，第二个条件，之前那个格子也要等于True
//            举个简单的例子s1 = ab, s2 = c, s3 = bbc ，假设s1已经取了2位，c还没取，此时是False（ab!=bb），我们取s2的新的一位c，即便和s3中的c相等，但是之前是False，所以这一位也是False
//    同理，如果s1 = ab, s2 = c, s3=abc ，同样的假设，s1取了2位，c还没取，此时是True（ab==ab），我们取s2的新的一位c,和s3中的c相等，且之前这一位就是True，此时我们可以放心置True （abc==abc）
//
//    还有一点需要注意的是，String 的index是0 base的, 我们以dp[m+1][n+1] 正序遍历字符创造的矩阵是1 base的


//    地图上往左一步就是s2[j-1]匹配s3[i+j-1]。
//    地图上往上一步就是s1[i-1]匹配s3[i+j-1]。

    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length()+s2.length())!=s3.length())
            return false;

        boolean[][] matrix = new boolean[s2.length()+1][s1.length()+1];

        matrix[0][0] = true;

        for (int i = 1; i < matrix[0].length; i++){
            matrix[0][i] = matrix[0][i-1]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }

        for (int i = 1; i < matrix.length; i++){
            matrix[i][0] = matrix[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                matrix[i][j] = (matrix[i-1][j]&&(s2.charAt(i-1)==s3.charAt(i+j-1)))
                        || (matrix[i][j-1]&&(s1.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }

        return matrix[s2.length()][s1.length()];
    }



//    public boolean isInterleave(String s1, String s2, String s3) {
//        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
//        int m = s1.length(), n = s2.length();
//        if(m + n != s3.length()) return false;
//        return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
//    }
//
//    public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
//        if(invalid[i][j]) return false;
//        if(k == c3.length) return true;
//        boolean valid =
//                i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) ||
//                        j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
//        if(!valid) invalid[i][j] = true;
//        return valid;
//    }




////递归解法，好理解，但超时
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1.length()+s2.length()!=s3.length()) return false;
//        return rec(s1,0,s2,0,s3,0);
//    }
//
//    public boolean rec(String s1, int p1, String s2, int p2, String s3, int p3){
//        if (p3==s3.length()) return true;
//        if (p1==s1.length()) return s2.substring(p2).equals(s3.substring(p3));
//        if (p2==s2.length()) return s1.substring(p1).equals(s3.substring(p3));
//        if (s1.charAt(p1)==s3.charAt(p3)&&s2.charAt(p2)==s3.charAt(p3))
//            return rec(s1,p1+1,s2,p2,s3,p3+1) || rec(s1,p1,s2,p2+1,s3,p3+1);
//        else if (s1.charAt(p1)==s3.charAt(p3))
//            return rec(s1,p1+1,s2,p2,s3,p3+1);
//        else if (s2.charAt(p2)==s3.charAt(p3))
//            return rec(s1,p1,s2,p2+1,s3,p3+1);
//        else return false;
//    }
}
