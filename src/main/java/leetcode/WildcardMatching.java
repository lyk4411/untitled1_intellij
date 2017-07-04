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
                    match[i][j]=match[i+1][j]||match[i][j+1];
                else
                    match[i][j]=false;
            }
        }
        return match[0][0];
    }
}
