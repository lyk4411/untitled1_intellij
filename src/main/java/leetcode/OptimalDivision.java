package leetcode;

/**
 * Created by lyk on 2017/6/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class OptimalDivision {
    public static void main(String[] args) {
        OptimalDivision od = new OptimalDivision();
        int[] nums = new int[]{1000,10,2,200,10};
        System.out.println(od.optimalDivision(nums));
    }
    public String optimalDivision(int[] nums) {
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i == 1 && nums.length > 2) {
                builder.append("/(").append(nums[i]);
            } else {
                builder.append("/").append(nums[i]);
            }
        }
        return nums.length > 2 ? builder.append(")").toString() : builder.toString();
    }
}
