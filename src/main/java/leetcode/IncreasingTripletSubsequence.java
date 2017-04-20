package leetcode;

/**
 * Created by lyk on 2017/4/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();
        int[] nums1 = new int[]{10,9,8,7,8,6,5,4,3,2,1,0};
        int[] nums2 = new int[]{10,9,8,7,8,6,5,4,3,2,1,9};
        System.out.println(its.increasingTriplet(nums1));
        System.out.println(its.increasingTriplet(nums2));
    }
    public boolean increasingTriplet(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int z = nums[i];

            if (x >= z) {
                x = z;// update x to be a smaller value
                //System.out.println("x:" + x);
            } else if (y >= z) {
                y = z; // update y to be a smaller value
                //System.out.println("y:" + y);
            } else {
                return true;
            }
        }

        return false;
    }
}
