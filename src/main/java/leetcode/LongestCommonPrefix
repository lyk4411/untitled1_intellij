package leetcode;

/**
 * Created by liuyongkai on 17/3/5.
 */
public class LongestCommonPrefix {
    public static void main(String[] args){
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = new String[]{"abcde","abc"};
        System.out.println(lcp.longestCommonPrefix(strs));

        System.out.println("bc".indexOf(""));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}
