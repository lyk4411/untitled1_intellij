package leetcode;

/**
 * Created by lyk on 2017/5/25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class IntegerReplacement {
    public static void main(String[] args) {
        IntegerReplacement ir = new IntegerReplacement();
        System.out.println(ir.integerReplacement(15));
        System.out.println(ir.integerReplacement(150));
    }

    public int integerReplacement(int n) {
        int c = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                --n;
            } else {
                ++n;
            }
            ++c;
        }
        return c;
    }
}
