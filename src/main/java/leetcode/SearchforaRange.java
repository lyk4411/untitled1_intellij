package leetcode;

/**
 * Created by lyk on 2017/3/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SearchforaRange {
    public static void main(String[] args) {
        SearchforaRange sr = new SearchforaRange();
        int[] nums = new int[]{1,2,3,4,5,6,6,7,8,9,9,10};
        int[] results = sr.searchRange(nums,6);
        for (int i :results) {
            System.out.println(i);
        }

    }
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }

        int[] arr= new int[2];
        arr[0]=-1;
        arr[1]=-1;

        binarySearch(nums, 0, nums.length-1, target, arr);

        return arr;
    }

    public void binarySearch(int[] nums, int left, int right, int target, int[] arr){
        if(right<left)
            return;

        if(nums[left]==nums[right] && nums[left]==target){
            arr[0]=left;
            arr[1]=right;
            return;
        }

        int mid = left+(right-left)/2;


        if(nums[mid]<target){
            binarySearch(nums, mid+1, right, target, arr);
        }else if(nums[mid]>target){
            binarySearch(nums, left, mid-1, target, arr);
        }else{
            arr[0]=mid;
            arr[1]=mid;

            //handle duplicates - left
            int t1 = mid;
            while(t1 >left && nums[t1]==nums[t1-1]){
                t1--;
                arr[0]=t1;
            }

            //handle duplicates - right
            int t2 = mid;
            while(t2 < right&& nums[t2]==nums[t2+1]){
                t2++;
                arr[1]=t2;
            }
            return;
        }
    }
}
