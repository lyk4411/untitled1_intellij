package leetcode;

/**
 * Created by lyk on 2017/7/11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SingleElementinaSortedArray {
    public static void main(String[] args) {
        SingleElementinaSortedArray sesa = new SingleElementinaSortedArray();
        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
        System.out.println(sesa.singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        // binary search
        int n=nums.length, lo=0, hi=n/2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2*m]!=nums[2*m+1]) hi = m;
            else lo = m+1;
        }
        return nums[2*lo];
    }
}
