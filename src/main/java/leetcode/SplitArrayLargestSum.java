package leetcode;

/**
 * Created by lyk on 2017/6/26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        SplitArrayLargestSum sals = new SplitArrayLargestSum();
        int[] nums = new int[]{7,2,5,10,8};
        System.out.println(sals.splitArray(nums,2));
    }

//    public int splitArray(int[] nums, int m) {
//        int max = 0; long sum = 0;
//        for (int num : nums) {
//            max = Math.max(num, max);
//            sum += num;
//        }
//        if (m == 1) return (int)sum;
//        //binary search
//        long l = max; long r = sum;
//        while (l <= r) {
//            long mid = (l + r)/ 2;
//            if (valid(mid, nums, m)) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return (int)l;
//    }
//    public boolean valid(long target, int[] nums, int m) {
//        int count = 1;
//        long total = 0;
//        for(int num : nums) {
//            total += num;
//            if (total > target) {
//                total = num;
//                count++;
//                if (count > m) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }


    public int splitArray(int[] nums, int m)
    {
        int n = nums.length;
        int[] sums = new int[n + 1];
        int dp[][] = new int[m + 1][n + 1];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print("dp[" + i + "][" +j + "]:" + dp[i][j] + "  :");
//            }
//            System.out.println();
//        }

        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = sums[j];
            dp[1][j] = sums[j];
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print("dp[" + i + "][" +j + "]:" + dp[i][j] + "  :");
//            }
//            System.out.println();
//        }

//        for (int i = 0; i < sums.length; i++) {
//            System.out.print("sums[" + i + "]" + sums[i] + "  :");        }
//        System.out.println();

        for (int i = 2; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                for (int k = i - 1; k < j; ++k) {
                    int val = Math.max(dp[i - 1][k], sums[j] - sums[k]);
                    dp[i][j] = Math.min(dp[i][j], val);
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print("dp[" + i + "][" +j + "]:" + dp[i][j] + "  :");
//            }
//            System.out.println();
//        }
        return dp[m][n];
    }
}
