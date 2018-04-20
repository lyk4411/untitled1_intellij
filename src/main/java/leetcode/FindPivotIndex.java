package leetcode;

/**
 * Created by lyk on 2018-4-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex fpi = new FindPivotIndex();
        int[] nums1 = new int[]{1, 7, 3, 6, 5, 6};
        int[] nums2 = new int[]{1, 2, 3};
        System.out.println(fpi.pivotIndex(nums1));
        System.out.println(fpi.pivotIndex(nums2));
    }
}
