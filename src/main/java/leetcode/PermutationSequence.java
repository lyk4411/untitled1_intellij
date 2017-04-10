package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/3/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();
        System.out.println(ps.getPermutation(3,1));
        //System.out.println(ps.getPermutation(3,2));
        //System.out.println(ps.getPermutation(3,3));
    }


    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<Integer>();
        int[] factTable = new int[10];
        factTable[1] = 1;
        for (int i = 2; i <= 9; i++) {
            factTable[i] = factTable[i - 1] * i;
        }
        for (int i = 1; i <= n; i++)
            list.add(i);
        helper(n, k, list, sb, factTable);
        return sb.toString();
    }
    public void helper(int n, int k, List<Integer> list, StringBuilder sb, int[] factTable) {
        if (n == 1) {
            sb.append(list.get(0));
            return;
        }
        int fact = factTable[n - 1];
        int bucket = (k - 1) / fact;
        sb.append(list.get(bucket));
        list.remove(bucket);
        helper(n - 1, k - fact * bucket, list, sb, factTable);
    }

//    public String getPermutation(int n, int k) {
//        int mod = 1;
//        List<Integer> candidates = new ArrayList<Integer>();
//        // 先得到n!和候选数字列表
//        for(int i = 1; i <= n; i++){
//            mod = mod * i;
//            candidates.add(i);
//            System.out.println(mod);
//            System.out.println(candidates);
//        }
//        // 将k先减1方便整除
//        k--;
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < n ; i++){
//            mod = mod / (n - i);
//            // 得到当前应选数字的序数
//            int first = k / mod;
//            // 得到用于计算下一位的k
//            k = k % mod;
//            sb.append(candidates.get(first));
//            // 在列表中移出该数字
//            candidates.remove(first);
//        }
//        return sb.toString();
//    }
}
