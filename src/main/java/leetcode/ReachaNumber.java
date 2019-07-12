package leetcode;

/**
 * Created by lyk on 2019-7-12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ReachaNumber {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0)
            target -= ++k;
        return target % 2 == 0 ? k : k + 1 + k%2;
    }

    public static void main(String[] args) {
        ReachaNumber rn = new ReachaNumber();
        System.out.println(rn.reachNumber(10));
        System.out.println(rn.reachNumber(4));

    }
}
