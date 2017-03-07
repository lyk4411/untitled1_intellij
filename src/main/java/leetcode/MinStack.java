package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2017/3/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-31);
        ms.push(-11);
        ms.push(-21);
        ms.push(-1);
        ms.push(-41);
        ms.push(-51);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());

    }
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
