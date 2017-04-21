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
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}
