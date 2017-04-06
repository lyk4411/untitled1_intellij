package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2017/4/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        LargestRectangleinHistogram lrh = new LargestRectangleinHistogram();
        int[] heights = new int[]{2,1,5,6,0,3,4,5,2};
        System.out.println(lrh.largestRectangleArea(heights));
    }
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0, largestArea = 0;
        while (index < height.length) {
            if (stack.isEmpty() || height[stack.peek()] < height[index]) {
                stack.push(index++);
            } else {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? index : index - stack.peek() - 1;
                largestArea = Math.max(largestArea, h * w);
//                System.out.println("index:" + index + " peek:" + (stack.isEmpty() ? "0" :stack.peek()));
//                System.out.println("largestArea:" + largestArea + "  h:" + h + " w:"+ w);
            }
        }
        while (!stack.isEmpty()) {
            int h = height[stack.pop()];
            int w = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
            largestArea = Math.max(largestArea, h * w);
            //System.out.println("index:" + index + " peek:" + (stack.isEmpty() ? "0" :stack.peek()));
            //System.out.println("largestArea:" + largestArea + "  h:" + h + " w:"+ w);
        }
        return largestArea;
    }
}
