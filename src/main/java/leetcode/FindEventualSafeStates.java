package leetcode;

import java.util.*;

/**
 * Created by lyk on 2018-7-4.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] G) {
        int N = G.length;
        boolean[] safe = new boolean[N];

        List<Set<Integer>> graph = new ArrayList();
        List<Set<Integer>> rgraph = new ArrayList();
        for (int i = 0; i < N; ++i) {
            graph.add(new HashSet());
            rgraph.add(new HashSet());
        }

        Queue<Integer> queue = new LinkedList();

        for (int i = 0; i < N; ++i) {
            if (G[i].length == 0)
                queue.offer(i);
            for (int j: G[i]) {
                graph.get(i).add(j);
                rgraph.get(j).add(i);
            }
        }

        while (!queue.isEmpty()) {
            int j = queue.poll();
            safe[j] = true;
            for (int i: rgraph.get(j)) {
                graph.get(i).remove(j);
                if (graph.get(i).isEmpty())
                    queue.offer(i);
            }
        }

        List<Integer> ans = new ArrayList();
        for (int i = 0; i < N; ++i) if (safe[i])
            ans.add(i);

        return ans;
    }
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        int N = graph.length;
//        int[] color = new int[N];
//        List<Integer> ans = new ArrayList();
//
//        for (int i = 0; i < N; ++i)
//            if (dfs(i, color, graph))
//                ans.add(i);
//        return ans;
//    }
//
//    // colors: WHITE 0, GRAY 1, BLACK 2;
//    public boolean dfs(int node, int[] color, int[][] graph) {
//        if (color[node] > 0)
//            return color[node] == 2;//如果染色是安全状态2就返回true
//
//        color[node] = 1;//初始染1号色，相当于标记这次dfs过程中访问过它，但它的状态不确定是否安全
//                        //如果它的邻接点或者他的邻接点的邻接点dfs时又访问了i结点那么就说明成环了。
//        for (int nei: graph[node]) {
//            if (color[node] == 2)
//                continue;
//            if (color[nei] == 1 || !dfs(nei, color, graph))
//                return false;
//        }
//        color[node] = 2;
//        return true;
//    }
    public static void main(String[] args) {
        FindEventualSafeStates fess = new FindEventualSafeStates();
        System.out.println(
                fess.eventualSafeNodes(
                        new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
    }
}
