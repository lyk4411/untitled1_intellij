package leetcode;

/**
 * Created by lyk on 2017/6/26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PatchingArray {
    public static void main(String[] args) {
        PatchingArray pa = new PatchingArray();
        int[] nums1 = new int[]{3,5};
        int[] nums2 = new int[]{1,5,10};
        System.out.println(pa.minPatches(nums1,6));
        //System.out.println(pa.minPatches(nums2,20));
    }

    public static int minPatches(int[] nums, int n) {
        long miss = 1;
        int res = 0;
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
                //System.out.println("nums[i]:" + nums[i - 1]);
            } else {
                miss += miss;
                ++res;
                //System.out.println("miss: " + miss);
                //System.out.println("res: " + res);
            }
        }
        return res;
    }
}
