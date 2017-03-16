package leetcode;

/**
 * Created by lyk on 2017/3/16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII rdsaii = new RemoveDuplicatesfromSortedArrayII();
        int[] nums = new int[]{1,2,2,3,3,3,3,3,4,6,6,6,7};
        System.out.println(rdsaii.removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
