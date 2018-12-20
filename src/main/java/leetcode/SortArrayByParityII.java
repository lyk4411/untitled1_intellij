package leetcode;

import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-12-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        int t = 0;
        for (int x: A) if (x % 2 == 0) {
            ans[t] = x;
            t += 2;
        }
        t = 1;
        for (int x: A) if (x % 2 == 1) {
            ans[t] = x;
            t += 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        SortArrayByParityII sabpii = new SortArrayByParityII();
        IntStream.of(sabpii.sortArrayByParityII(new int[]{4,2,5,7})).
                forEach(n -> System.out.print(n + " : "));
    }
}
