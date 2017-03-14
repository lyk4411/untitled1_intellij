package leetcode;

import java.util.ArrayList;

/**
 * Created by lyk on 2017/3/14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Permutations {
    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums = new int[]{1,2,3};
        p.permute(nums);
        //System.out.println(p.permute(nums));
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //start from an empty list
        result.add(new ArrayList<Integer>());
        //System.out.println(result);

        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size()+1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);

                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);

                    //System.out.println(temp);
                    // - remove num[i] add
                    l.remove(j);
                }
            }
            result = new ArrayList<ArrayList<Integer>>(current);
            System.out.println("result:" + result);
        }
        return result;
    }



//    public List<List<Integer>> permute(int[] num) {
//        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
//        permute(num, 0,  result);
//        return result;
//    }
//
//    void permute(int[] num, int start, ArrayList<List<Integer>> result) {
//
//        if (start == num.length) {
//            ArrayList<Integer> item = convertArrayToList(num);
//            result.add(item);
//        }
//
//        for (int j = start; j <= num.length - 1; j++) {
//            swap(num, start, j);
//            permute(num, start + 1, result);
//            swap(num, start, j);
//        }
//    }
//
//    private ArrayList<Integer> convertArrayToList(int[] num) {
//        ArrayList<Integer> item = new ArrayList<Integer>();
//        for (int h = 0; h < num.length; h++) {
//            item.add(num[h]);
//        }
//        return item;
//    }
//
//    private void swap(int[] a, int i, int j) {
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }
}
