package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lyk on 2018-4-24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ReplaceWords {
    public String replaceWords(List<String> roots, String sentence) {
        Set<String> rootset = new HashSet();
        for (String root: roots) rootset.add(root);

        StringBuilder ans = new StringBuilder();
        for (String word: sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (rootset.contains(prefix)) break;
            }
            if (ans.length() > 0) ans.append(" ");
            ans.append(prefix);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        ReplaceWords rw = new ReplaceWords();
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
        System.out.println(
                rw.replaceWords(list,"the cattle was rattled by the battery"));
    }
}
