package leetcode;

/**
 * Created by lyk on 2017/5/24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestUncommonSubsequenceI {
    public static void main(String[] args) {
        LongestUncommonSubsequenceI lusi = new LongestUncommonSubsequenceI();
        System.out.println(lusi.findLUSlength("abcd","abcdefg"));
    }
    public int findLUSlength(String a, String b) {
        if(a.equals(b))
            return -1;
        else
            return Math.max(a.length(),b.length());
    }
}
