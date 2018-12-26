package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2018-12-26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = count("");
        for (String b: B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
        search: for (String a: A) {
            int[] aCount = count(a);
            for (int i = 0; i < 26; ++i)
                if (aCount[i] < bmax[i])
                    continue search;
            ans.add(a);
        }

        return ans;
    }

    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }

    public static void main(String[] args) {
        WordSubsets ws = new WordSubsets();
        System.out.println(ws.wordSubsets(
                new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"e","o"}));
        System.out.println(ws.wordSubsets(
                new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"l","e"}));
        System.out.println(ws.wordSubsets(
                new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"e","oo"}));

    }
}
