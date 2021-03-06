package leetcode;

/**
 * Created by lyk on 2017/5/25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        ProductofArrayExceptSelf paes = new ProductofArrayExceptSelf();
        int[] nums = new int[]{2,3,4,5};
        int[] results = paes.productExceptSelf(nums);
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " :");
        }
        System.out.println();
    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " :");
        }
        System.out.println();

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
