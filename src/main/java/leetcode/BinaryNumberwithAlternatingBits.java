package leetcode;

/**
 * Created by lyk on 2018-4-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        String bits = Integer.toBinaryString(n);
        for (int i = 0; i < bits.length() - 1; i++) {
            if (bits.charAt(i) == bits.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryNumberwithAlternatingBits bnab =
                new BinaryNumberwithAlternatingBits();
        System.out.println(bnab.hasAlternatingBits(7));
        System.out.println(bnab.hasAlternatingBits(8));
        System.out.println(bnab.hasAlternatingBits(9));
        System.out.println(bnab.hasAlternatingBits(10));
        System.out.println(bnab.hasAlternatingBits(11));
    }
}
