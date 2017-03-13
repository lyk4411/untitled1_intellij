package leetcode;

/**
 * Created by lyk on 2017/3/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        SearchinRotatedSortedArray srsa = new SearchinRotatedSortedArray();
        int[] nums = new int[]{6,7,8,1,2,3,4,5};
        System.out.println(srsa.search(nums,0));
        System.out.println(srsa.search(nums,1));
        System.out.println(srsa.search(nums,2));
        System.out.println(srsa.search(nums,3));
        System.out.println(srsa.search(nums,4));
        System.out.println(srsa.search(nums,5));
        System.out.println(srsa.search(nums,6));
        System.out.println(srsa.search(nums,7));
        System.out.println(srsa.search(nums,8));
        System.out.println(srsa.search(nums,9));

    }
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
