package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lyk on 2017/4/12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestWordinDictionarythroughDeleting {
    public static void main(String[] args) {
        LongestWordinDictionarythroughDeleting lwdd = new LongestWordinDictionarythroughDeleting();
        List<String> lists = new ArrayList<String>();
        lists.add("ale");
        lists.add("apple");
        lists.add("monkey");
        lists.add("plea");
        lwdd.findLongestWord("abpcplea", lists);
    }

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) : a.compareTo(b));
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray())
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
            if (i == dictWord.length()) return dictWord;
        }
        return "";
    }
}
