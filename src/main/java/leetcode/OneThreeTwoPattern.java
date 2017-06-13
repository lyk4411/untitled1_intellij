package leetcode;

import java.util.Stack;

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
    //这道题给我们了一个数组，让我们找到132的模式，就是第一个数小于第二第三个数，
    // 且第三个数小于第二个数。那么我们就按顺序来找这三个数，首先我们来找第一个数，
    // 这个数需要最小，那么我们如果发现当前数字大于等于后面一个数字，我们就往下继
    // 续遍历，直到当前数字小于下一个数字停止。然后我们找第二个数字，这个数字需要
    // 最大，那么如果我们发现当前数字小于等于下一个数字就继续遍历，直到当前数字大
    // 于下一个数字停止。最后就找第三个数字，我们验证这个数字是否在之前两个数字的
    // 中间，如果没有找到，我们就从第二个数字的后面一个位置继续开始重新找这三个
    // 数字，参见代码如下：
//    public boolean find132pattern(int[] nums) {
//        if(nums.length<3) return false;
//        Integer low = null, high = null;
//        int start = 0, end = 0;
//        while(start<nums.length-1){
//            while(start<nums.length-1 && nums[start]>=nums[start+1]) start++;
//            // start is lowest now
//            int m = start+1;
//            while(m<nums.length-1 && nums[m]<=nums[m+1]) m++;
//            // m is highest now
//            int j = m+1;
//            while(j<nums.length){
//                if(nums[j]>nums[start] && nums[j]<nums[m]) return true;
//                j++;
//            }
//            start = m+1;
//        }
//        return false;
//    }




    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack();
        int third = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < third) return true;
            else {
                while (!stack.empty() && nums[i] > stack.peek()){
                    third = stack.peek();
                    stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
