package leetcode;

import java.util.stream.IntStream;

/**
 * Created by lyk on 2019-7-26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = IntStream.of(piles).max().getAsInt();
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (!possible(piles, H, mi))
                lo = mi + 1;
            else
                hi = mi;
        }

        return lo;
    }

    // Can Koko eat all bananas in H hours with eating speed K?
    public boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p: piles)
            time += (p-1) / K + 1;
        return time <= H;
    }

    public static void main(String[] args) {
        KokoEatingBananas keb = new KokoEatingBananas();
        int[] piles1 = new int[]{3,6,7,11};
        int H1 = 8;
        int[] piles2 = new int[]{30,11,23,4,20};
        int H2 = 5;
        int[] piles3 = new int[]{30,11,23,4,20};
        int H3 = 6;
        System.out.println(keb.minEatingSpeed(piles1, H1));
        System.out.println(keb.minEatingSpeed(piles2, H2));
        System.out.println(keb.minEatingSpeed(piles3, H3));
    }
}
