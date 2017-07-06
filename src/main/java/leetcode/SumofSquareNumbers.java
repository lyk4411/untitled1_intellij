package leetcode;

/**
 * Created by lyk on 2017/7/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SumofSquareNumbers {
    public static void main(String[] args) {
        SumofSquareNumbers ssn = new SumofSquareNumbers();
        System.out.println(ssn.judgeSquareSum(5));
        System.out.println(ssn.judgeSquareSum(3));
    }
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
