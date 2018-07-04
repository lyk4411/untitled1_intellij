package leetcode;

/**
 * Created by lyk on 2018-7-4.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int num5 = 0;
        int num10 = 0;
        for (int i = 0; i < bills.length; ++i) {
            if (bills[i] == 5) {
                num5++;
            }
            else {
                if (bills[i] == 20) {
                    while (bills[i] > 10 && num10 > 0) {
                        bills[i] -= 10;
                        num10--;
                    }
                    while (bills[i] > 5 && num5 > 0) {
                        bills[i] -= 5;
                        num5--;
                    }
                    if (bills[i] > 5) {
                        return false;
                    }
                }
                else {
                    while (bills[i] > 5 && num5 > 0) {
                        bills[i] -= 5;
                        num5--;
                    }
                    if (bills[i] > 5) {
                        return false;
                    }
                    num10++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange lc = new LemonadeChange();
        System.out.println(lc.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(lc.lemonadeChange(new int[]{5, 5, 10}));
        System.out.println(lc.lemonadeChange(new int[]{5, 5, 10, 10, 20}));

    }
}
