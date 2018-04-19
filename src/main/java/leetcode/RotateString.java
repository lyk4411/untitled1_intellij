package leetcode;

/**
 * Created by lyk on 2018-4-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.length() == 0)
            return true;

        search:
        for (int s = 0; s < A.length(); ++s) {
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt((s+i) % A.length()) != B.charAt(i))
                    continue search;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RotateString rs = new RotateString();
        String a1 = new String("abcde");
        String b1 = new String("cdeab");
        String a2 = new String("abcde");
        String b2 = new String("abced");
        System.out.println(rs.rotateString(a1,b1));
        System.out.println(rs.rotateString(a2,b2));

    }
}
