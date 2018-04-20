package leetcode;

/**
 * Created by lyk on 2018-4-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++) S.append(A);
        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q+1;
        return -1;
    }

    public static void main(String[] args) {
        RepeatedStringMatch rsm = new RepeatedStringMatch();
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println(rsm.repeatedStringMatch(a, b));
        System.out.println(rsm.repeatedStringMatch(b, a));
    }
}
