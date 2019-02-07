package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2019-2-7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];

        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        SquaresofaSortedArray ssa = new SquaresofaSortedArray();
        IntStream.of(ssa.sortedSquares(new int[]{-4,-1,0,3,10})).
                forEach(n -> System.out.print(n + " : "));
        System.out.println();
        IntStream.of(ssa.sortedSquares(new int[]{-4,-1,0,3,10})).
                forEach(System.out::println);
    }
}
