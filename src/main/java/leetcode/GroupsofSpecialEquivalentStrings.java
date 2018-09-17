package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2018-9-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class GroupsofSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }

    public static void main(String[] args) {
        GroupsofSpecialEquivalentStrings gses = new GroupsofSpecialEquivalentStrings();
        String[] s1 = new String[]{"a","b","c","a","c","c"};
        String[] s2 = new String[]{"aa","bb","ab","ba"};
        String[] s3 = new String[]{"abc","acb","bac","bca","cab","cba"};
        String[] s4 = new String[]{"abcd","cdab","adcb","cbad"};
        System.out.println(gses.numSpecialEquivGroups(s1));
        System.out.println(gses.numSpecialEquivGroups(s2));
        System.out.println(gses.numSpecialEquivGroups(s3));
        System.out.println(gses.numSpecialEquivGroups(s4));
    }
}
