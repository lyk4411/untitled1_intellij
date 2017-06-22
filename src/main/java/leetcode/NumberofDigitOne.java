package leetcode;

/**
 * Created by lyk on 2017/6/22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberofDigitOne {
    public static void main(String[] args) {
        NumberofDigitOne ndo = new NumberofDigitOne();
        System.out.println(ndo.countDigitOne(7));
        System.out.println(ndo.countDigitOne(13));
        System.out.println(ndo.countDigitOne(130));
    }

    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int q = n, x = 1, ans = 0;
        do {
            int digit = q % 10;
            q /= 10;
            ans += q * x;
            if (digit == 1) ans += n % x + 1;
            if (digit >  1) ans += x;
            x *= 10;
        } while (q > 0);
        return ans;

    }
}
