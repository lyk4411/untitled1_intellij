package leetcode;

/**
 * Created by lyk on 2017/3/29.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(1234556999));
    }
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }

}
