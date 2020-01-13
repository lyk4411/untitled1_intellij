package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2020-1-13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] A) {
        int res = 0, left = -1, right = -1;
        Arrays.sort(A, (a, b) -> a[0] - b[0]);
        for (int[] v : A) {
            if (v[0] > left && v[1] > right) {
                left = v[0];
                ++res;
            }
            right = Math.max(right, v[1]);
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveCoveredIntervals rci = new RemoveCoveredIntervals();
        int[][] a = new int[][]{{1,4},{3,6},{2,8}};
        System.out.println(rci.removeCoveredIntervals(a));
    }
}
