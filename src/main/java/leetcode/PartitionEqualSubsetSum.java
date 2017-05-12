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
        if(nums.length==0) return false;
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%2==1) return false;
        sum=sum/2;
        int[][] dp=new int[nums.length+1][sum+1];
        for(int i=0;i<=nums.length;i++){
            for(int j=0;j<=sum;j++){
                if(i==0) //表示前0个数，所以价值均为0；
                    dp[i][j]=0;
                    //在装第i-1个数时，先判断剩余容量j是否大于nums[i-1]
                else if(j<nums[i-1]) dp[i][j]=dp[i-1][j]; //小于表示空间不够，所以维持不变
                else{
                    //空间够，就通过比较大小来判断是否该放入第i-1个数
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i-1]]+nums[i-1]);
                }
            }
        }
        return dp[nums.length][sum]==sum;
    }
//    public boolean canPartition(int[] nums) {
//        // check edge case
//        if (nums == null || nums.length == 0) {
//            return true;
//        }
//        // preprocess
//        int volumn = 0;
//        for (int num : nums) {
//            volumn += num;
//        }
//        if (volumn % 2 != 0) {
//            return false;
//        }
//        volumn /= 2;
//        // dp def
//        boolean[] dp = new boolean[volumn + 1];
//        // dp init
//        dp[0] = true;
//        // dp transition
//        for (int i = 1; i <= nums.length; i++) {
//            for (int j = volumn; j >= nums[i-1]; j--) {
//                dp[j] = dp[j] || dp[j - nums[i-1]];
//            }
////            for (int k = 0; k < dp.length; k++) {
////                System.out.print(dp[k] + ";");
////            }
////            System.out.println();
//        }
//        return dp[volumn];
//    }
}
