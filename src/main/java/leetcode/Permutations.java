package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/3/14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Permutations {
    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums = new int[]{1,2,3};
        System.out.println(p.permute(nums));
    }

//    List<List<Integer>> res;
//    boolean[] used;
//
//    public List<List<Integer>> permute(int[] nums) {
//        res = new LinkedList<List<Integer>>();
//        used = new boolean[nums.length];
//        List<Integer> tmp = new LinkedList<Integer>();
//        helper(nums, tmp);
//        return res;
//    }
//
//    private void helper(int[] nums, List<Integer> tmp){
//        if(tmp.size() == nums.length){
//            List<Integer> list = new LinkedList<Integer>(tmp);
//            res.add(list);
//        } else {
//            for(int idx = 0; idx < nums.length; idx++){
//                // 遇到已经加过的元素就跳过
//                if(used[idx]){
//                    continue;
//                }
//                // 加入该元素后继续搜索
//                used[idx] = true;
//                tmp.add(nums[idx]);
//                helper(nums, tmp);
//                tmp.remove(tmp.size()-1);
//                used[idx] = false;
//            }
//        }
//    }




    public List<List<Integer>> permute(int[] num) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(num, 0,  result);
        return result;
    }

    void permute(int[] num, int start, ArrayList<List<Integer>> result) {

        if (start == num.length) {
            ArrayList<Integer> item = convertArrayToList(num);
            result.add(item);
        }

        for (int j = start; j <= num.length - 1; j++) {
            swap(num, start, j);
            permute(num, start + 1, result);
            swap(num, start, j);
        }
    }

    private ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> item = new ArrayList<Integer>();
        for (int h = 0; h < num.length; h++) {
            item.add(num[h]);
        }
        return item;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
