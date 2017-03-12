package main.java.leetcode;

import java.util.Arrays;

/**
 * Created by liuyongkai on 17/3/12.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] nums = new int[]{1,2,5,6};
        System.out.println(tsc.threeSumClosest(nums,6));
    }
    public int threeSumClosest(int[] nums, int target) {
        int left,right;
        Arrays.sort(nums);//排序
        int sum = Integer.MAX_VALUE;
        int minusWithTarget = Integer.MAX_VALUE;
        int sumWithTriple;
        int minus;

        for(int i = 0;i<nums.length;i++){
            if(i-1>=0&&nums[i]==nums[i-1])
                continue;
            left = i+1;right = nums.length-1;
            while(left<right){
                sumWithTriple = nums[i]+nums[left]+nums[right];
                minus = sumWithTriple-target;
                if(minus==0){
                    return sumWithTriple;
                }else if(minus>0){
                    if(minus<minusWithTarget){
                        minusWithTarget = minus;
                        sum = sumWithTriple;
                    }
                    right--;
                }else {
                    if(-minus<minusWithTarget){
                        minusWithTarget = -minus;
                        sum=sumWithTriple;
                    }
                    left++;
                }
            }
        }
        return sum;
    }
}
