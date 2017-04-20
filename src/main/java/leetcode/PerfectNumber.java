package leetcode;

/**
 * Created by lyk on 2017/4/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PerfectNumber {
    public static void main(String[] args) {
        PerfectNumber pn = new PerfectNumber();
        System.out.println(pn.checkPerfectNumber(123131));
        System.out.println(pn.checkPerfectNumber(121));
        System.out.println(pn.checkPerfectNumber(28));
    }
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) sum += num / i;
            }
        }
        sum++;

        return sum == num;
    }
}
