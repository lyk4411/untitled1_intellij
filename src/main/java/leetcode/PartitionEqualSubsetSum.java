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

//    1.解题思路
//    此问题属于动态规划中的背包问题。
//    背包问题：假设有n个宝石，只有一个容量为C的背包，且第i个宝石所对应的重量和价值为w[i]和v[i],求装哪些宝石可以获得最大的价值收益？
//    思路：我们将n个宝石进行编号，0,1,2...n-1,寻找DP的状态和状态转移方程。我们用dpij表示将前i个宝石装到剩余容量为j的背包中，那么久很容易得到状态转移方程了。（宝石从0开始编号，所以dpij是在考虑第i-1个宝石装包的情况，当然我们要先初始化前0个宝石装包的情况，即dp0=0,因为不装任何宝石，所以无论如何价值都为0.）
//
//    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i-1]]+v[i-1])
//    背包无法再装下第i-1个宝石-> dp[i-1][j];
//    继续将第i-1个宝石装包->  dp[i-1][j-w[i-1]]+v[i-1]。
//
//    搞清楚了背包问题，这个Partition Equal Subset Sum的题目就迎刃而解了。
//            1). 判断数组中所有数的和是否为偶数，因为奇数是不可能有解的；
//            2). 根据背包问题，取前i个数，体积为j的情况下，
//
//    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i-1]]+nums[i-1])
//
//            3).如果最后dpnums.length=sum/2,则返回true.
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
