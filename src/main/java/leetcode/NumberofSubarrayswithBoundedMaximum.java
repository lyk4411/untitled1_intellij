package leetcode;

/**
 * Created by lyk on 2018-7-3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberofSubarrayswithBoundedMaximum {
//    思路：
//    我们定义[left, right]表示符合条件的合法区间，并且遍历数组A，根据A[right]的大小，可以分为三种情况进行处理：
//            1）A[right]在[L, R]区间内，所以此时我们拥有从[left, right]...到[right, right]一共(right - left + 1)个合法
//    的区间，所以我们更新res += (right - left + 1)，并且更新count的值（后面会有用）；
//    2）A[right]小于L，此时虽然A[right]不在[L, R]区间内，但是对于前面的count个合法区间，每个加上A[right]，仍然可以形成
//    合法的区间，所以res += count；
//    3）A[right] > R，此时所有包含A[right]的区间都将不再合法，所以我们更新左边界left = right + 1，并更新count = 0。
//    算法的空间复杂度为O(1)，时间复杂度为O(n)，应该是最优的空间和时间复杂度了。
//
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
