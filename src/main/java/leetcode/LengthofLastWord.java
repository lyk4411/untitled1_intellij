package leetcode;

/**
 * Created by lyk on 2017/2/24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
