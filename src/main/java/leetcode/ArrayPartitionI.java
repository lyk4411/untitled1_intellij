package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/5/17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ArrayPartitionI {
    public static void main(String[] args) {
        ArrayPartitionI api = new ArrayPartitionI();
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(api.arrayPairSum(nums));
    }
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum=0;
        for(int i=0; i<nums.length; i+=2){
            sum += nums[i];
        }
        return sum;
    }
}
