package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2019-8-9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PossibleBipartition {
    ArrayList<Integer>[] graph;
    Map<Integer, Integer> color;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i)
            graph[i] = new ArrayList();

        for (int[] edge: dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        color = new HashMap();
        for (int node = 1; node <= N; ++node)
            if (!color.containsKey(node) & !dfs(node, 0))
                return false;
        return true;
    }

    public boolean dfs(int node, int c) {
        if (color.containsKey(node))
            return color.get(node) == c;
        color.put(node, c);

        for (int nei: graph[node])
            if (!dfs(nei, c ^ 1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        PossibleBipartition pb = new PossibleBipartition();
        int N1 = 4;
        int[][] dislikes1 = new int[][]{{1,2},{1,3},{2,4}};
        System.out.println(pb.possibleBipartition(N1, dislikes1));
        int N2 = 3;
        int[][] dislikes2 = new int[][]{{1,2},{1,3},{2,3}};
        System.out.println(pb.possibleBipartition(N2, dislikes2));
        int N3 = 5;
        int[][] dislikes3 = new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}};
        System.out.println(pb.possibleBipartition(N3, dislikes3));

    }
}
