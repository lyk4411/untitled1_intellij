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
        char[] c4 = new char[]{'a','b','c'};
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
        System.out.println("============================================");
        System.out.println(c4);
        System.out.println(sc.compress(c4));
        System.out.println(c4);
    }
    public int compress(char[] chars) {
        int len = chars.length;
        if (len < 2) {
            return len;
        }
        int res = 0;
        char c = chars[0];
        int num = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] == chars[i - 1]) {
                num++;
            }
            if (chars[i] != chars[i - 1]) {
                chars[res++] = c;
                if (num > 1) {
                    for (char cc : ("" + num).toCharArray()) {
                        chars[res++] = cc;
                    }
                }
                num = 1;
                c = chars[i];
            }
            if(i == len - 1){
                chars[res++] = c;
                if (num > 1) {
                    for (char cc : ("" + num).toCharArray()) {
                        chars[res++] = cc;
                    }
                }
            }
        }
        return res;
    }
}
