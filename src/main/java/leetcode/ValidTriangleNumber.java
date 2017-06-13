package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/6/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ValidTriangleNumber {
    public static void main(String[] args) {
        ValidTriangleNumber vtn = new ValidTriangleNumber();
        int[] nums = new int[]{2,2,3,4,5,6,7};
        System.out.println(vtn.triangleNumber(nums));
    }
    public  int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0, n = nums.length;
        for (int i=n-1;i>=2;i--) {
            int l = 0, r = i-1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    count += r-l;
                    r--;
                }
                else l++;
            }
        }
        return count;
    }
}
