package learnJVM.ch13;

/**
 * Created by lyk on 2018-12-7.
 * Package name: learnJVM.ch13
 * Porject name: untitled1
 */
public class classtest {
    public static void main(String[] args) {
        classtest ct = new classtest();
        Class a =  ct.getClass();
        final String name = a.getName();
        System.out.println(name);
        System.out.println("================================");

        String str2 = new String("str")+new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2==str1);

        String str3 = new String("str11")+new String("0111");
        String str4 = "str110111";
        str3.intern();
        System.out.println(str3==str4);

        System.out.println("================================");
        String s = new String("abc");
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s == s1.intern());
        System.out.println(s == s2.intern());
        System.out.println(s1 == s2.intern());
    }
}
