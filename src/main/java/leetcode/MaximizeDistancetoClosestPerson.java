package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2018-6-11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int[] left = new int[N], right = new int[N];
        Arrays.fill(left, N);
        Arrays.fill(right, N);
//        IntStream.of(left).forEach(n -> System.out.print(n + " : "));
//        System.out.println();
//        IntStream.of(right).forEach(n -> System.out.print(n + " : "));
//        System.out.println();

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) left[i] = 0;
            else if (i > 0) left[i] = left[i-1] + 1;
        }

        for (int i = N-1; i >= 0; --i) {
            if (seats[i] == 1) right[i] = 0;
            else if (i < N-1) right[i] = right[i+1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < N; ++i)
            if (seats[i] == 0)
                ans = Math.max(ans, Math.min(left[i], right[i]));
        return ans;
    }

    public static void main(String[] args) {
        MaximizeDistancetoClosestPerson mdcp = new MaximizeDistancetoClosestPerson();
        System.out.println(mdcp.maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
        System.out.println(mdcp.maxDistToClosest(new int[]{1,0,0,0}));
    }
}
