package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2019-2-5.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BeautifulArray {
    Map<Integer, int[]> memo;
    public int[] beautifulArray(int N) {
        memo = new HashMap();
        return f(N);
    }

    public int[] f(int N) {
        if (memo.containsKey(N))
            return memo.get(N);

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            for (int x: f((N+1)/2))  // odds
                ans[t++] = 2*x - 1;
            for (int x: f(N/2))  // evens
                ans[t++] = 2*x;
        }
        memo.put(N, ans);
        return ans;
    }

    public static void main(String[] args) {
        BeautifulArray ba = new BeautifulArray();
        IntStream.of(ba.beautifulArray(6)).forEach(n -> System.out.print(n + " : "));
        System.out.println();
        IntStream.of(ba.beautifulArray(16)).forEach(n -> System.out.print(n + " : "));
        System.out.println();
        IntStream.of(ba.beautifulArray(9)).forEach(n -> System.out.print(n + " : "));
    }
}
