package leetcode;

/**
 * Created by lyk on 2017/3/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray rdsa = new RemoveDuplicatesfromSortedArray();
        int[] nums = new int[]{1,1,1,2,3,4,5,5,5,5,5,6};
        System.out.println(rdsa.removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[" +i +"]:" + nums[i]);
        }
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        int j=0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=nums[j]) {
                nums[++j]=nums[i];
            }
        }
        return ++j;
    }
}
