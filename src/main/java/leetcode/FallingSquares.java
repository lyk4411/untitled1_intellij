package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2018-7-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        int[] qans = new int[positions.length];
        for (int i = 0; i < positions.length; i++) {
            int left = positions[i][0];
            int size = positions[i][1];
            int right = left + size;
            qans[i] += size;

            for (int j = i+1; j < positions.length; j++) {
                int left2 = positions[j][0];
                int size2 = positions[j][1];
                int right2 = left2 + size2;
                if (left2 < right && left < right2) { //intersect
                    qans[j] = Math.max(qans[j], qans[i]);
                }
            }
        }

        List<Integer> ans = new ArrayList();
        int cur = -1;
        for (int x: qans) {
            cur = Math.max(cur, x);
            ans.add(cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        FallingSquares fs = new FallingSquares();
        int[][] f1 = new int[][]{
                {1, 2}, {2, 3}, {6, 1}
        };
        int[][] f2 = new int[][]{
                {100, 100}, {200, 100}
        };
        System.out.println(fs.fallingSquares(f1));
        System.out.println(fs.fallingSquares(f2));
    }
}
