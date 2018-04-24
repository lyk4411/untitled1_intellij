package leetcode;

/**
 * Created by lyk on 2018-4-24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NonnegativeIntegerswithoutConsecutiveOnes {
    public int findIntegers(int num) {
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < f.length; i++)
            f[i] = f[i - 1] + f[i - 2];
        int i = 30, sum = 0, prev_bit = 0;
        while (i >= 0) {
            if ((num & (1 << i)) != 0) {
                sum += f[i];
                if (prev_bit == 1) {
                    sum--;
                    break;
                }
                prev_bit = 1;
            } else {
                prev_bit = 0;
            }
            i--;
        }
        return sum + 1;
    }

    public static void main(String[] args) {
        NonnegativeIntegerswithoutConsecutiveOnes nico =
                new NonnegativeIntegerswithoutConsecutiveOnes();
        System.out.println(nico.findIntegers(8));
        System.out.println(nico.findIntegers(12));

    }
}
