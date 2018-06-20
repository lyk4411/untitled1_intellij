package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by lyk on 2018-6-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberofMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, LinkedList<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new LinkedList<String>());
        }
        for (String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            LinkedList<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberofMatchingSubsequences nms = new NumberofMatchingSubsequences();
        String[] words = new String[]{
                "a", "bb", "acd", "ace"
        };
        System.out.println(nms.numMatchingSubseq("abcde", words));
    }
}
