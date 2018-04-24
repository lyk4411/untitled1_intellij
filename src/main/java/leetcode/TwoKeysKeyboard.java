package leetcode;

/**
 * Created by lyk on 2018-4-24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TwoKeysKeyboard {
    public int minSteps(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoKeysKeyboard tkk = new TwoKeysKeyboard();
        System.out.println(tkk.minSteps(1));
        System.out.println(tkk.minSteps(2));
        System.out.println(tkk.minSteps(3));
        System.out.println(tkk.minSteps(4));
        System.out.println(tkk.minSteps(5));
        System.out.println(tkk.minSteps(6));
        System.out.println(tkk.minSteps(7));
        System.out.println(tkk.minSteps(8));
    }
}
