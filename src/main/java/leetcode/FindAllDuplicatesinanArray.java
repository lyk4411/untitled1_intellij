package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/4/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindAllDuplicatesinanArray {
    public static void main(String[] args) {
        FindAllDuplicatesinanArray fada = new FindAllDuplicatesinanArray();
        int[] nums = new int[]{1,2,3,4,5,6,4,3,2,7,8,9,4,4};
        System.out.println(fada.findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));//res.add(nums[i]);
            nums[index] = -nums[index];
        }
        return res;
    }
}
