package leetcode;

import java.util.HashMap;

/**
 * Created by lyk on 2017/7/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ArithmeticSlicesIISubsequence {
    public static void main(String[] args) {
        ArithmeticSlicesIISubsequence ass = new ArithmeticSlicesIISubsequence();
        int[] A = new int[]{2, 4, 6, 8, 10};
        int[] B = new int[]{1, 2, 3, 4, 6, 7, 8, 10};
        System.out.println(ass.numberOfArithmeticSlices(A));
        System.out.println(ass.numberOfArithmeticSlices(B));
    }

    public int numberOfArithmeticSlices(int[] A) {
        int re = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[A.length];
        for(int i=0; i<A.length; i++) {
            maps[i] = new HashMap<>();
            int num = A[i];
            for(int j=0; j<i; j++) {
                if((long)num-A[j]>Integer.MAX_VALUE) continue;
                if((long)num-A[j]<Integer.MIN_VALUE) continue;
                int diff = num - A[j];
                int count = maps[j].getOrDefault(diff, 0);
                maps[i].put(diff, maps[i].getOrDefault(diff,0)+count+1);
                re += count;
            }
        }
        return re;
    }
}
