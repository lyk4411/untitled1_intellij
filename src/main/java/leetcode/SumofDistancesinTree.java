package leetcode;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-12-30.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SumofDistancesinTree {
    int[] ans, count;
    List<Set<Integer>> graph;
    int N;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        graph = new ArrayList<Set<Integer>>();
        ans = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);

        for (int i = 0; i < N; ++i)
            graph.add(new HashSet<Integer>());
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int node, int parent) {
        for (int child: graph.get(node))
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
    }

    public void dfs2(int node, int parent) {
        for (int child: graph.get(node))
            if (child != parent) {
                ans[child] = ans[node] - count[child] + N - count[child];
                dfs2(child, node);
            }
    }

    public static void main(String[] args) {
        SumofDistancesinTree sdt = new SumofDistancesinTree();
        IntStream.of(sdt.sumOfDistancesInTree(
                6,new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}})).forEach(
                n -> System.out.print(n + " : ")
        );
    }
}
