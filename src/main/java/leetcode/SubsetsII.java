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

//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        ArrayList<List<Integer>> al = new ArrayList<List<Integer>>();
//        List<Integer> tempList = new ArrayList<Integer>();
//        Arrays.sort(nums);
//        backtrack(al,tempList,nums,0);
//        return al;
//    }
//
//    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
//        list.add(new ArrayList<Integer>(tempList));
//        for (int i = start; i < nums.length; i++) {
//            tempList.add(nums[i]);
//            backtrack(list,tempList,nums,i + 1);
//            tempList.remove(tempList.size() - 1);
//
//            while (i+1 < nums.length && nums[i + 1] == nums[i]) {
//                i++;
//            }
//        }
//    }

    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null)
            return null;
        Arrays.sort(num);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();

        for (int i = num.length-1; i >= 0; i--) {

            //get existing sets
            if (i == num.length - 1 || num[i] != num[i + 1] || prev.size() == 0) {
                prev = new ArrayList<ArrayList<Integer>>();
                for (int j = 0; j < result.size(); j++) {
                    prev.add(new ArrayList<Integer>(result.get(j)));
                }
            }

            //add current number to each element of the set
            for (ArrayList<Integer> temp : prev) {
                temp.add(num[i]);
            }

            //add each single number as a set, only if current element is different with previous
            if (i == num.length - 1 || num[i] != num[i + 1]) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(num[i]);
                prev.add(temp);
            }

            //add all set created in this iteration
            for (ArrayList<Integer> temp : prev) {
                result.add(new ArrayList<Integer>(temp));
            }
        }

        //add empty set
        result.add(new ArrayList<Integer>());

        return result;
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
}
