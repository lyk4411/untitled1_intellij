package leetcode;

import java.util.*;

/**
 * Created by lyk on 2018-12-30.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ReachableNodesInSubdividedGraph {
    class Node {
        public int src;
        public int hp;
        public Node(int src, int hp) {
            this.src = src;
            this.hp = hp;
        }
    }
    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashMap<>());
        }
        Map<Integer, Integer> visited = new HashMap<>();
        Queue<Node> pq = new PriorityQueue<>((a, b) -> (b.hp - a.hp));

        //build graph
        for (int[] v : edges) {
            graph.get(v[0]).put(v[1], v[2]);
            graph.get(v[1]).put(v[0], v[2]);
        }

        int result = 0;
        Node head = new Node(0, M + 1);
        pq.offer(head);
        while (!pq.isEmpty()) {
//            for(Node p :pq) {
//                System.out.println("src:" + p.src + " hp:" + p.hp);
//            }
//            System.out.println("============");

            Node cur = pq.peek();
            pq.poll();
            int src = cur.src;
            int hp = cur.hp - 1;
            if (null != visited.get(src)) continue;
//            System.out.println(visited);
            visited.put(src, hp);
            ++result;

//            System.out.println("src: " + src);
            for (int id : graph.get(src).keySet()) {
                int dst = id;
//                System.out.println("dst:" + dst);
                int weight = graph.get(src).get(dst);
//                System.out.println("graph.get(" + src + ").get( " + dst + "):" + weight + " hp: " + hp);
                if (hp > weight) {
                    if(visited.get(dst) != null  && graph.get(src).get(dst)==0) continue;
                    result += weight;
                    Node next = new Node(dst, hp - weight);
                    graph.get(dst).put(src, 0);
                    pq.offer(next);
                } else {
                    graph.get(dst).put(src, graph.get(dst).get(src) - hp);
                    result += hp;
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
        System.out.println(rnisg.reachableNodes(
                new int[][]{{1,2,5},{0,3,3},{1,3,2},{2,3,5},{0,4,1}},7, 5
        ));
        System.out.println(rnisg.reachableNodes(
                new int[][]{{3,4,8},{0,1,3},{1,4,0},{1,2,3},{0,3,2},{0,4,10},{1,3,3},{2,4,3},{2,3,3},{0,2,10}},7, 5
        ));
    }
}

