package leetcode;

/**
 * Created by lyk on 2017/5/11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        PartitionEqualSubsetSum pess = new PartitionEqualSubsetSum();
        System.out.println(pess.canPartition(new int[]{1,5,5,11}));
        //System.out.println(pess.canPartition(new int[]{1,5,5,12}));
        //System.out.println(pess.canPartition(new int[]{1,2,3,4}));
    }
    public boolean canPartition(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
            for (int k = 0; k < dp.length; k++) {
                System.out.print(dp[k] + ";");
            }
            System.out.println();
        }
        return dp[volumn];
    }
}
