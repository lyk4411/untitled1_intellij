package leetcode;

import java.math.BigInteger;

/**
 * Created by lyk on 2017/6/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SmallestGoodBase {
    public static void main(String[] args) {
        SmallestGoodBase sgb = new SmallestGoodBase();
        System.out.println(sgb.smallestGoodBase("13"));
        System.out.println(sgb.smallestGoodBase("1"));
        System.out.println(sgb.smallestGoodBase("2"));
        System.out.println(sgb.smallestGoodBase("3"));
        System.out.println(sgb.smallestGoodBase("4"));
        System.out.println(sgb.smallestGoodBase("5"));
        System.out.println(sgb.smallestGoodBase("6"));
        System.out.println(sgb.smallestGoodBase("7"));
    }
    public String smallestGoodBase(String n) {
        BigInteger N = new BigInteger(n);
        long base = Long.MAX_VALUE;

        for (int k = 2; k < 66; k++) {

            long l = 2, r = Long.MAX_VALUE - 5;
            while (l <= r) {
                long mid = l + (r - l) / 2;

                BigInteger cb = BigInteger.valueOf(mid).pow(k).subtract(BigInteger.ONE);
                BigInteger wb = N.multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));

                int cmp = cb.compareTo(wb);
                if (cmp == 0) {
                    base = Math.min(base, mid);
                    break;
                } else if (cmp < 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return "" + base;
    }
}
