package leetcode;

/**
 * Created by lyk on 2018-9-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int x: A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return Math.max(0, max - min - 2*K);
    }

    public static void main(String[] args) {
        SmallestRangeI sri = new SmallestRangeI();
        int[] a1 = new int[]{0, 10};
        System.out.println(sri.smallestRangeI(a1, 2));
    }
}
