package leetcode;

import java.util.*;

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

//    public List<List<Integer>> subsetsWithDup(int[] S) {
//        if (S == null)
//            return null;
//
//        Arrays.sort(S);
//
//        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
//
//        for (int i = 0; i < S.length; i++) {
//            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
//
//            //get sets that are already in result
//            for (ArrayList<Integer> a : result) {
//                temp.add(new ArrayList<Integer>(a));
//            }
//
//            //add S[i] to existing sets
//            for (ArrayList<Integer> a : temp) {
//                a.add(S[i]);
//            }
//
//            //add S[i] only as a set
//            ArrayList<Integer> single = new ArrayList<Integer>();
//            single.add(S[i]);
//            temp.add(single);
//
//            result.addAll(temp);
//        }
//
//        //add empty set
//        result.add(new ArrayList<Integer>());
//        List<List<Integer>> al = new ArrayList<List<Integer>>();
//        for (ArrayList<Integer> r:result) {
//            al.add(r);
//        }
//        return al;
//    }
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
