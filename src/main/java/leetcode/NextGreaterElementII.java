package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by lyk on 2017/5/22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NextGreaterElementII {
    public static void main(String[] args) {
        NextGreaterElementII ngeii = new NextGreaterElementII();
        int[] nums = new int[]{1,2,3,4,2,3,1};
        int[] result = ngeii.nextGreaterElements(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "=");
        }
    }
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }
        return next;
    }
}
