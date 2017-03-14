package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/3/14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PermutationsII {
    public static void main(String[] args) {
        PermutationsII pii = new PermutationsII();
        int[] nums = new int[]{1,1,1};
        System.out.println(pii.permuteUnique(nums));
    }

//    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
//        ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
//        returnList.add(new ArrayList<Integer>());
//
//        for (int i = 0; i < num.length; i++) {
//            Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
//            for (List<Integer> l : returnList) {
//                for (int j = 0; j < l.size() + 1; j++) {
//                    l.add(j, num[i]);
//                    ArrayList<Integer> T = new ArrayList<Integer>(l);
//                    l.remove(j);
//                    currentSet.add(T);
//                }
//            }
//            returnList = new ArrayList<ArrayList<Integer>>(currentSet);
//        }
//
//        return returnList;
//    }

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteUnique(num, 0, result);
        return result;
    }

    private void permuteUnique(int[] num, int start, List<List<Integer>> result) {

        if (start == num.length ) {
            ArrayList<Integer> item = convertArrayToList(num);
            result.add(item);
        }

        for (int j = start; j <= num.length-1; j++) {
            if (containsDuplicate(num, start, j)) {
                swap(num, start, j);
                permuteUnique(num, start + 1, result);
                swap(num, start, j);
            }
        }
    }

    private ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> item = new ArrayList<Integer>();
        for (int h = 0; h < num.length; h++) {
            item.add(num[h]);
        }
        return item;
    }

    private boolean containsDuplicate(int[] arr, int start, int end) {
        for (int i = start; i <= end-1; i++) {
            if (arr[i] == arr[end]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
