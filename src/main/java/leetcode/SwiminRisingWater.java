package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lyk on 2018-7-6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SwiminRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Comparator<Node1> cmp = (a, b) -> a.val - b.val;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        PriorityQueue<Node1> q = new PriorityQueue<Node1>(n * m, cmp);
        Node1 node = new Node1(grid[0][0], 0, 0);
        q.offer(node);
        visited[0][0] = 1;
        while(!q.isEmpty()) {
            Node1 cur = q.poll();
            if(cur.x == n - 1 && cur.y == m - 1) {
                return cur.val;
            }

            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(isInGrid(nx, ny, n, m) && visited[nx][ny] == 0) {
                    grid[nx][ny] = Math.max(grid[cur.x][cur.y], grid[nx][ny]);
                    q.offer(new Node1(grid[nx][ny], nx, ny));
                    visited[nx][ny] = 1;
                }
            }
        }

        return 0;
    }

    public boolean isInGrid(int x, int y, int n, int m) {
        if(x >= 0 && x < n && y >= 0 && y < m) return true;
        return false;
    }

    public static void main(String[] args) {
        SwiminRisingWater srw = new SwiminRisingWater();
        System.out.println(srw.swimInWater(new int[][]{
                {0,2},{1,3}
        }));
        System.out.println(srw.swimInWater(new int[][]{
                {0,1,2,3,4},
                {24,23,22,21,5},
                {12,13,14,15,16},
                {11,17,18,19,20},
                {10,9,8,7,6}
        }));
    }
}

class Node1 {
    public int val;
    public int x;
    public int y;
    Node1(int val, int x, int y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }
}