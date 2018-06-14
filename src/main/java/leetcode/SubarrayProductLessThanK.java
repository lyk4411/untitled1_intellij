package leetcode;

/**
 * Created by lyk on 2018-6-14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK spltk = new SubarrayProductLessThanK();
        System.out.println(spltk.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
