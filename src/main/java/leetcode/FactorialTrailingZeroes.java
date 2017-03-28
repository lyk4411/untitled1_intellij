package leetcode;

/**
 * Created by lyk on 2017/3/28.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
