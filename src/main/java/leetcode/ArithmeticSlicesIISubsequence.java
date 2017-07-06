package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2017/7/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ArithmeticSlicesIISubsequence {
    public static void main(String[] args) {
        ArithmeticSlicesIISubsequence ass = new ArithmeticSlicesIISubsequence();
        int[] A = new int[]{2, 4, 6, 8, 10};
        int[] B = new int[]{1, 3, 4, 6, 7, 8, 10};
        System.out.println(ass.numberOfArithmeticSlices(A));
        System.out.println(ass.numberOfArithmeticSlices(B));
    }

    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] map = new Map[A.length];

        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int)diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }

        return res;
    }
}
