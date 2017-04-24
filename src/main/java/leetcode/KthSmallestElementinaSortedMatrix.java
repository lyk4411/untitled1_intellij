package leetcode;

import java.util.PriorityQueue;

/**
 * Created by lyk on 2017/4/21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KthSmallestElementinaSortedMatrix {
    public static void main(String[] args) {
        KthSmallestElementinaSortedMatrix ksesm =
                new KthSmallestElementinaSortedMatrix();
        int[][] matrix = new int[][]{
                {1,2,5,7,9},
                {3,6,8,9,10},
                {8,15,23,24,27},
                {11,21,25,29,33},
        };
        System.out.println(ksesm.kthSmallest(matrix,14));
    }
    public int kthSmallest(int[][] matrix, int k) {
        // heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k + 1, (a, b) -> b - a);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                maxHeap.offer(matrix[i][j]);
                if(maxHeap.size() > k) maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }

//    public int kthSmallest(int[][] matrix, int k) {
//        // heap
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k+1, (a, b) -> a[2] - b[2]);
//        for(int j = 0; j < Math.min(k, matrix[0].length); j++) {
//            minHeap.offer(new int[] {0, j, matrix[0][j]});
//        }
//        // for k loop find the result
//        for(int i = 0; i < k-1; i++) {
//            int[] cur = minHeap.poll();
//            if(cur[0] + 1 < matrix.length) {
//                minHeap.offer(new int[] {cur[0] + 1, cur[1], matrix[cur[0] + 1][cur[1]]});
//            }
//        }
//        return minHeap.poll()[2];
//    }
}
