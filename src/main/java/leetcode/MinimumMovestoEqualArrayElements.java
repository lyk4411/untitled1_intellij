package leetcode;

/**
 * Created by lyk on 2017/3/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumMovestoEqualArrayElements {
    public static void main(String[] args) {
        MinimumMovestoEqualArrayElements mmeae = new MinimumMovestoEqualArrayElements();
        int[] nums = new int[]{1,2,3,4,5,6,7,1,2,3,4,5,6,7};
        int[] nums1 = new int[]{1,2,2};

        System.out.println(mmeae.minMoves(nums));
        System.out.println(mmeae.minMoves(nums1));

    }
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }
}
