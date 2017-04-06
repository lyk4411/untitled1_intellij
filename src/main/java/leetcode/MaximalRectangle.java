package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2017/4/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        MaximalRectangle mr = new MaximalRectangle();
        char[][] matrixes = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(mr.maximalRectangle(matrixes));
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int largestRectangle = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int h = matrix[i][j] - '0';
                height[j] = h == 0 ? 0 : height[j] + 1;
            }
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(height[j]);
//            }
//            System.out.println();
            largestRectangle = Math.max(largestRectangle, largestRectangleArea(height));
        }
        return largestRectangle;
    }

    private int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0, largestArea = 0;
        while (index < height.length) {
            if (stack.isEmpty() || height[stack.peek()] < height[index]) {
                stack.push(index++);
            } else {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? index : index - stack.peek() - 1;
                largestArea = Math.max(largestArea, h * w);
            }
        }
        while (!stack.isEmpty()) {
            int h = height[stack.pop()];
            int w = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
            largestArea = Math.max(largestArea, h * w);
        }
        return largestArea;
    }
}
