package leetcode;

/**
 * Created by lyk on 2017/5/25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        RemoveKDigits rkd = new RemoveKDigits();
        String num1 = new String("1234201");
        String num2 = new String("1432219");
        System.out.println(rkd.removeKdigits(num1,3));
        System.out.println(rkd.removeKdigits(num2,4));
    }
//    根据题目的描述，移掉k个数字然后得到最小值，肯定是greedy。那么greedy的feature是什么呢？
//    看例子，首先是1432219，k = 3，不去掉1的原因是后面接的是4，当前这一步，看到下一个数比自己大的时候移掉是不划算的，因为移掉这个数之后最高位变成4，是不如保留1小的。所以可以看出规律实际上是从msb开始只要发现比之前有比当前位大的数字，那肯定要移掉之前的数字，这样当前最高位的数字就变小了。后面的3和2需要移掉也是同理。用个Stack来保存之前递增的数字。
//    再看1223，k = 1， 从左往右扫一遍发现没有出现nums[i-1] > nums[i]的情况，所以第一次扫的时候删了0个，这时候就从最大值开始移。
//    注意10200这个例子，去掉1之后，最高位是0，也得去掉。
    public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }
        // find the index of first non-zero digit
        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits? "0": new String(stk, idx, digits - idx);
    }
}
