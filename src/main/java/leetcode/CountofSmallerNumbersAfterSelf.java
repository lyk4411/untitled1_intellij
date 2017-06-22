package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lyk on 2017/6/22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CountofSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        CountofSmallerNumbersAfterSelf csnas = new CountofSmallerNumbersAfterSelf();
        int[] nums = new int[]{5,2,6,1};
        System.out.println(csnas.countSmaller(nums));
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}

class Node {
    Node left, right;
    int val, sum, dup = 1;
    public Node(int v, int s) {
        val = v;
        sum = s;
    }
}
