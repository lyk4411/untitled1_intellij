package leetcode;

/**
 * Created by lyk on 2017/3/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SingleNumberIII {
    public static void main(String[] args) {
        SingleNumberIII sniii = new SingleNumberIII();
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};

        //sniii.singleNumber(nums);
        for (int i = 0; i < 2; i++) {
            System.out.println("########" +sniii.singleNumber(nums)[i]);
        }
    }
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int diff = 0;
        for(int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        //System.out.println("diff:"+diff);
        for(int num : nums) {
            if((num & diff) == 0) {
                System.out.println("num111:" + num);
                ans[0] ^= num;
                System.out.println("ans[0]:" + ans[0]);
            }else {
                System.out.println("num222:" + num);
                ans[1] ^= num;
                System.out.println("ans[1]:" + ans[1]);
            }
        }
        return ans;
    }
}
