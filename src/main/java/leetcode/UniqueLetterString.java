package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2018-7-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class UniqueLetterString {
//    考虑每个单独的字母对于最终答案的贡献。如果某个字母a对答案有贡献，那么包含他的子串一定在从这个a往两边
//    延伸到边界或者另一个a之内位置的范围内。那么总共可能的子串有u*v个，其中u、v分别为延伸到边界或者另一个
//    a之内位置的长度。对每个’A’到’Z’的字母a，找到每个a的位置，计算往外延伸的长度，乘起来累加到答案即可。
    public int uniqueLetterString(String S) {
        Map<Character, List<Integer>> index = new HashMap();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            index.computeIfAbsent(c, x-> new ArrayList<Integer>()).add(i);
        }

        long ans = 0;
        for (List<Integer> A: index.values()) {
            for (int i = 0; i < A.size(); ++i) {
                long prev = i > 0 ? A.get(i-1) : -1;
                long next = i < A.size() - 1 ? A.get(i+1) : S.length();
                ans += (A.get(i) - prev) * (next - A.get(i));
            }
        }

        return (int) ans % 1_000_000_007;
    }

    public static void main(String[] args) {
        UniqueLetterString uls = new UniqueLetterString();
        System.out.println(uls.uniqueLetterString("ABAC"));
        System.out.println(uls.uniqueLetterString("ABC"));
        System.out.println(uls.uniqueLetterString("ABA"));
    }
}
