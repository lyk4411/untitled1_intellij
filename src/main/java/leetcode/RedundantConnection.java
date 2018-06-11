package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-6-11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RedundantConnection {
    Set<Integer> seen = new HashSet();
    int MAX_EDGE_VAL = 1000;

    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE_VAL + 1];
        for (int i = 0; i <= MAX_EDGE_VAL; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] edge: edges) {
            seen.clear();
            if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() &&
                    dfs(graph, edge[0], edge[1])) {
                return edge;
            }
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        throw new AssertionError();
    }
    public boolean dfs(ArrayList<Integer>[] graph, int source, int target) {
        if (!seen.contains(source)) {
            seen.add(source);
            if (source == target) return true;
            for (int nei: graph[source]) {
                if (dfs(graph, nei, target)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RedundantConnection rc = new RedundantConnection();
        int[][] e1 = new int[][]{
                {1,2}, {1,3}, {2,3}
        };
        int[][] e2 = new int[][]{
                {1,2}, {2,3}, {3,4}, {1,4}, {1,5}
        };
        IntStream.of(rc.findRedundantConnection(e1)).forEach(a -> System.out.print(a + " : "));
        System.out.println();
        IntStream.of(rc.findRedundantConnection(e2)).forEach(a -> System.out.print(a + " : "));
    }
}
