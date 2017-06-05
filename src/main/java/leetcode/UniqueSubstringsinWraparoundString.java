package leetcode;

/**
 * Created by lyk on 2017/6/5.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class UniqueSubstringsinWraparoundString {
    public static void main(String[] args) {
        UniqueSubstringsinWraparoundString usws =
                new UniqueSubstringsinWraparoundString();
        System.out.println(usws.findSubstringInWraproundString("abc"));
        System.out.println(usws.findSubstringInWraproundString("atg"));
        System.out.println(usws.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }
    public int findSubstringInWraproundString(String p) {
        // count[i] is the maximum unique substring end with ith letter.
        // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
        int[] count = new int[26];

        // store longest contiguous substring ends at current position.
        int maxLengthCur = 0;

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                maxLengthCur++;
            }
            else {
                maxLengthCur = 1;
            }

            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);
        }

        // Sum to get result
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }
}
