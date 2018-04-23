package leetcode;

/**
 * Created by lyk on 2018-4-23.
 * Package name: leetcode
 * Porject name: untitled1
 */

//        这道题给了我们两个数组A和B，让我们返回连个数组的最长重复子数组。
//        那么如果我们将数组换成字符串，实际这道题就是求Longest Common Substring
//        的问题了，而貌似LeetCode上并没有这种明显的要求最长相同子串的题，注意
//        需要跟最长子序列Longest Common Subsequence区分开，关于最长子序列会
//        在follow up中讨论。好，先来看这道题，对于这种求极值的问题，DP是不二
//        之选，我们使用一个二维的DP数组，其中dp[i][j]表示数组A的前i个数字和数组
//        B的前j个数字的最长子数组的长度，如果dp[i][j]不为0，则A中第i个数组和B中
//        第j个数字必须相等，比对于这两个数组[1,2,2]和[3,1,2]，我们的dp数组为：
//          3 1 2
//        1 0 1 0
//        2 0 0 2
//        2 0 0 1
//        我们注意观察，dp值不为0的地方，都是当A[i] == B[j]的地方，而且还要加
//       上左上方的dp值，即dp[i-1][j-1]，所以当前的dp[i][j]就等于dp[i-1][j-1] + 1，
//       而一旦A[i] != B[j]时，直接赋值为0，不用多想，因为子数组是要连续的，一旦
//       不匹配了，就不能再增加长度了。我们每次算出一个dp值，都要用来更新结果res，
//       这样就能得到最长相同子数组的长度了，参见代码如下：

//        Intuition and Algorithm
//
//        Since a common subarray of A and B must start at some A[i] and B[j],
//        let dp[i][j] be the longest common prefix of A[i:] and B[j:]. Whenever
//        A[i] == B[j], we know dp[i][j] = dp[i+1][j+1] + 1. Also, the answer is
//        max(dp[i][j]) over all i, j.
//
//        We can perform bottom-up dynamic programming to find the answer based
//        on this recurrence. Our loop invariant is that the answer is already
//        calculated correctly and stored in dp for any larger i, j.
public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumLengthofRepeatedSubarray mlrs =
                new MaximumLengthofRepeatedSubarray();
        int[] nums1 = new int[]{1,2,3,2,1};
        int[] nums2 = new int[]{3,2,1,4,7};
        System.out.println(mlrs.findLength(nums1, nums2));
    }
}
