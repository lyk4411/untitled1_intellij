package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/5/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LexicographicalNumbers {
    public static void main(String[] args) {
        LexicographicalNumbers ln = new LexicographicalNumbers();
        System.out.println(ln.lexicalOrder(15));
        System.out.println(ln.lexicalOrder(150));

    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }
}
