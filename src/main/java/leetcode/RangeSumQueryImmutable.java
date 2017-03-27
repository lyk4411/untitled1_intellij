package leetcode;

/**
 * Created by lyk on 2017/3/27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,-3,4,5,-6,5,4,8,9,1,0,-12,1};
        RangeSumQueryImmutable rsqi = new RangeSumQueryImmutable(a);
        System.out.println(rsqi.sumRange(1,7));
    }
    int[] nums;

    public RangeSumQueryImmutable(int[] nums) {
        for(int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];

        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return nums[j];

        return nums[j] - nums[i - 1];
    }
}
