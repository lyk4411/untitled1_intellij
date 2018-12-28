package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-12-27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] a, int k) {
        int n = a.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator<int[]>) (o1, o2) -> {
            int s1 = a[o1[0]] * a[o2[1]];
            int s2 = a[o2[0]] * a[o1[1]];
            return s1 - s2;
        });
        for (int i = 0; i < n - 1; i++) {
            pq.add(new int[]{i, n - 1});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] pop = pq.poll();
            if (pop[1] - 1 > pop[0]) {
                pop[1]--;
                pq.offer(pop);
            }
        }
        int[] peek = pq.peek();
        return new int[]{a[peek[0]], a[peek[1]]};
    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction kspf = new KthSmallestPrimeFraction();
//        IntStream.of(kspf.kthSmallestPrimeFraction(
//                new int[]{1, 2, 3, 5}, 3)).forEach(n -> System.out.print(n + " : "));
//        System.out.println();
//        IntStream.of(kspf.kthSmallestPrimeFraction(
//                new int[]{1, 7}, 1)).forEach(n -> System.out.print(n + " : "));
//        System.out.println();
        IntStream.of(kspf.kthSmallestPrimeFraction(
                new int[]{1, 7, 23, 29, 47}, 8)).forEach(n -> System.out.print(n + " : "));

    }
}
