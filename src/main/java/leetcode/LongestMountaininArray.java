package leetcode;

/**
 * Created by lyk on 2019-7-26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestMountaininArray {
    public int longestMountain(int[] A) {
        int N = A.length;
        int ans = 0, base = 0;
        while (base < N) {
            int end = base;
            // if base is a left-boundary
            if (end + 1 < N && A[end] < A[end + 1]) {
                // set end to the peak of this potential mountain
                while (end + 1 < N && A[end] < A[end + 1]) end++;

                // if end is really a peak..
                if (end + 1 < N && A[end] > A[end + 1]) {
                    // set end to the right-boundary of mountain
                    while (end + 1 < N && A[end] > A[end + 1]) end++;
                    // record candidate answer
                    ans = Math.max(ans, end - base + 1);
                }
            }

            base = Math.max(end, base + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestMountaininArray lma = new LongestMountaininArray();
        int[] a1 = new int[]{2,1,4,7,3,2,5};
        int[] a2 = new int[]{2,2,2};
        System.out.println(lma.longestMountain(a1));
        System.out.println(lma.longestMountain(a2));
    }
}
