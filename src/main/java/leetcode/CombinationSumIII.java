package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/3/30.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        CombinationSumIII csiii = new CombinationSumIII();
        System.out.println(csiii.combinationSum3(3,10));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
}
