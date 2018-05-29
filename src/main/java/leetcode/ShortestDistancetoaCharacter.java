package leetcode;

import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-5-29.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        ShortestDistancetoaCharacter sdc = new ShortestDistancetoaCharacter();
        String s1 = "loveleetcode";
        char c1 = 'e';
        IntStream.of(sdc.shortestToChar(s1,c1)).forEach(n ->System.out.print(n + " "));
    }
}
