package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lyk on 2017/3/16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class GrayCode {
    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        System.out.println(gc.grayCode(10));
        System.out.println(gc.grayCode(7));
        System.out.println(gc.grayCode(4));
    }
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) {
            result.add(i ^ i>>1);
        }
        return result;
    }
}
