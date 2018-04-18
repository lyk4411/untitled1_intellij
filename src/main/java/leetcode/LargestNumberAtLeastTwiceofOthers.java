package leetcode;

/**
 * Created by lyk on 2018-4-18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceofOthers lnalto =
                new LargestNumberAtLeastTwiceofOthers();
        int[] nums1 = new int[]{3, 6, 1, 0};
        int[] nums2 = new int[]{1, 2, 3, 4};
        System.out.println(lnalto.dominantIndex(nums1));
        System.out.println(lnalto.dominantIndex(nums2));
    }
}
