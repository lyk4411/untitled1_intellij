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
    Map<Integer, Integer> count;
    Map<Integer, List<Integer>> graph;
    public int numSquarefulPerms(int[] A) {
        int N = A.length;
        count = new HashMap();
        graph = new HashMap();

        // count.get(v) : number of v's in A
        for (int x: A)
            count.put(x, count.getOrDefault(x, 0) + 1);

        // graph.get(v) : values w in A for which v + w is a square
        //                (ie., "vw" is an edge)
        for (int x: count.keySet())
            graph.put(x, new ArrayList());

        for (int x: count.keySet())
            for (int y: count.keySet()) {
                int r = (int) (Math.sqrt(x + y) + 0.5);
                if (r * r == x + y)
                    graph.get(x).add(y);
            }

        // Add the number of paths that start at x, for all possible x
        int ans = 0;
        for (int x: count.keySet())
            ans += dfs(x, N - 1);
        return ans;
    }

    public int dfs(int x, int todo) {
        count.put(x, count.get(x) - 1);
        int ans = 1;  // default if todo == 0
        if (todo != 0) {
            ans = 0;
            for (int y: graph.get(x)) if (count.get(y) != 0) {
                ans += dfs(y, todo - 1);
            }
        }
        count.put(x, count.get(x) + 1);
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
