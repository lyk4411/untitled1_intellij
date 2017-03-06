package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/3/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0)
            return result;

        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);

        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();

            cur.add(1); //first
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1)); //middle
            }
            cur.add(1);//last

            result.add(cur);
            pre = cur;
        }

        return result;
    }
}
