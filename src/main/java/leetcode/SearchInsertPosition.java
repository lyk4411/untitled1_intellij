package leetcode;

/**
 * Created by lyk on 2017/3/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] nums = new int[]{1,3,5,7,9,11};
        System.out.println(sip.searchInsert(nums,6));
    }

    public int searchInsert(int[] nums, int target) {
        if(nums == null){
            return  -1;
        }
        if(target >nums[nums.length - 1 ]){
            return nums.length;
        }
        int i=0;
        int j=nums.length;
        while(i<j){
            int m=(i+j)/2;
            if(target > nums[m]){
                i=m+1;
            }else {
                j=m;
            }
        }
        return j;
    }
}