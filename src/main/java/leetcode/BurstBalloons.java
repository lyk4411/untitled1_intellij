package leetcode;

/**
 * Created by lyk on 2017/6/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BurstBalloons {
    public static void main(String[] args) {
        BurstBalloons bb = new BurstBalloons();
        int[] nums1 = new int[]{1,3,5,8};
        int[] nums2 = new int[]{3,1,5,8};
        System.out.println(bb.maxCoins(nums1));
        System.out.println(bb.maxCoins(nums2));
    }
    // 我们维护一个二维动态数组dp，其中dp[i][j]表示打爆区间[i,j]中的所有气球能得到的最多金币。
    // 题目中说明了边界情况，当气球周围没有气球的时候，旁边的数字按1算，这样我们可以在原数组
    // 两边各填充一个1，这样方便于计算。这道题的最难点就是找递归式，如下所示：
    // dp[i][j] = max(dp[i][j], nums[i - 1]*nums[k]*nums[j + 1] + dp[i][k - 1] + dp[k + 1][j])
    //       ( i ≤ k ≤ j )
    //有了递推式，我们可以写代码，我们其实只是更新了dp数组的右上三角区域，
    // 我们最终要返回的值存在dp[1][n]中，其中n是两端添加1之前数组nums的个数。
    // 参见代码如下：

    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length ; j++) {
                System.out.print(dp[i][j] + " = ");
            }
            System.out.println();
        }

        return dp[1][n - 1];
    }
}
