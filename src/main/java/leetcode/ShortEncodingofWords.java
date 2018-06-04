package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2018-6-4.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ShortEncodingofWords {
    public int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k)
                good.remove(word.substring(k));
        }

        int ans = 0;
        for (String word: good)
            ans += word.length() + 1;
        return ans;
    }

    public static void main(String[] args) {
        ShortEncodingofWords sew = new ShortEncodingofWords();
        String[] words = new String[]{
                "time",
                "me",
                "bell"
        };
        System.out.println(sew.minimumLengthEncoding(words));
    }
}
