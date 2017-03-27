package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/3/27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = new int[]{1,2,3,6,4,3,9,1,2,7,8,0,4,2,6,8,0,2,4,8,0,1,4,6,7,8,9};
        int[] num1 = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lis.lengthOfLIS(nums));
        System.out.println(lis.lengthOfLIS(num1));
    }

    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int[] max = new int[nums.length];
        Arrays.fill(max, 1);

        int result = 1;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    max[i]= Math.max(max[i], max[j]+1);

                }
            }
            result = Math.max(max[i], result);
        }

        return result;
    }

//    public int lengthOfLIS(int[] nums) {
//        if(nums==null || nums.length==0)
//            return 0;
//
//        ArrayList<Integer> list = new ArrayList<Integer>();
//
//        for(int num: nums){
//            if(list.size()==0 || num>list.get(list.size()-1)){
//                list.add(num);
//            }else{
//                int i=0;
//                int j=list.size()-1;
//
//                while(i<j){
//                    int mid = (i+j)/2;
//                    if(list.get(mid) < num){
//                        i=mid+1;
//                    }else{
//                        j=mid;
//                    }
//                }
//
//                list.set(j, num);
//            }
//        }
//
//        return list.size();
//    }
}
