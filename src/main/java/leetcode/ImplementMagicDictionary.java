package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2018-4-21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ImplementMagicDictionary {

    Map<Integer, ArrayList<String>> buckets;
    public ImplementMagicDictionary() {
        buckets = new HashMap();
    }

    public void buildDict(String[] words) {
        for (String word: words) {
            buckets.computeIfAbsent(word.length(), x -> new ArrayList()).add(word);
//            System.out.println(buckets);
        }
    }

    public boolean search(String word) {
        if (!buckets.containsKey(word.length())) return false;
        for (String candidate: buckets.get(word.length())) {
            int mismatch = 0;
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) != candidate.charAt(i)) {
                    if (++mismatch > 1) break;
                }
            }
            if (mismatch == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ImplementMagicDictionary imd = new ImplementMagicDictionary();
        String[] words = new String[]{
               "hello",
               "world",
               "leetcode"
        };
        imd.buildDict(words);
        System.out.println(imd.search("hello"));
        System.out.println(imd.search("hell"));
        System.out.println(imd.search("hella"));
        System.out.println(imd.search("leetcode"));

    }
}
