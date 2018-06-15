package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2018-6-14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String S) {
        List<String> ans = new ArrayList();
        for (int i = 2; i < S.length()-1; ++i)
            for (String left: make(S, 1, i))
                for (String right: make(S, i, S.length()-1))
                    ans.add("(" + left + ", " + right + ")");
        return ans;
    }

    public List<String> make(String S, int i, int j) {
        // Make on S.substring(i, j)
        List<String> ans = new ArrayList();
        for (int d = 1; d <= j-i; ++d) {
            String left = S.substring(i, i+d);
            String right = S.substring(i+d, j);
            if ((!left.startsWith("0") || left.equals("0"))
                    && !right.endsWith("0"))
                ans.add(left + (d < j-i ? "." : "") + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        AmbiguousCoordinates ac = new AmbiguousCoordinates();
        System.out.println(ac.ambiguousCoordinates("(123)"));
        System.out.println(ac.ambiguousCoordinates("(00011)"));
        System.out.println(ac.ambiguousCoordinates("(0123)"));
        System.out.println(ac.ambiguousCoordinates("(100)"));
    }
}
