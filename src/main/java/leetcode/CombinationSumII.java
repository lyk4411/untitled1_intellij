package leetcode;

import java.util.*;

/**
 * Created by lyk on 2017/3/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CombinationSumII {
    public static void main(String[] args) {
        CombinationSumII cs = new CombinationSumII();
        int[] nums = new int[]{1,2,7,6,1,5,10};
        int target = 8;
        System.out.println(cs.combinationSum2(nums,target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(candidates == null || candidates.length == 0) return result;

        ArrayList<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);

        combinationSum(candidates, target, 0, current, result);

        return result;
    }

    public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        for(int i=j; i<candidates.length; i++){
            if(i>j && candidates[i] == candidates[i-1]) continue;// each time start from different element
            //System.out.println("[i:]" + i + "[j:]" + j);
            if(target < candidates[i])
                return;

            curr.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i + 1, curr, result);
            curr.remove(curr.size()-1);
        }
    }
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Set<List<Integer>> set = combinationSum3(candidates,target);
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        Iterator it = set.iterator();
//        while (it.hasNext()){
//            result.add((List<Integer>) it.next());
//        }
//        return result;
//    }
//
//    public Set<List<Integer>> combinationSum3(int[] candidates, int target) {
//        Set<List<Integer>> result = new TreeSet<List<Integer>>(new Comparator<List<Integer>>() {
//            public int compare(List<Integer> o1, List<Integer> o2) {
//                if(!o1.isEmpty() && !o2.isEmpty()){
//                    if(o1.size() != o2.size()){return 1;}
//                    int n = o1.size();
//                    for (int i = 0; i < n; i++) {
//                        if(o1.get(i) != o2.get(i)){return 1;}
//                    }
//                }
//                return 0;
//            }
//        });
//
//        if(candidates == null || candidates.length == 0) return result;
//
//        ArrayList<Integer> current = new ArrayList<Integer>();
//        Arrays.sort(candidates);
//
//        combinationSum(candidates, target, 0, current, result);
//
//        return result;
//    }
//
//    public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, Set<List<Integer>> result){
//        if(target == 0){
//            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
//            result.add(temp);
//            return;
//        }
//
//        for(int i=j; i<candidates.length; i++){
//            //System.out.println("[i:]" + i + "[j:]" + j);
//
//            if(target < candidates[i])
//                return;
//
//            curr.add(candidates[i]);
//            combinationSum(candidates, target - candidates[i], i + 1, curr, result);
//            curr.remove(curr.size()-1);
//        }
//    }




//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        List<Integer> curr = new ArrayList<Integer>();
//        Arrays.sort(candidates);
//        helper(result, curr, 0, target, candidates);
//        return result;
//    }
//
//    public void helper(List<List<Integer>> result, List<Integer> curr, int start, int target, int[] candidates){
//        if(target==0){
//            result.add(new ArrayList<Integer>(curr));
//            return;
//        }
//        if(target<0){
//            return;
//        }
//
//        int prev=-1;
//        for(int i=start; i<candidates.length; i++){
//            if(prev!=candidates[i]){ // each time start from different element
//                curr.add(candidates[i]);
//                helper(result, curr, i+1, target-candidates[i], candidates); // and use next element only
//                curr.remove(curr.size()-1);
//                prev=candidates[i];
//            }
//        }
//    }

}
