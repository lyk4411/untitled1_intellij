package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2018-4-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};

        Set<String> seen = new HashSet();
        for (String word: words) {
            StringBuilder code = new StringBuilder();
            for (char c: word.toCharArray())
                code.append(MORSE[c - 'a']);
            seen.add(code.toString());
        }

        return seen.size();
    }

    public static void main(String[] args) {
        UniqueMorseCodeWords umcw = new UniqueMorseCodeWords();
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(umcw.uniqueMorseRepresentations(words));
    }
}
