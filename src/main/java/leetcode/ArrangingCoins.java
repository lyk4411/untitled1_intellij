package leetcode;

/**
 * Created by lyk on 2017/3/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        ArrangingCoins ac = new ArrangingCoins();
        System.out.println(ac.arrangeCoins(100));
    }
    public int arrangeCoins(int n) {
        int sum = n;
        int i = 0;
        while (sum > i)
        {
            ++i;
            sum -= i;
        }
        return i;
    }
}
