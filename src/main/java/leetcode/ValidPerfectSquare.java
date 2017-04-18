package leetcode;

/**
 * Created by lyk on 2017/4/18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        ValidPerfectSquare vps = new ValidPerfectSquare();
        System.out.println(vps.isPerfectSquare(16));
        System.out.println(vps.isPerfectSquare(166));
    }
//    public boolean isPerfectSquare(int num) {
//        int i = 1;
//        while (num > 0) {
//            num -= i;
//            i += 2;
//        }
//        return num == 0;
//    }

    public boolean isPerfectSquare(int num) {
        long start = 1, end = num;
        while (start <= end) {
            long mid = start + (end-start)/2;
            long t = mid * mid;
            if (t == num) return true;
            else if (t < num) start = mid+1;
            else end = mid-1;
        }
        return false;
    }
}
