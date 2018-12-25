package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2018-12-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == N;
    }

    public static void main(String[] args) {
        ValidateStackSequences vss = new ValidateStackSequences();
        System.out.println(vss.validateStackSequences(
                new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(vss.validateStackSequences(
                new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
}
