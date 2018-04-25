package leetcode;

import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-4-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int c = 0;
        for (int v = 1; v < n-k; v++) {
            ans[c++] = v;
        }
        for (int i = 0; i <= k; i++) {
            ans[c++] = (i%2 == 0) ? (n-k + i/2) : (n - i/2);
        }
        return ans;
    }

    public static void main(String[] args) {
        BeautifulArrangementII baii = new BeautifulArrangementII();
        IntStream.of(baii.constructArray(3,1)).forEach(n -> System.out.print(n + " : "));
        System.out.println();
        IntStream.of(baii.constructArray(8,4)).forEach(n -> System.out.print(n + " : "));
        System.out.println();
        IntStream.of(baii.constructArray(8,2)).forEach(n -> System.out.print(n + " : "));
    }
}
