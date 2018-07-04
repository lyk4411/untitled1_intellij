package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2018-7-5.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ScoreofParentheses {
    public int scoreOfParentheses(String S) {

        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c : S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        ScoreofParentheses sp = new ScoreofParentheses();
        System.out.println(sp.scoreOfParentheses("(())"));
        System.out.println(sp.scoreOfParentheses("()(()())"));
    }
}
