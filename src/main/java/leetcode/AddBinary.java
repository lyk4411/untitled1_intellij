package leetcode;

/**
 * Created by lyk on 2017/2/24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        Integer c = Integer.valueOf(a,2) + Integer.valueOf(b,2);
        String d = Integer.toBinaryString(c);
        return d;
    }
}
