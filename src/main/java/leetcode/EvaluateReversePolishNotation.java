package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2017/3/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
        String[] tokens = new String[]{"2","4","5","*","+","6","-"};
        System.out.println(erpn.evalRPN(tokens));

    }
    public int evalRPN(String[] tokens) {
        int returnValue = 0;
        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for (String t : tokens) {
            if (!operators.contains(t)) { //push to stack if it is a number
                stack.push(t);
            } else {//pop numbers from stack if it is an operator
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (t) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;
    }
}
