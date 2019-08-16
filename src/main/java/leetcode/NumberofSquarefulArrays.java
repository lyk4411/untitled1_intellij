package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2019-8-16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberofSquarefulArrays {
//    Map<Integer, Integer> count;
//    Map<Integer, List<Integer>> graph;
//    public int numSquarefulPerms(int[] A) {
//        int N = A.length;
//        count = new HashMap();
//        graph = new HashMap();
//
//        // count.get(v) : number of v's in A
//        for (int x: A)
//            count.put(x, count.getOrDefault(x, 0) + 1);
//
//        // graph.get(v) : values w in A for which v + w is a square
//        //                (ie., "vw" is an edge)
//        for (int x: count.keySet())
//            graph.put(x, new ArrayList());
//
//        for (int x: count.keySet())
//            for (int y: count.keySet()) {
//                int r = (int) (Math.sqrt(x + y) + 0.5);
//                if (r * r == x + y)
//                    graph.get(x).add(y);
//            }
//
//        // Add the number of paths that start at x, for all possible x
//        int ans = 0;
//        for (int x: count.keySet())
//            ans += dfs(x, N - 1);
//        return ans;
//    }
//
//    public int dfs(int x, int todo) {
//        count.put(x, count.get(x) - 1);
//        int ans = 1;  // default if todo == 0
//        if (todo != 0) {
//            ans = 0;
//            for (int y: graph.get(x)) if (count.get(y) != 0) {
//                ans += dfs(y, todo - 1);
//            }
//        }
//        count.put(x, count.get(x) + 1);
//        return ans;
//    }
    int N;
    Map<Integer, List<Integer>> graph;
    Integer[][] memo;

    public int numSquarefulPerms(int[] A) {
        N = A.length;
        graph = new HashMap();
        memo = new Integer[N][1 << N];

        for (int i = 0; i < N; ++i)
            graph.put(i, new ArrayList());

        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j) {
                int r = (int) (Math.sqrt(A[i] + A[j]) + 0.5);
                if (r * r == A[i] + A[j]) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }


        int[] factorial = new int[20];
        factorial[0] = 1;
        for (int i = 1; i < 20; ++i)
            factorial[i] = i * factorial[i-1];

        int ans = 0;
        for (int i = 0; i < N; ++i)
            ans += dfs(i, 1 << i);

        Map<Integer, Integer> count = new HashMap();
        for (int x: A)
            count.put(x, count.getOrDefault(x, 0) + 1);
        for (int v: count.values())
            ans /= factorial[v];

        return ans;
    }

    public int dfs(int node, int visited) {
        if (visited == (1 << N) - 1)
            return 1;
        if (memo[node][visited] != null)
            return memo[node][visited];

        int ans = 0;
        for (int nei: graph.get(node))
            if (((visited >> nei) & 1) == 0)
                ans += dfs(nei, visited | (1 << nei));
        memo[node][visited] = ans;
        return ans;
    }


    public static void main(String[] args) {
        NumberofSquarefulArrays nsa = new NumberofSquarefulArrays();
        int[] A1 = new int[]{1, 17, 8};
        int[] A2 = new int[]{2, 2, 2};
        System.out.println(nsa.numSquarefulPerms(A1));
        System.out.println(nsa.numSquarefulPerms(A2));
    }
}
