package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lyk on 2017/5/22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class IncreasingSubsequences {
    public static void main(String[] args) {
        IncreasingSubsequences is = new IncreasingSubsequences();
        int[] nums = new int[]{1,2,3,4,4,3,2,5};
        System.out.println(is.findSubsequences(nums));
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        List<Integer> holder = new ArrayList<Integer>();
        findSequence(result,holder,0,nums);
        List<List<Integer>> res = new ArrayList<>(result);
        return res;
    }

    private void findSequence(Set<List<Integer>> result, List<Integer> holder, int start, int[] nums) {
        if(holder.size() > 1){
            result.add(new ArrayList(holder));
        }
        for (int i = start; i < nums.length; i++) {
            if(holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]){
                holder.add(nums[i]);
                findSequence(result,holder,i + 1,nums);
                holder.remove(holder.size() - 1);
            }
        }
    }
}
