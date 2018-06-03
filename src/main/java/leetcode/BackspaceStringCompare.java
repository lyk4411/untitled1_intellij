package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2018-6-4.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        BackspaceStringCompare bsc = new BackspaceStringCompare();
        System.out.println(bsc.backspaceCompare("ab#c","ad#c"));
        System.out.println(bsc.backspaceCompare("ab##","a#d#"));
        System.out.println(bsc.backspaceCompare("a##c","#a#c"));
        System.out.println(bsc.backspaceCompare("a#c","d"));
    }
}
