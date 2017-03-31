package leetcode;

/**
 * Created by lyk on 2017/3/31.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class HouseRobberII {

    public static void main(String[] args) {
        HouseRobberII hrii = new HouseRobberII();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,4,5,6,7,8,9,2,3,4,5};
        System.out.println(hrii.rob(nums));
    }
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        int max1 = robHelper(nums, 0, nums.length-2);
        int max2 = robHelper(nums, 1, nums.length-1);

        return Math.max(max1, max2);
    }

    public int robHelper(int[] nums, int i, int j){
        if(i==j){
            return nums[i];
        }

        int[] dp = new int[nums.length];
        dp[i]=nums[i];
        dp[i+1]=Math.max(nums[i+1], dp[i]);

        for(int k=i+2; k<=j; k++){
            dp[k]=Math.max(dp[k-1], dp[k-2]+nums[k]);
        }

        return dp[j];
    }
}
