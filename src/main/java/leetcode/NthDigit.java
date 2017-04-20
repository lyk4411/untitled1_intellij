package leetcode;

/**
 * Created by lyk on 2017/4/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NthDigit {
    public static void main(String[] args) {
        NthDigit nd = new NthDigit();
        System.out.println(nd.findNthDigit(100));
        System.out.println(nd.findNthDigit(1000));
        System.out.println(nd.findNthDigit(10000));
    }
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
