package JavaConcurrencyinPractice;

import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-12-17.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */
public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }

    public static void main(String[] args) {
        DIStringMatch dism = new DIStringMatch();
        IntStream.of(dism.diStringMatch("IDID")).forEach(n -> System.out.print(n + " : "));
        System.out.println();
        IntStream.of(dism.diStringMatch("III")).forEach(n -> System.out.print(n + " : "));
        System.out.println();

    }
}
