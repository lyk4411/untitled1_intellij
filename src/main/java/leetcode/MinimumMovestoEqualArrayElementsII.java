package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/6/14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumMovestoEqualArrayElementsII {
    public static void main(String[] args) {
        MinimumMovestoEqualArrayElementsII mmii = new MinimumMovestoEqualArrayElementsII();
        int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println(mmii.minMoves2(nums));
    }
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int count = 0;
        while(i < j){
            count += nums[j]-nums[i];
            i++;
            j--;
        }
        return count;
    }
}
