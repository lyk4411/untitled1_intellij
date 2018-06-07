package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2018-6-7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return solve(graph, 0);
    }

    public List<List<Integer>> solve(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList();
        if (node == N - 1) {
            List<Integer> path = new ArrayList();
            path.add(N-1);
            ans.add(path);
            return ans;
        }

        for (int nei: graph[node]) {
            for (List<Integer> path: solve(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AllPathsFromSourcetoTarget apfst = new AllPathsFromSourcetoTarget();
        int[][] g1 = new int[][]{
                {1,2}, {3}, {3}, {}
        };
        int[][] g2 = new int[][]{
                {1,2}, {3}, {3}, {4,5}, {6}, {6}, {}
        };
        System.out.println(apfst.allPathsSourceTarget(g1));
        System.out.println(apfst.allPathsSourceTarget(g2));
    }
}
