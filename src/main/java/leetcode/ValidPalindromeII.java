package leetcode;

/**
 * Created by lyk on 2018-4-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ValidPalindromeII {
//    这道题是之前那道Valid Palindrome的拓展，还是让我们验证回复字符串，
//    但是区别是这道题的字符串中只含有小写字母，而且这道题允许删除一个字符，
//    那么当遇到不匹配的时候，我们到底是删除左边的字符，还是右边的字符呢，
//    我们的做法是两种情况都要算一遍，只要有一种能返回true，那么结果就返
//    回true。我们可以写一个子函数来判断字符串中的某一个范围内的子字符串
//    是否为回文串，参见代码如下：
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
