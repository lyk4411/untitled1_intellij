package leetcode;

/**
 * Created by lyk on 2018-7-16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums1 = new int[]{-1,0,3,5,9,12};
        int[] nums2 = new int[]{-1,0,3,5,9,12};
        System.out.println(bs.search(nums1, 9));
        System.out.println(bs.search(nums2, 2));
    }
}
