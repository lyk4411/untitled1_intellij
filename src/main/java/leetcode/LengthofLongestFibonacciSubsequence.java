package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2019-7-26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LengthofLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        Set<Integer> S = new HashSet();
        for (int x: A) S.add(x);

        int ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j) {
                /* With the starting pair (A[i], A[j]),
                 * y represents the future expected value in
                 * the fibonacci subsequence, and x represents
                 * the most current value found. */
                int x = A[j], y = A[i] + A[j];
                int length = 2;
                while (S.contains(y)) {
                    // x, y -> y, x+y
                    int tmp = y;
                    y += x;
                    x = tmp;
                    ans = Math.max(ans, ++length);
                }
            }

        return ans >= 3 ? ans : 0;
    }

    public static void main(String[] args) {
        LengthofLongestFibonacciSubsequence llfs =
                new LengthofLongestFibonacciSubsequence();
        System.out.println(llfs.lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(llfs.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
    }
}
