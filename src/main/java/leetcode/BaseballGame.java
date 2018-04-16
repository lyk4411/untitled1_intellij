package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2018-4-16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();

        for(String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }

    public static void main(String[] args) {
        BaseballGame bg = new BaseballGame();
        String[] a1 = new String[]{"5","2","C","D","+"};
        String[] a2 = new String[]{"5","-2","4","C","D","9","+","+"};

        System.out.println(bg.calPoints(a1));
        System.out.println(bg.calPoints(a2));
    }
}
