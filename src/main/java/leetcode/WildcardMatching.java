package leetcode;

/**
 * Created by lyk on 2017/7/4.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class WildcardMatching {
    public static void main(String[] args) {
        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatch("aa","*"));
        System.out.println(wm.isMatch("ab","??"));
        System.out.println(wm.isMatch("aaab","*?"));
        System.out.println(wm.isMatch("aaab","***?"));
        System.out.println(wm.isMatch("abcd","**"));
        System.out.println(wm.isMatch("aabc","**"));
        System.out.println(wm.isMatch("aabc","c**"));
    }

//    public boolean isMatch(String s, String p) {
//        int idxs = 0, idxp = 0, idxstar = -1, idxmatch = 0;
//        while(idxs < s.length()){
//            // 当两个指针指向完全相同的字符时，或者p中遇到的是?时
//            if(idxp < p.length() && (s.charAt(idxs) == p.charAt(idxp) || p.charAt(idxp) == '?')){
//                idxp++;
//                idxs++;
//                // 如果字符不同也没有?，但在p中遇到是*时，我们记录下*的位置，但不改变s的指针
//            } else if(idxp < p.length() && p.charAt(idxp)=='*'){
//                idxstar = idxp;
//                idxp++;
//                //遇到*后，我们用idxmatch来记录*匹配到的s字符串的位置，和不用*匹配到的s字符串位置相区分
//                idxmatch = idxs;
//                // 如果字符不同也没有?，p指向的也不是*，但之前已经遇到*的话，我们可以从idxmatch继续匹配任意字符
//            } else if(idxstar != -1){
//                // 用上一个*来匹配，那我们p的指针也应该退回至上一个*的后面
//                idxp = idxstar + 1;
//                // 用*匹配到的位置递增
//                idxmatch++;
//                // s的指针退回至用*匹配到位置
//                idxs = idxmatch;
//            } else {
//                return false;
//            }
//        }
//        // 因为1个*能匹配无限序列，如果p末尾有多个*，我们都要跳过
//        while(idxp < p.length() && p.charAt(idxp) == '*'){
//            idxp++;
//        }
//        // 如果p匹配完了，说明匹配成功
//        return idxp == p.length();
//    }


    public boolean isMatch(String s, String p) {
        boolean[][] match=new boolean[s.length()+1][p.length()+1];
        match[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*')
                break;
            else
                match[s.length()][i]=true;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                    match[i][j]=match[i+1][j+1];
                else if(p.charAt(j)=='*')
                    match[i][j]=match[i+1][j]||match[i][j+1]/*||match[i+1][j+1] 加上也可以*/;
                else
                    match[i][j]=false;
            }
        }
        return match[0][0];
    }

//    boolean comparison(String str, String pattern) {
//        int s = 0, p = 0, match = 0, starIdx = -1;
//        while (s < str.length()){
//            // advancing both pointers
//            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
//                s++;
//                p++;
//            }
//            // * found, only advancing pattern pointer
//            else if (p < pattern.length() && pattern.charAt(p) == '*'){
//                starIdx = p;
//                match = s;
//                p++;
//            }
//            // last pattern pointer was *, advancing string pointer
//            else if (starIdx != -1){
//                p = starIdx + 1;
//                match++;
//                s = match;
//            }
//            //current pattern pointer is not star, last patter pointer was not *
//            //characters do not match
//            else return false;
//        }
//
//        //check for remaining characters in pattern
//        while (p < pattern.length() && pattern.charAt(p) == '*')
//            p++;
//
//        return p == pattern.length();
//    }
}
