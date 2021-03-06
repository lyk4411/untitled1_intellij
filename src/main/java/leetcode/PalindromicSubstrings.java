package leetcode;

/**
 * Created by lyk on 2018-4-23.
 * Package name: leetcode
 * Porject name: untitled1
 */
//      其实这道题也可以用递归来做，而且思路非常的简单粗暴。就是以字符串中的每一个
//      字符都当作回文串中间的位置，然后向两边扩散，每当成功匹配两个左右两个字符，
//      结果res自增1，然后再比较下一对。注意回文字符串有奇数和偶数两种形式，如果是
//      奇数长度，那么i位置就是中间那个字符的位置，所以我们左右两遍都从i开始遍历；
//      如果是偶数长度的，那么i是最中间两个字符的左边那个，右边那个就是i+1，这样就
//      能cover所有的情况啦，而且都是不同的回文子字符串，参见代码如下：

//        Intuition
//        Let N be the length of the string. The middle of the palindrome could be
//        in one of 2N - 1 positions: either at letter or between two letters.
//        For each center, let's count all the palindromes that have this center.
//        Notice that if [a, b] is a palindromic interval (meaning S[a], S[a+1], ...,
//        S[b] is a palindrome), then [a+1, b-1] is one too.
//        Algorithm
//        For each possible palindrome center, let's expand our candidate palindrome
//        on the interval [left, right] as long as we can. The condition for expanding
//        is left >= 0 and right < N and S[left] == S[right]. That means we want to
//        count a new palindrome S[left], S[left+1], ..., S[right].

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
