package leetcode;

/**
 * Created by lyk on 2017/3/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class JumpGame {
    public  static  void main(String[] args) {
        JumpGame jg = new JumpGame();
        int[] a = new int[]{1,2,3,1,1,1,0,3,4};
        int[] b = new int[]{1,2,3,5,1,2,0,0,3,4};
        System.out.println(jg.canJump(a));
        System.out.println(jg.canJump(b));
    }
    public boolean canJump(int[] nums) {
        int reach = 0;
        int i = 0;
        for ( ; i < nums.length && i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
        }
        return (i == nums.length);
    }
}
