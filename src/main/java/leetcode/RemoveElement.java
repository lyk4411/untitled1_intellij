package leetcode;

/**
 * Created by lyk on 2017/3/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] nums = new int[]{1,2,2,3,4,3,4,3,4};
        System.out.println(re.removeElement(nums,4));
    }
        public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (j < nums.length){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
