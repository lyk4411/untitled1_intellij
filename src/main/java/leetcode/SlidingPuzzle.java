package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lyk on 2018-7-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        HashSet<String> visited = new HashSet<>();
        // all the positions 0 can be swapped to
        int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 },
                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            // level count, has to use size control here, otherwise not needed
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return res;
                }
                int zero = cur.indexOf('0');
                // swap if possible
                for (int dir : dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);

                }
            }
            res++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        SlidingPuzzle sp = new SlidingPuzzle();
        int[][] b1 = new int[][]{
                {1,2,3},{4,0,5}
        };
        int[][] b2 = new int[][]{
                {1,2,3},{5,4,0}
        };
        int[][] b3 = new int[][]{
                {4,1,2},{5,0,3}
        };
        int[][] b4 = new int[][]{
                {3,2,4},{1,5,0}
        };
        System.out.println(sp.slidingPuzzle(b1));
        System.out.println(sp.slidingPuzzle(b2));
        System.out.println(sp.slidingPuzzle(b3));
        System.out.println(sp.slidingPuzzle(b4));
    }
}
