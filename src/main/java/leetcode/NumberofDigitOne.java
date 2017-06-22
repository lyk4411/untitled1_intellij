package leetcode;

/**
 * Created by lyk on 2017/6/22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberofDigitOne {
    public static void main(String[] args) {
        NumberofDigitOne ndo = new NumberofDigitOne();
        System.out.println(ndo.countDigitOne(13));
        System.out.println(ndo.countDigitOne(130));
    }

    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
        return ones;
    }
}
