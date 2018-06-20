package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2018-6-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CustomSortString {
    public String customSortString(String S, String T) {
        Character[] cs = new Character[T.length()];
        for (int i = 0; i < T.length(); ++i) {
            cs[i] = T.charAt(i);
        }
        Arrays.sort(cs, (o1, o2) -> S.indexOf(o1) - S.indexOf(o2));

//        Arrays.sort(cs, new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                return S.indexOf(o1) - S.indexOf(o2);
//            }
//        });

        StringBuilder sb = new StringBuilder();
        for (char c : cs) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomSortString css = new CustomSortString();
        System.out.println(css.customSortString("cba", "abcd"));
        System.out.println(css.customSortString("cba", "aabbccdd"));
    }
}
