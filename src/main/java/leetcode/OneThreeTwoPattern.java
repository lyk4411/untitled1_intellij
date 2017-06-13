package leetcode;

/**
 * Created by lyk on 2017/6/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class OneThreeTwoPattern {
    public static void main(String[] args) {
        OneThreeTwoPattern ottp = new OneThreeTwoPattern();
        int[] nums1 = new int[]{1,2,3,4,5};
        int[] nums2 = new int[]{1,3,2,5,4};
        System.out.println(ottp.find132pattern(nums1));
        System.out.println(ottp.find132pattern(nums2));
    }

    public boolean find132pattern(int[] nums) {
        if(nums.length<3) return false;
        Integer low = null, high = null;
        int start = 0, end = 0;
        while(start<nums.length-1){
            while(start<nums.length-1 && nums[start]>=nums[start+1]) start++;
            // start is lowest now
            int m = start+1;
            while(m<nums.length-1 && nums[m]<=nums[m+1]) m++;
            // m is highest now
            int j = m+1;
            while(j<nums.length){
                if(nums[j]>nums[start] && nums[j]<nums[m]) return true;
                j++;
            }
            start = m+1;
        }
        return false;
    }
}
