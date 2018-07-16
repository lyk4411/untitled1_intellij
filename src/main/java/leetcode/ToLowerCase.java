package leetcode;

/**
 * Created by lyk on 2018-7-16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        String lowerCase = "";
        for(int i = 0; i < str.length(); i++){
            lowerCase += String.valueOf(str.charAt(i)).toLowerCase();
        }
        return lowerCase;
    }

    public static void main(String[] args) {
        ToLowerCase tlc = new ToLowerCase();
        System.out.println(tlc.toLowerCase("abc"));
        System.out.println(tlc.toLowerCase("Hello."));

    }
}
