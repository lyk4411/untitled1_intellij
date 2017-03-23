package leetcode;

/**
 * Created by lyk on 2017/3/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();
        int[] nums = new int[]{1,2,3,-7,8,5,-5,0,6,7,2};
        System.out.println(mps.maxProduct(nums));
    }
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = min[0] = nums[0];
        int result = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                max[i]=Math.max(nums[i], max[i-1]*nums[i]);
                min[i]=Math.min(nums[i], min[i-1]*nums[i]);
            }else{
                max[i]=Math.max(nums[i], min[i-1]*nums[i]);
                min[i]=Math.min(nums[i], max[i-1]*nums[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }
}
