package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2017/3/27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class WordPattern {
    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abcba","hello world ! world hello"));
        System.out.println(wp.wordPattern("abcba","hello world ! world hello."));
        System.out.println(wp.wordPattern("abcbad","hello world ! world hello ."));

    }
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
//        for (int i = 0; i < words.length; i++) {
//            System.out.print(words[i] + ":");
//        }
//        System.out.println();
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        //System.out.println(index);
        return true;
    }
}
