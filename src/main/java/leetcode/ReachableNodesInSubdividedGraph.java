package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by lyk on 2018-12-30.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ReachableNodesInSubdividedGraph {
    class Node {
        public int src;
        public int move;
        public Node(int src, int move) {
            this.src = src;
            this.move = move;
        }
    }
    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashMap<>());
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        Queue<Node> pq = new PriorityQueue<>((a, b) -> (a.move - b.move));

        //build graph
        for (int[] v : edges) {
            graph.get(v[0]).put(v[1], v[2]);
            graph.get(v[1]).put(v[0], v[2]);
        }

        int result = 0;
        Node head = new Node(0, 0);
        pq.offer(head);
        while (!pq.isEmpty()) {
            Node cur = pq.peek();
            pq.poll();
            int src = cur.src;
            int move = cur.move;
            if (visited.get(src) != null) continue;
            visited.put(src, true);
            ++result;

            for (int id : graph.get(src).keySet()) {
                int dst = id;
                int weight = graph.get(src).get(dst);
                int nextMove = move + weight + 1;
                if (null != visited.get(dst)) {
                    result += Math.min(M - move, graph.get(src).get(dst));
                } else {
                    if (nextMove > M) {
                        result += M - move;
                        graph.get(dst).put(src, graph.get(dst).get(src) - (M - move));
                    } else {
                        result += weight;
                        graph.get(dst).put(src, 0);
                        Node next = new Node(dst, nextMove);
                        pq.offer(next);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ReachableNodesInSubdividedGraph rnisg = new ReachableNodesInSubdividedGraph();
        System.out.println(rnisg.reachableNodes(
                new int[][]{{0,1,10},{0,2,1},{1,2,2}},6, 3
        ));
    }
}

