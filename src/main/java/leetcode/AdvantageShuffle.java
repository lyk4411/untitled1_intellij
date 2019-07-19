package leetcode;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2019-7-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        // assigned[b] = list of a that are assigned to beat b
        Map<Integer, Deque<Integer>> assigned = new HashMap();
        for (int b: B) assigned.put(b, new LinkedList());

        // remaining = list of a that are not assigned to any b
        Deque<Integer> remaining = new LinkedList();

        // populate (assigned, remaining) appropriately
        // sortedB[j] is always the smallest unassigned element in B
        int j = 0;
        for (int a: sortedA) {
            if (a > sortedB[j]) {
                assigned.get(sortedB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        // Reconstruct the answer from annotations (assigned, remaining)
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            // if there is some a assigned to b...
            if (assigned.get(B[i]).size() > 0)
                ans[i] = assigned.get(B[i]).pop();
            else
                ans[i] = remaining.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        AdvantageShuffle as = new AdvantageShuffle();
        int[] A = new int[]{2,7,11,15};
        int[] B = new int[]{1,10,4,11};
        IntStream.of(as.advantageCount(A, B)).forEach(n -> System.out.print(n + " : "));
        System.out.println();
        A = new int[]{12,24,8,32};
        B = new int[]{13,25,32,11};
        IntStream.of(as.advantageCount(A, B)).forEach(n -> System.out.print(n + " : "));
        A = new int[]{2,0,4,1,2};
        B = new int[]{1,3,0,0,2};
        System.out.println();
        IntStream.of(as.advantageCount(A, B)).forEach(n -> System.out.print(n + " : "));

    }
}

