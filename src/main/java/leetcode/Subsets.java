package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyk on 2017/3/16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Subsets {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets.subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums) {
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
        }
    }
}
