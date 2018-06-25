package leetcode;

/**
 * Created by lyk on 2018-6-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SwapAdjacentinLRString {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        int n = s.length;
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (j < n && e[j] == 'X') j ++;
            while (i < n && s[i] == 'X') i ++;
            if (i == n || j == n) break;
            if (s[i] == 'R' && i > j) return false;
            if (s[i] == 'L' && i < j) return false;
            i ++;
            j ++;
        }
        return true;
    }

    public static void main(String[] args) {
        SwapAdjacentinLRString salrs = new SwapAdjacentinLRString();
        System.out.println(salrs.canTransform("RXXLRXRXL","XRLXXRRLX"));
        System.out.println(salrs.canTransform("XRLXXRRLX","RXXLRXRXL"));

    }
}
