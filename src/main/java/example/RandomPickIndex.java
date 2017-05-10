package example;

import java.util.Random;

/**
 * Created by lyk on 2017/5/10.
 * Package name: example
 * Porject name: untitled1
 */
public class RandomPickIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,3};
        RandomPickIndex rpi = new RandomPickIndex(nums);
        System.out.println(rpi.pick(3));
        System.out.println(rpi.pick(3));
        System.out.println(rpi.pick(3));

    }
    int[] nums;
    Random rand;
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    public int pick(int target) {
        int total = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                // randomly select an int from 0 to the nums of target. If x equals 0, set the res as the current index. The probability is always 1/nums for the latest appeared number. For example, 1 for 1st num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
                int x = rand.nextInt(++total);
                res = x == 0 ? i : res;
            }
        }
        return res;
    }
}
