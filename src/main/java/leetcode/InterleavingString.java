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
