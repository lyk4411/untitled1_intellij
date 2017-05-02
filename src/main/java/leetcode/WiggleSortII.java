package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/5/2.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class WiggleSortII {
    public static void main(String[] args) {
        WiggleSortII wsii = new WiggleSortII();
        int[] nums = new int[]{1,2,3,4,5,6,5,4,3,2,1};
        wsii.wiggleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " =");
        }
        System.out.println();
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, mid = (n-1)/2, index = 0;
        int[] temp = new int[n];
        for (int i = 0; i <= mid; i++) {
            temp[index] = nums[mid-i];
            if (index+1 < n) {
                temp[index+1] = nums[n-1-i];
            }
            index += 2;
        }
        System.arraycopy(temp, 0, nums, 0, n);
    }
}
