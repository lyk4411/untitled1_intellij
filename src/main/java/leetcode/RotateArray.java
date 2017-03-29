package leetcode;

/**
 * Created by lyk on 2017/3/29.
 * Package name: leetcode
 * Porject name: untitled1
 */
//
//The basic idea is that, for example, nums = [1,2,3,4,5,6,7] and k = 3,
// first we reverse [1,2,3,4], it becomes[4,3,2,1]; then we reverse[5,6,7],
// it becomes[7,6,5], finally we reverse the array as a whole, it
// becomes[4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4].
//
//Reverse is done by using two pointers, one point at the head and the other
// point at the tail, after switch these two, these two pointers move one
// position towards the middle.
public class RotateArray {
    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        ra.rotate(nums,4);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }
    public void rotate(int[] nums, int k) {

        if(nums == null || nums.length < 2){
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    private void reverse(int[] nums, int i, int j) {
        int tmp = 0;
        while (i < j) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
