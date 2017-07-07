package leetcode;

import java.util.*;

/**
 * Created by lyk on 2017/7/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ConcatenatedWords {
    public static void main(String[] args) {
        ConcatenatedWords cw = new ConcatenatedWords();
        String[] words = new String[]{"cat","cats","catsdogcats","dog",
                "dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(cw.findAllConcatenatedWordsInADict(words));
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }

        return result;
    }

    private static boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
