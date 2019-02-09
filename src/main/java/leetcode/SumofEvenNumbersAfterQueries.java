package leetcode;

import java.util.stream.IntStream;

/**
 * Created by lyk on 2019-2-9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SumofEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int S = 0;
        for (int x: A)
            if (x % 2 == 0)
                S += x;

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0) S -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) S += A[index];
            ans[i] = S;
        }

        return ans;
    }

    public static void main(String[] args) {
        SumofEvenNumbersAfterQueries senaq = new SumofEvenNumbersAfterQueries();
        IntStream.of(senaq.sumEvenAfterQueries(
                new int[]{1,2,3,4},
                new int[][]{{1,0},{-3,1},{-4,0},{2,3}})).
                forEach(n -> System.out.print(n + " : "));
    }
}
