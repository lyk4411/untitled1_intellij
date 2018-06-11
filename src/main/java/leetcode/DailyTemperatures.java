package leetcode;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-6-11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[] temp = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        IntStream.of(dt.dailyTemperatures(temp)).forEach(n -> System.out.print(n + " = "));
    }
}
