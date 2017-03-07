package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2017/3/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();


        for (int i = 0; i < 100; i++) {
            System.out.println((i + " is " + hn.isHappy(i)));
        }
    }
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum,remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n%10;
                squareSum += remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;
    }
}
