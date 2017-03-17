package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyk on 2017/3/17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SubsetsII {
    public static void main(String[] args) {
        SubsetsII subsets = new SubsetsII();
        int[] nums = new int[]{1,2,2};
        System.out.println(subsets.subsetsWithDup(nums));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> al = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        Arrays.sort(nums);
        backtrack(al,tempList,nums,0);
        return al;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<Integer>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list,tempList,nums,i + 1);
            tempList.remove(tempList.size() - 1);

            while (i+1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }
}
