package leetcode;

/**
 * Created by lyk on 2018-4-18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RotatedDigits {
    public int rotatedDigits(int N) {
        int cnt = 0;
        for (int i = 1; i <= N; ++i) {
            int rotate = valid(i);
            if (rotate != -1 && rotate != i) cnt += 1;
        }
        return cnt;
    }

    public int valid(int n) {
        int[] map = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};
        int num = 0; int p = 1;
        for(;n != 0; n /= 10) {
            int digit = map[n % 10];
            if (digit == -1) return -1;
            num = num + p * digit;
            p *= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        RotatedDigits rd = new RotatedDigits();
        System.out.println(rd.rotatedDigits(123));
        System.out.println(rd.rotatedDigits(696));
        System.out.println(rd.rotatedDigits(10));
        System.out.println(rd.rotatedDigits(17));
        System.out.println(rd.rotatedDigits(18));
    }
}
