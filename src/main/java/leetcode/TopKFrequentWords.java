package leetcode;

import java.util.*;

/**
 * Created by lyk on 2018-4-23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1) != count.get(w2) ?
                count.get(w2) - count.get(w1) : w1.compareTo(w2));

        return candidates.subList(0, k);
    }

    public static void main(String[] args) {
        TopKFrequentWords tkfw = new TopKFrequentWords();
        String[] words1 = new String[]
                {"i", "love", "leetcode", "i", "love", "coding"};
        String[] words2 = new String[]
                {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(tkfw.topKFrequent(words1,2));
        System.out.println(tkfw.topKFrequent(words2,4));
    }
}
