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
        //System.out.println("n:" + n + " len: " + len + " start:" + start);
        start += (n - 1) / len; //当n落到某一个确定的区间里了，那么(n-1)/len就是目标数字在
                                // 该区间里的坐标，加上start就是得到了目标数字，然后我们将
                                // 目标数字start转为字符串，(n-1)%len就是所要求的目标位
        //System.out.println("start:" + start);
        String s = Integer.toString(start);
        //System.out.println("s:" + s);
        //System.out.println("s.charAt((n - 1) % len:" + s.charAt((n - 1) % len));
        //System.out.println("=============================");
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
