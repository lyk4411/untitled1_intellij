package leetcode;

/**
 * Created by lyk on 2018-2-8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class StringCompression {
    public static void main(String[] args) {
        char[] c1 = new char[]{'a','a','b','b','c','c','c'};
        char[] c2 = new char[]{'a'};
        char[] c3 = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        StringCompression sc = new StringCompression();
        System.out.println(c1);
        System.out.println(sc.compress(c1));
        System.out.println(c1);
        System.out.println("============================================");
        System.out.println(c2);
        System.out.println(sc.compress(c2));
        System.out.println(c2);
        System.out.println("============================================");
        System.out.println(c3);
        System.out.println(sc.compress(c3));
        System.out.println(c3);
    }
    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
}
