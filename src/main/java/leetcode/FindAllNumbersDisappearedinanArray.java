package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/3/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindAllNumbersDisappearedinanArray {
    public static void main(String[] args) {
        FindAllNumbersDisappearedinanArray fanda = new FindAllNumbersDisappearedinanArray();
        List<Integer> list = fanda.findDisappearedNumbers(new int[]{1,2,3,3,4,6,7,7,9,9});
        System.out.println(list);
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}