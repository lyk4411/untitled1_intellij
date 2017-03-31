package leetcode;

/**
 * Created by lyk on 2017/3/31.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PowerofTwo {
    public static void main(String[] args) {
        PowerofTwo pt = new PowerofTwo();
        System.out.println(pt.isPowerOfTwo(10));
        System.out.println(pt.isPowerOfTwo(8));

    }
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}
