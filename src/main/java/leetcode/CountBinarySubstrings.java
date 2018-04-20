package leetcode;

/**
 * Created by lyk on 2018-4-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }
        for(int i: groups){
            System.out.print(i + " ");
        }
        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountBinarySubstrings cbs = new CountBinarySubstrings();
        System.out.println(cbs.countBinarySubstrings("00110011"));
        System.out.println(cbs.countBinarySubstrings("10101"));

    }
}
