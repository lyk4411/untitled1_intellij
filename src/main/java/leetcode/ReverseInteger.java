package leetcode;

/**
 * Created by lyk on 2017/3/9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(12345678));
        System.out.println(ri.reverse(-12345678));
    }
    public int reverse(int x)
    {
        int result = 0;
        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
