package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-8-27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;  // sum of A, B respectively
        for (int x: A) sa += x;
        for (int x: B) sb += x;
        int delta = (sb - sa) / 2;
        // If Alice gives x, she expects to receive x + delta

        Set<Integer> setB = new HashSet();
        for (int x: B) setB.add(x);

        for (int x: A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};

        throw null;
    }

    public static void main(String[] args) {
        FairCandySwap fcs = new FairCandySwap();
        IntStream.of(fcs.fairCandySwap(new int[]{1, 2}, new int[]{2, 2})).forEach(n -> System.out.print(n + " "));
        System.out.println();
        IntStream.of(fcs.fairCandySwap(new int[]{1, 2}, new int[]{2, 3})).forEach(n -> System.out.print(n + " "));
        System.out.println();
        IntStream.of(fcs.fairCandySwap(new int[]{2}, new int[]{1, 3})).forEach(n -> System.out.print(n + " "));
        System.out.println();
        IntStream.of(fcs.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})).forEach(n -> System.out.print(n + " "));
    }
}
