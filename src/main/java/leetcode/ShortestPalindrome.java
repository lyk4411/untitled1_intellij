package leetcode;

/**
 * Created by lyk on 2017/7/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();
        System.out.println(sp.shortestPalindrome("aacecaaa"));
        System.out.println(sp.shortestPalindrome("abcd"));

    }
    public String shortestPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s).reverse();
        String d = s + "#" + rev.toString();
        int n = d.length();
        int[] prefix = new int[n];
        // i for rev, j for s
        int i = 1, j = 0;
        while(i < n) {
            // match
            if(d.charAt(j) == d.charAt(i)) {
                prefix[i] = j + 1;
                i++;  j++;
            }
            else {
                if(j == 0) i++;
                else j = prefix[j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(prefix[n-1]));
        return sb.reverse().append(s).toString();
    }
}
