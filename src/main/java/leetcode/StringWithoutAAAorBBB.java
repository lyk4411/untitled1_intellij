package leetcode;

/**
 * Created by lyk on 2019-2-4.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class StringWithoutAAAorBBB {
    public String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder();

        while (A > 0 || B > 0) {
            boolean writeA = false;
            int L = ans.length();
            if (L >= 2 && ans.charAt(L-1) == ans.charAt(L-2)) {
                if (ans.charAt(L-1) == 'b')
                    writeA = true;
            } else {
                if (A >= B)
                    writeA = true;
            }

            if (writeA) {
                A--;
                ans.append('a');
            } else {
                B--;
                ans.append('b');
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        StringWithoutAAAorBBB swab = new StringWithoutAAAorBBB();
        System.out.println(swab.strWithout3a3b(3, 1));
        System.out.println(swab.strWithout3a3b(4, 2));
    }
}
