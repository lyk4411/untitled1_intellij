package leetcode;

/**
 * Created by lyk on 2017/3/28.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
        System.out.println(ftz.trailingZeroes(4 ));
        System.out.println(ftz.trailingZeroes(5 ));
        System.out.println(ftz.trailingZeroes(10));
        System.out.println(ftz.trailingZeroes(15));
        System.out.println(ftz.trailingZeroes(20));
        System.out.println(ftz.trailingZeroes(25));
        System.out.println(ftz.trailingZeroes(30));

    }
    public int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
