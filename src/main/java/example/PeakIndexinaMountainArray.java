package example;

/**
 * Created by lyk on 2018-6-19.
 * Package name: example
 * Porject name: untitled1
 */
public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    public static void main(String[] args) {
        PeakIndexinaMountainArray pima = new PeakIndexinaMountainArray();
        System.out.println(pima.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(pima.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }
}
