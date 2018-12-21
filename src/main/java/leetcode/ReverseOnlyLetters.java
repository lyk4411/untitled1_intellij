package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2018-12-21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        ReverseOnlyLetters rol = new ReverseOnlyLetters();
        System.out.println(rol.reverseOnlyLetters("ab-cd"));
        System.out.println(rol.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(rol.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
