package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-9-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int t = 0; t < A.length; ++t)
            B[t] = A[t];

        Arrays.sort(B, (a, b) -> Integer.compare(a%2, b%2));

        for (int t = 0; t < A.length; ++t)
            A[t] = B[t];
        return A;
    }

    public static void main(String[] args) {
        SortArrayByParity sabp = new SortArrayByParity();
        IntStream.of(sabp.sortArrayByParity(new int[]{1,2,3,4,5,6})).forEach(n -> System.out.print(n + " : "));
    }
}
