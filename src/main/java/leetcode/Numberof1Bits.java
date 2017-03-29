package leetcode;

/**
 * Created by lyk on 2017/3/29.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Numberof1Bits {
    public static void main(String[] args) {
        Numberof1Bits nb = new Numberof1Bits();
        System.out.println(nb.hammingWeight(123));
    }
    public static int hammingWeight(int n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;
    }
}
