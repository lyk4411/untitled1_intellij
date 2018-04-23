package leetcode;

/**
 * Created by lyk on 2018-4-23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PalindromicSubstrings {
    public int countSubstrings(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        System.out.println(ps.countSubstrings("abc"));
        System.out.println(ps.countSubstrings("aaa"));
    }
}
