package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2019-2-7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        KClosestPointstoOrigin kcpo = new KClosestPointstoOrigin();
        int[][] result = kcpo.kClosest(
                new int[][]{{3, 3}, {5, -1}, {-2, 4},}, 2);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length ; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
    }
}
