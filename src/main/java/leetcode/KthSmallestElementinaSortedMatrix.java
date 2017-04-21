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
                {3,6,8,9,0},
                {8,5,3,1,7},
                {1,2,5,9,3},
        };
        System.out.println(ksesm.kthSmallest(matrix,4));
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
}
