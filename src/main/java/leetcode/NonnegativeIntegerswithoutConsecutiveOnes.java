package leetcode;

/**
 * Created by lyk on 2017/7/14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NonnegativeIntegerswithoutConsecutiveOnes {
    public static void main(String[] args) {
        NonnegativeIntegerswithoutConsecutiveOnes nico = new NonnegativeIntegerswithoutConsecutiveOnes();
        System.out.println(nico.findIntegers(123));
        System.out.println(nico.findIntegers(5));
    }

    public int findIntegers(int num) {
        int count = 0;
        for (int i = 0; i <= num; i++)
            if (check(i))
                count++;
        return count;
    }
    public boolean check(int n) {
        int i = 31;
        while (i > 0) {
            if ((n & (1 << i)) != 0 && (n & (1 << (i - 1))) != 0)
                return false;
            i--;
        }
        return true;
    }
}
