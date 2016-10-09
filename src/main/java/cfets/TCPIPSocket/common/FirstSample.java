package cfets.TCPIPSocket.common;

/**
 * Created by lyk on 2016/9/7.
 * Package name: cfets.TCPIPSocket.common
 * Porject name: untitled1
 */

import java.io.Console;
import java.io.PrintWriter;

/**
 * This is the first sample program in Core Java Chapter 3
 * @version 1.01 1997-03-22
 * @author Gary Cornell
 */
public class FirstSample
{
    public static void main(String[] args)
    {
        System.out.println("We will not use 'Hello, World!'");
        Character a = new Character('a');
        System.out.println(a.isJavaIdentifierPart('1'));
        System.out.println(a.isJavaIdentifierStart('1'));
        System.out.println((byte) 300);
        System.out.println("Java\u2122");
        String greeting = "Hello";
        int n = greeting.length(); // is 5.
        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println("cpCount:" + cpCount);
        String str = "Java™";
        char ch1 = str.charAt(1);
        char ch4 = str.charAt(4);
        System.out.println("ch1:" + ch1);
        System.out.println("ch4:" + ch4);
        System.out.println(Character.isSurrogate(str.charAt(4)));
        System.out.println("==================================");

        char[] chs = Character.toChars(0x10400);
        System.out.printf("U+10400 高代理字符: %04x%n", (int)chs[0]);
        System.out.printf("U+10400 低代理字符: %04x%n", (int)chs[1]);
        String str1 = new String(chs);
        System.out.println("代码单元长度: " + str1.length());
        System.out.println("代码点数量: " + str1.codePointCount(0, str1.length()));
        System.out.println("==================================");

        Console cons = System.console();
        PrintWriter printWriter = cons.writer();
        String username = cons.readLine("User name: ");
        cons.flush();

//        char[] passwd = cons.readPassword("Password: ");
        System.out.println(username);
//        System.out.println(String.valueOf(passwd));

    }
}
