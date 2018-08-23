package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by lyk on 2018-8-23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {
        UncommonWordsfromTwoSentences uwts = new UncommonWordsfromTwoSentences();
        Stream.of(uwts.uncommonFromSentences("apple apple", "banana")).forEach(n -> System.out.println(n));
        System.out.println();
        Stream.of(uwts.uncommonFromSentences("this apple is sweet", "this apple is sour")).forEach(n -> System.out.println(n));

    }
}
