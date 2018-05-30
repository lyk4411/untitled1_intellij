package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2018-5-31.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet();
        for (char c: new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'})
            vowel.add(c);

        int t = 1;
        StringBuilder ans = new StringBuilder();
        for (String word: S.split(" ")) {
            char first = word.charAt(0);
            if (vowel.contains(first)) {
                ans.append(word);
            } else {
                ans.append(word.substring(1));
                ans.append(word.substring(0, 1));
            }
            ans.append("ma");
            for (int i = 0; i < t; i++)
                ans.append("a");
            t++;
            ans.append(" ");
        }

        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    public static void main(String[] args) {
        GoatLatin gl = new GoatLatin();
        System.out.println(gl.toGoatLatin("I speak Goat Latin"));
        System.out.println(gl.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
