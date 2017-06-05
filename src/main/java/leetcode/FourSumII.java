package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2017/6/5.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FourSumII {
    public static void main(String[] args) {
        FourSumII fsii = new FourSumII();
        int[] A = new int[]{1,2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};
        System.out.println(fsii.fourSumCount(A,B,C,D));
        int[] A1 = new int[]{1,2,1};
        int[] B1 = new int[]{-2,-1,-2};
        int[] C1 = new int[]{-1,2,-1};
        int[] D1 = new int[]{0,2,-1};
        System.out.println(fsii.fourSumCount(A1,B1,C1,D1));

    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<C.length; i++) {
            for(int j=0; j<D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res=0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                res += map.getOrDefault(-1 * (A[i]+B[j]), 0);
            }
        }

        return res;
    }
}
