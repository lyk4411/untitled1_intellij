package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lyk on 2017/6/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ZeroOneMatrix {
    public static void main(String[] args) {
        ZeroOneMatrix zeroOneMatrix = new ZeroOneMatrix();
        int[][] matrix = new int[][]{
                {0,0,0,2},
                {1,3,0,0},
                {2,2,1,2},
                {2,2,0,2}
        };
        int[][] result = zeroOneMatrix.updateMatrix(matrix);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " : ");
            }
            System.out.println();
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }

        return matrix;
    }
}
