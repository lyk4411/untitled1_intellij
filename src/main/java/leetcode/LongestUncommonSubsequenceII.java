package leetcode;

import java.util.HashSet;

/**
 * Created by lyk on 2017/5/24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestUncommonSubsequenceII {
    public static void main(String[] args) {
        LongestUncommonSubsequenceII lusii = new LongestUncommonSubsequenceII();
        String[] strs = new String[]{"abbc","abbc","abb"};
        System.out.println(lusii.findLUSlength(strs));
    }

    public int findLUSlength(String[] strs) {
        HashSet<String> once = new HashSet<>();
        HashSet<String> more = new HashSet<>();
        for(String s : strs){
            if(once.contains(s)){
                once.remove(s);
                more.add(s);
            }else
                once.add(s);
        }
        if(once.size() == 0) return -1;
        int max = -1;
        for(String s : once){
            boolean has = false;
            for(String dup : more){
                if(has(dup, s)){
                    has = true;
                    break;
                }
            }
            if(!has) max = Math.max(max, s.length());
        }
        return max;
    }
    private boolean has(String longer, String shorter){
        int index1 = 0, index2 = 0;
        while(index1 < longer.length() && index2 < shorter.length()){
            while(index1 < longer.length() && longer.charAt(index1) != shorter.charAt(index2)) index1++;
            if(index1 < longer.length() && index2 == shorter.length() - 1) return true;
            index1++;
            index2++;
        }
        return false;
    }
}
