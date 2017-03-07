package leetcode;

/**
 * Created by lyk on 2017/3/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int[] nums = new int[]{1,2,3,4,1,2,3};
        int[] nums1 = new int[]{1,2,3,4,1,2,3,5,1};

        System.out.println(sn.singleNumber(nums));
        System.out.println(sn.singleNumber(nums1));

    }
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i<nums.length; i++)
        {
            result ^=nums[i];
        }
        return result;
    }
}
