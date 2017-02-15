package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by lyk on 2017/2/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NextGreaterElementI {
    public static void main(String[] args){
        NextGreaterElementI nge = new NextGreaterElementI();
        int[] a ={1,3,5,-1,0,2};
        int[] b ={1,-9,4,3,5,-1,0,2};
        int[] c = nge.nextGreaterElement(a,b);
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }

    }
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
}
