package leetcode;

/**
 * Created by lyk on 2018-6-12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] S = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < S.length && S[i - 1] <= S[i]){
            i++;
        }
        while (0 < i && i < S.length && S[i - 1] > S[i]) {
            S[--i]--;
        }
        for(int j = i+1; j < S.length; ++j){
            S[j] = '9';
        }
        return Integer.parseInt(String.valueOf(S));
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits mid = new MonotoneIncreasingDigits();
        System.out.println(mid.monotoneIncreasingDigits(1234));
        System.out.println(mid.monotoneIncreasingDigits(4321));
        System.out.println(mid.monotoneIncreasingDigits(9321));
        System.out.println(mid.monotoneIncreasingDigits(120));
        System.out.println(mid.monotoneIncreasingDigits(332));
    }
}
