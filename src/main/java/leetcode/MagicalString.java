package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/7/17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MagicalString {
    public static void main(String[] args) {
        MagicalString ms = new MagicalString();
        System.out.println(ms.magicalString(10));
        System.out.println(ms.magicalString(100));
    }
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        int res = 1, head = 2, tail = 3, num = 1;
        List<Integer> v = new ArrayList<Integer>();
        v.add(0,2);
        v.add(0,2);
        v.add(0,1);
        while (tail < n) {
            for (int i = 0; i < v.get(head); ++i) {
                v.add(num);
                if (num == 1 && tail < n) ++res;
                ++tail;
            }
            num ^= 3;
            ++head;
        }
        return res;
    }
}
