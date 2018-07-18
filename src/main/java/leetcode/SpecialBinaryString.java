package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lyk on 2018-7-18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SpecialBinaryString {
    public String makeLargestSpecial(String S) {
        int count = 0, i = 0;
        List<String> res = new ArrayList<>();
        for (int j = 0; j < S.length(); ++j) {
            if (S.charAt(j) == '1') count++;
            else count--;
            if (count == 0) {
                res.add('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0');
                i = j + 1;
            }
        }
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }

    public static void main(String[] args) {
        SpecialBinaryString sbs = new SpecialBinaryString();
        System.out.println(sbs.makeLargestSpecial("11011000"));
        System.out.println(sbs.makeLargestSpecial("110110001010"));
        System.out.println(sbs.makeLargestSpecial("110100"));
    }
}
