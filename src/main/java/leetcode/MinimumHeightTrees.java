package leetcode;

import java.util.*;

/**
 * Created by lyk on 2017/3/28.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumHeightTrees {
    public static void main(String[] args) {
        MinimumHeightTrees mht = new MinimumHeightTrees();
        int[][] edges = new int[][]{{1,2},{2,3},{0,1},{3,4}};
        System.out.println(mht.findMinHeightTrees(5,edges));
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if(n==0){
            return result;
        }
        if(n==1){
            result.add(0);
            return result;
        }

        ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();
        for(int i=0; i<n; i++){
            graph.add(new HashSet<Integer>());
        }

        for(int[] edge: edges){
//            for (int i = 0; i < edge.length; i++) {
//                System.out.print(edge[i] + " ");
//            }
//            System.out.println();
//            for (int i = 0; i < edge.length; i++) {
//                System.out.print("edge" + i + ":" +edge[i] + "===");
//            }
//            System.out.println();
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);

        LinkedList<Integer> leaves = new LinkedList<Integer>();
        for(int i=0; i<n; i++){
            if(graph.get(i).size()==1){
                leaves.offer(i);
            }
        }

        if(leaves.size()==0){
            return result;
        }

        while(n>2){
            n = n-leaves.size();

            LinkedList<Integer> newLeaves = new LinkedList<Integer>();

            for(int l: leaves){
                int neighbor = graph.get(l).iterator().next();
                graph.get(neighbor).remove(l);
                System.out.println(graph);

                if(graph.get(neighbor).size()==1){
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}
