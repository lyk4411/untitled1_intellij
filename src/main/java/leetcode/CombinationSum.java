package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyk on 2017/3/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int target = 10;
        System.out.println(cs.combinationSum(nums,target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(candidates == null || candidates.length == 0) return result;

        ArrayList<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);

        combinationSum(candidates, target, 0, current, result);

        return result;
    }

    public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, List<List<Integer>> result){
        if(target == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            result.add(temp);
            return;
        }

        for(int i=j; i<candidates.length; i++){
            //System.out.println("[i:]" + i + "[j:]" + j);

            if(target < candidates[i])
                return;

            curr.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, curr, result);
            curr.remove(curr.size()-1);
        }
    }
}
