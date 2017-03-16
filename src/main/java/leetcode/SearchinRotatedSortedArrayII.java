package leetcode;

/**
 * Created by lyk on 2017/3/16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        SearchinRotatedSortedArrayII srsaii = new SearchinRotatedSortedArrayII();
        int[] nums = new int[]{8,9,10,1,2,3,4,5,6,7};
        System.out.println(srsaii.search(nums,0));
        System.out.println(srsaii.search(nums,1));
        System.out.println(srsaii.search(nums,2));
        System.out.println(srsaii.search(nums,3));
        System.out.println(srsaii.search(nums,4));
        System.out.println(srsaii.search(nums,5));
        System.out.println(srsaii.search(nums,6));
        System.out.println(srsaii.search(nums,7));
        System.out.println(srsaii.search(nums,8));
        System.out.println(srsaii.search(nums,9));
    }
    public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return true;

            if(nums[left]<nums[mid]){
                if(nums[left]<=target&& target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else if(nums[left]>nums[mid]){
                if(nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                left++;
            }
        }
        return false;
    }
}
