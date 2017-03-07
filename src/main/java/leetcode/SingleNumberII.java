package leetcode;

/**
 * Created by lyk on 2017/3/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SingleNumberII {
    public static void main(String[] args) {
        SingleNumberII snii = new SingleNumberII();
        int[] nums = new int[]{1,1,1,2,2,2,3,3,3,7};
        System.out.println(snii.singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
