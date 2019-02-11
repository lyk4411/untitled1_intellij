package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lyk on 2019-2-11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class AddtoArrayFormofInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        AddtoArrayFormofInteger aafi = new AddtoArrayFormofInteger();
        System.out.println(aafi.addToArrayForm(new int[]{1, 1, 1}, 234));
        System.out.println(aafi.addToArrayForm(new int[]{1, 1, 1}, 11234));
    }
}
