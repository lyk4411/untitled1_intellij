package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2018-4-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestWordinDictionary {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> wordset = new HashSet();
        for (String word: words) wordset.add(word);
        for (String word: words) {
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) ans = word;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestWordinDictionary lwd = new LongestWordinDictionary();
        String[] words1 = new String[]{
                "w","wo","wor","worl", "world"
        };
        String[] words2 = new String[]{
                "a", "banana", "app", "appl", "ap", "apply", "apple"
        };
        System.out.println(lwd.longestWord(words1));
        System.out.println(lwd.longestWord(words2));
    }
}
