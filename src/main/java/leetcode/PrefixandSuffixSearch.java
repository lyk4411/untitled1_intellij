package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2018-7-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PrefixandSuffixSearch {
    Map<String, Integer> map;
    public PrefixandSuffixSearch(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            List<String> prefix = new ArrayList<>();
            List<String> suffix = new ArrayList<>();
            String word = words[i];
            for (int j = 0; j <= word.length(); ++j) {
                prefix.add(word.substring(0, j));
            }
            for (int j = word.length(); j >= 0; --j) {
                suffix.add(word.substring(j));
            }

            for (String pre : prefix) {
                for (String suf : suffix) {
                    if (!map.containsKey(pre + "#" + suf)) map.put(pre + "#" + suf, i);
                    else map.put(pre + "#" + suf, Math.max(map.get(pre + "#" + suf), i));
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        if (map.containsKey(prefix + "#" + suffix)) return map.get(prefix + "#" + suffix);
        return -1;
    }

    public static void main(String[] args) {
        String[] words1 = new String[]{"apple"};
        String[] words2 = new String[]{"apple","world"};

        PrefixandSuffixSearch pss1 = new PrefixandSuffixSearch(words1);
        PrefixandSuffixSearch pss2 = new PrefixandSuffixSearch(words2);
        System.out.println(pss1.f("a","e"));
        System.out.println(pss2.f("wor","d"));
    }
}
