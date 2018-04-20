package leetcode;

/**
 * Created by lyk on 2018-4-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (index != -1) {
                    return false;
                }
                index = i;
            }
        }
        return (index == -1) || (index == 0) || (index == nums.length - 2)
                || nums[index - 1] < nums[index + 1]
                || nums[index] < nums[index + 2];
    }

    public static void main(String[] args) {
        NondecreasingArray na = new NondecreasingArray();
        int[] nums1 = new int[]{4, 2, 3};
        int[] nums2 = new int[]{4, 2, 1};
        int[] nums3 = new int[]{2, 3, 3, 2, 4};
        int[] nums4 = new int[]{1, 2, 7, 4, 5};
        System.out.println(na.checkPossibility(nums1));
        System.out.println(na.checkPossibility(nums2));
        System.out.println(na.checkPossibility(nums3));
        System.out.println(na.checkPossibility(nums4));
    }
}
