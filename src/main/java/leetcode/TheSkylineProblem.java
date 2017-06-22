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
    //这里为了区分左右边界，将左边界的高度存为负数，这样遇到左边界就存入堆中，
    // 遇到右边界就删掉，然后看当前状态有无改变，改变了话就把左边界和当前的高
    // 度存入结果中
//    public List<int[]> getSkyline(int[][] buildings) {
//        List<int[]> result = new ArrayList<>();
//        List<int[]> height = new ArrayList<>();
//        for(int[] b:buildings) {
//            height.add(new int[]{b[0], -b[2]});//左边界
//            height.add(new int[]{b[1], b[2]});//右边界
//        }
//        Collections.sort(height, (a, b) -> {
//            if(a[0] != b[0])
//                return a[0] - b[0];
//            return a[1] - b[1];
//        });
//        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
//        pq.offer(0);
//        int prev = 0;
//        for(int[] h:height) {
//            if(h[1] < 0) {
//                pq.offer(-h[1]);
//            } else {
//                pq.remove(h[1]);
//            }
//            int cur = pq.peek();
//            if(prev != cur) {
//                result.add(new int[]{h[0], cur});
//                prev = cur;
//            }
//        }
//        return result;
//    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();

        if (buildings == null || buildings.length == 0
                || buildings[0].length == 0) {
            return result;
        }

        List<Edge> edges = new ArrayList<Edge>();

        // add all left/right edges
        for (int[] building : buildings) {
            Edge startEdge = new Edge(building[0], building[2], true);
            edges.add(startEdge);
            Edge endEdge = new Edge(building[1], building[2], false);
            edges.add(endEdge);
        }

        // sort edges
        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge a, Edge b) {
                if (a.x != b.x)
                    return Integer.compare(a.x, b.x);

                if (a.isStart && b.isStart) {
                    return Integer.compare(b.height, a.height);
                }

                if (!a.isStart && !b.isStart) {
                    return Integer.compare(a.height, b.height);
                }

                return a.isStart ? -1 : 1;
            }
        });

        // process edges
        PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());

        for (Edge edge : edges) {
            if (edge.isStart) {
                if (heightHeap.isEmpty() || edge.height > heightHeap.peek()) {
                    result.add(new int[] { edge.x, edge.height });
                }
                heightHeap.add(edge.height);
            } else {
                heightHeap.remove(edge.height);

                if(heightHeap.isEmpty()){
                    result.add(new int[] {edge.x, 0});
                }else if(edge.height > heightHeap.peek()){
                    result.add(new int[]{edge.x, heightHeap.peek()});
                }
            }
        }

        return result;
    }
}

class Edge {
    int x;
    int height;
    boolean isStart;

    public Edge(int x, int height, boolean isStart) {
        this.x = x;
        this.height = height;
        this.isStart = isStart;
    }
}
