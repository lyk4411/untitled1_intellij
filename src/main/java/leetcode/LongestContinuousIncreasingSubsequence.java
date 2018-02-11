package leetcode;

/**
 * Created by lyk on 2018-2-11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence lcis =
                new LongestContinuousIncreasingSubsequence();
        int[] nums1 = new int[]{1,3,5,7,2,4,6,3,6,1};
        int[] nums2 = new int[]{2,2,2,2,2};
        System.out.println(lcis.findLengthOfLCIS(nums1));
        System.out.println(lcis.findLengthOfLCIS(nums2));

    }
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }
}
