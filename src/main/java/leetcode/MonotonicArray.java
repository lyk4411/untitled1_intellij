package leetcode;

/**
 * Created by lyk on 2018-9-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        return increasing(A) || decreasing(A);
    }

    public boolean increasing(int[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i] > A[i+1]) return false;
        return true;
    }

    public boolean decreasing(int[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i] < A[i+1]) return false;
        return true;
    }

    public static void main(String[] args) {
        MonotonicArray ma = new MonotonicArray();
        System.out.println(ma.isMonotonic(new int[]{1,2,3,4}));
        System.out.println(ma.isMonotonic(new int[]{1,2,3,4,3}));
    }
}
