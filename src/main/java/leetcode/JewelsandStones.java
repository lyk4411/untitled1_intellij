package leetcode;

/**
 * Created by lyk on 2018-4-18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        int[] count = new int[64];
        for (char c : J.toCharArray()) {
            count[c - 'A']++;
        }
        int ans = 0;
        for (char c : S.toCharArray()) {
            if (count[c - 'A'] >= 1) ans ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        JewelsandStones js = new JewelsandStones();
        String J = new String("aA");
        String S = new String("aAAbbbb");
        System.out.println(js.numJewelsInStones(J,S));
    }
}
