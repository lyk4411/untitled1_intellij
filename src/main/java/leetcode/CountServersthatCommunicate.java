package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2020-1-13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CountServersthatCommunicate {
    public int countServers(int[][] g) {
        Map<Integer, Integer> r = new HashMap<>(), c = new HashMap<>();
        for(int i = 0; i < g.length; i++) {
            for(int j = 0; j < g[0].length; j++) {
                if(g[i][j] == 1) {
                    r.put(i, r.getOrDefault(i, 0) + 1);
                    c.put(j, c.getOrDefault(j, 0) + 1);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < g.length; i++) {
            for(int j = 0; j < g[0].length; j++) {
                if(g[i][j] == 1 && (r.get(i) > 1 || c.get(j) > 1)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] g1 = new int[][]{{1,0},{0,1}};
        int[][] g2 = new int[][]{{1,0},{1,1}};
        int[][] g3 = new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        CountServersthatCommunicate csc = new CountServersthatCommunicate();
        System.out.println(csc.countServers(g1));
        System.out.println(csc.countServers(g2));
        System.out.println(csc.countServers(g3));
    }
}
