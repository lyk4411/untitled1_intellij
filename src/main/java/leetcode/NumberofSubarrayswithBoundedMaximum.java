package leetcode;

/**
 * Created by lyk on 2018-7-3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberofSubarrayswithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int left = 0, count = 0, res = 0;
        for (int right = 0; right < A.length; ++right) {
            if (A[right] >= L && A[right] <= R) {   // A[right] is in the range
                res += (right - left + 1);
                count = (right - left + 1);
            }
            else if (A[right] < L) {                // A[right] is below L, but can be included in the range
                res += count;
            }
            else {                                  // A[right] is above R, so we have to clean the range
                left = right + 1;
                count = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberofSubarrayswithBoundedMaximum nsbm =
                new NumberofSubarrayswithBoundedMaximum();
        System.out.println(nsbm.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }
}
