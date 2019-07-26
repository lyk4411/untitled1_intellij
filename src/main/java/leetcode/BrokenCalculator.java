package leetcode;

/**
 * Created by lyk on 2019-7-27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        int ans = 0;
        while (Y > X) {
            ans++;
            if (Y % 2 == 1)
                Y++;
            else
                Y /= 2;
        }

        return ans + X - Y;
    }

    public static void main(String[] args) {
        BrokenCalculator bc = new BrokenCalculator();
        System.out.println(bc.brokenCalc(2, 3));
        System.out.println(bc.brokenCalc(2, 100));
    }
}
