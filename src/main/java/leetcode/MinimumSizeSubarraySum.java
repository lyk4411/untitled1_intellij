package leetcode;

/**
 * Created by lyk on 2017/4/1.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,1000};
        System.out.println(msss.minSubArrayLen(100,nums));
    }
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int i=0;
        int j=0;
        int sum=0;

        int minLen = Integer.MAX_VALUE;

        while(j<nums.length){
            if(sum<s){
                sum += nums[j];
                j++;
            }else{
                minLen = Math.min(minLen, j-i);
                if(i==j-1)
                    return 1;

                sum -=nums[i];
                i++;
            }
        }

        while(sum>=s){
            minLen = Math.min(minLen, j-i);

            sum -=nums[i++];
        }

        return minLen==Integer.MAX_VALUE? 0: minLen;
    }
}
