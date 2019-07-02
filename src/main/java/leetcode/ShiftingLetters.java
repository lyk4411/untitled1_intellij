package leetcode;

/**
 * Created by lyk on 2019-7-2.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder ans = new StringBuilder();
        int X = 0;
        for (int shift: shifts)
            X = (X + shift) % 26;

        for (int i = 0; i < S.length(); ++i) {
            int index = S.charAt(i) - 'a';
            ans.append((char) ((index + X) % 26 + 97));
            X = Math.floorMod(X - shifts[i], 26);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        ShiftingLetters sl = new ShiftingLetters();
        String S = "abc";
        int[] shifts = new int[]{3, 5, 9};
        System.out.println(sl.shiftingLetters(S, shifts));
    }
}
