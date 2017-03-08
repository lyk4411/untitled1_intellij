package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/3/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int[] nums = new int[]{0,1,2,3,4,5,6,7,8,10};
        System.out.println(mn.missingNumber(nums));
        System.out.println(mn.missingNumber1(nums));

    }
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int counter;
        for (counter = 0; counter < nums.length; counter++) {
            if (counter != nums[counter]) {
                return counter;
            }
        }
        return counter;
    }
    public int missingNumber1(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res ^= (i+1) ^ nums[i];
        }
        return res;
    }
}
