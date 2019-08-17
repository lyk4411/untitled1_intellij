package leetcode;

import java.util.TreeMap;

/**
 * Created by lyk on 2019-8-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class OddEvenJump {
    public int oddEvenJumps(int[] A) {
        int N = A.length;
        if (N <= 1) return N;
        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];
        odd[N-1] = even[N-1] = true;

        TreeMap<Integer, Integer> vals = new TreeMap();
        vals.put(A[N-1], N-1);
        for (int i = N-2; i >= 0; --i) {
            int v = A[i];
            if (vals.containsKey(v)) {
                odd[i] = even[vals.get(v)];
                even[i] = odd[vals.get(v)];
            } else {
                Integer lower = vals.lowerKey(v);
                Integer higher = vals.higherKey(v);

                if (lower != null)
                    even[i] = odd[vals.get(lower)];
                if (higher != null) {
                    odd[i] = even[vals.get(higher)];
                }
            }
            vals.put(v, i);
        }

        int ans = 0;
        for (boolean b: odd)
            if (b) ans++;
        return ans;
    }

    public static void main(String[] args) {
        OddEvenJump oej = new OddEvenJump();
        int[] A1 = new int[]{10,13,12,14,15};
        int[] A2 = new int[]{2,3,1,1,4};
        int[] A3 = new int[]{5,1,3,4,2};
        System.out.println(oej.oddEvenJumps(A1));
        System.out.println(oej.oddEvenJumps(A2));
        System.out.println(oej.oddEvenJumps(A3));
    }
}
