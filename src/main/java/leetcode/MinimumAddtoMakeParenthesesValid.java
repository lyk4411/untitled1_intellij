package leetcode;

/**
 * Created by lyk on 2018-12-24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }

    public static void main(String[] args) {
        MinimumAddtoMakeParenthesesValid mampv = new MinimumAddtoMakeParenthesesValid();
        System.out.println(mampv.minAddToMakeValid("())"));
        System.out.println(mampv.minAddToMakeValid("()))(("));
        System.out.println(mampv.minAddToMakeValid("((("));
        System.out.println(mampv.minAddToMakeValid("()"));
    }
}
