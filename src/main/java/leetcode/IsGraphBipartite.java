package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2018-6-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class IsGraphBipartite {
//    boolean dfs(int[][] G, int[] color, int v, int c) {
//        color[v] = c;
//        for (int i = 0; i < color.length; ++i) {
//            if (G[v][i] != 0) {
//                if (color[i] != 0 && color[i] == c) return false;
//                if (color[i] == 0 && !dfs(G, color, i, -c)) return false;
//            }
//        }
//        return true;
//    }

//    public boolean isBipartite(int[][] graph) {
//        int n = graph.length;
//        int[] color = new int[n];
//        int[][] G = new int[n][n];
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < graph[i].length; ++j) {
//                G[i][graph[i][j]] = 1;
//            }
//        }
//
//        for (int i = 0; i < n; ++i) {
//            if (color[i] == 0) {
//                if (!dfs(G, color, i, 1)) return false;
//            }
//        }
//        return true;
//    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0; i < graph.length; i++) {
            if(color[i] != 0) continue;
            color[i] = 1;
            Stack<Integer> s = new Stack();
            s.add(i);
            while (!s.empty()) {
                int t = s.peek();
                s.pop();
                for (int temp : graph[t]) {
                    if (color[temp] == 0) {
                        color[temp] = -1 * color[t];
                        s.add(temp);
                    } else {
                        if (color[temp] == color[t]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

        public static void main(String[] args) {
        IsGraphBipartite igb = new IsGraphBipartite();
        int[][] g1 = new int[][]{
                {1,3}, {0,2}, {1,3}, {0,2}
        };
        int[][] g2 = new int[][]{
                {1,2,3}, {0,2}, {0,1,3}, {0,2}
        };
        System.out.println(igb.isBipartite(g1));
        System.out.println(igb.isBipartite(g2));
    }
}
