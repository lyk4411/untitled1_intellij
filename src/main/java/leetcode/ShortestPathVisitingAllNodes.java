package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lyk on 2018-7-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ShortestPathVisitingAllNodes {
        public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        Queue<State> queue = new LinkedList();
        int[][] dist = new int[1<<N][N];
        for (int[] row: dist) Arrays.fill(row, N*N);

        for (int x = 0; x < N; ++x) {
            queue.offer(new State(1<<x, x));
            dist[1 << x][x] = 0;
        }

        while (!queue.isEmpty()) {
            State node = queue.poll();
            int d = dist[node.cover][node.head];
            if (node.cover == (1<<N) - 1) return d;

            for (int child: graph[node.head]) {
                int cover2 = node.cover | (1 << child);
                if (d + 1 < dist[cover2][child]) {
                    dist[cover2][child] = d + 1;
                    queue.offer(new State(cover2, child));

                }
            }
        }

        throw null;
    }

    class State {
        int cover, head;
        State(int c, int h) {
            cover = c;
            head = h;
        }
    }
//    public int shortestPathLength(int[][] graph) {
//        int N = graph.length;
//        int dist[][] = new int[1 << N][N];
//        for (int[] row : dist) Arrays.fill(row, N * N);
//        for (int x = 0; x < N; ++x) dist[1 << x][x] = 0;
//
//        for (int cover = 0; cover < 1 << N; ++cover) {
//            boolean repeat = true;
//            while (repeat) {
//                repeat = false;
//                for (int head = 0; head < N; ++head) {
//                    int d = dist[cover][head];
//                    for (int next : graph[head]) {
//                        int cover2 = cover | (1 << next);
//                        if (d + 1 < dist[cover2][next]) {
//                            dist[cover2][next] = d + 1;
//                            if (cover == cover2) repeat = true;
//                        }
//                    }
//                }
//            }
//        }
//
//        int ans = N * N;
//        for (int cand : dist[(1 << N) - 1])
//            ans = Math.min(cand, ans);
//        return ans;
//    }

    public static void main(String[] args) {
        ShortestPathVisitingAllNodes spvan = new ShortestPathVisitingAllNodes();
        int[][] p1 = new int[][]{
                {1, 2, 3}, {0}, {0}, {0}
        };
        int[][] p2 = new int[][]{
                {1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}
        };
        System.out.println(spvan.shortestPathLength(p1));
        System.out.println(spvan.shortestPathLength(p2));
    }

}
