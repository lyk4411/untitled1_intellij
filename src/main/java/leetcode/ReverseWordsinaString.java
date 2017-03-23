package leetcode;

/**
 * Created by lyk on 2017/3/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ReverseWordsinaString {
    public static void main(String[] args) {
        ReverseWordsinaString rws = new ReverseWordsinaString();
        System.out.println(rws.reverseWords(new String("hello world. i am fine.")));
    }
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];
    }
}
