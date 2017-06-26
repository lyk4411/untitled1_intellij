package leetcode;

/**
 * Created by lyk on 2017/6/26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PatchingArray {
    public static void main(String[] args) {
        PatchingArray pa = new PatchingArray();
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{1,5,10};
        System.out.println(pa.minPatches(nums1,6));
        System.out.println(pa.minPatches(nums2,20));
    }

    public static int minPatches(int[] nums, int n) {
        long max = 0;
        int cnt = 0;
        for (int i = 0; max < n;) {
            if (i >= nums.length || max < nums[i] - 1) {
                max += max + 1;
                cnt++;
            } else {
                max += nums[i];
                i++;
            }
        }
        return cnt;
    }
}
