package leetcode;

import java.util.*;

/**
 * Created by lyk on 2017/6/21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TheSkylineProblem {
    public static void main(String[] args) {
        TheSkylineProblem tsp = new TheSkylineProblem();
        int[][] buildings = new int[][]{
                {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}
        };
        List<int[]> results= tsp.getSkyline(buildings);
        for (int i = 0; i < results.size(); i++) {
            int[] temp = results.get(i);
            for (int j = 0; j < temp.length; j++) {
                System.out.print("temp[" + j + "]: " + temp[j] + ";  ");
            }
            System.out.println();
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] h:height) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}
