package leetcode;

/**
 * Created by lyk on 2018-4-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ValidPalindromeII {
    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII vpii = new ValidPalindromeII();
        System.out.println(vpii.validPalindrome("aba"));
        System.out.println(vpii.validPalindrome("abca"));
    }
}
