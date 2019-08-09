package leetcode;

/**
 * Created by lyk on 2019-8-9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PartitionArrayintoDisjointIntervals {
    public int partitionDisjoint(int[] A) {
        int N = A.length;
        int[] maxleft = new int[N];
        int[] minright = new int[N];

        int m = A[0];
        for (int i = 0; i < N; ++i) {
            m = Math.max(m, A[i]);
            maxleft[i] = m;
        }

        m = A[N-1];
        for (int i = N-1; i >= 0; --i) {
            m = Math.min(m, A[i]);
            minright[i] = m;
        }

        for (int i = 1; i < N; ++i)
            if (maxleft[i-1] <= minright[i])
                return i;

        throw null;
    }

    public static void main(String[] args) {
        PartitionArrayintoDisjointIntervals padi = new PartitionArrayintoDisjointIntervals();
        System.out.println(padi.partitionDisjoint(new int[]{5,0,3,8,6}));
        System.out.println(padi.partitionDisjoint(new int[]{1,1,1,0,6,12}));
    }
}
