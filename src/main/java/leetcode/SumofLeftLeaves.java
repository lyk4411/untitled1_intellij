package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2017/4/19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SumofLeftLeaves {
    public static void main(String[] args) {
        SumofLeftLeaves sll = new SumofLeftLeaves();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(2);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(3);
        TreeNode a6 = new TreeNode(3);
        TreeNode a7 = new TreeNode(4);
        TreeNode a8 = new TreeNode(4);
        TreeNode a9 = new TreeNode(5);

        a1.left = a2;
        a1.right = a3;
        a3.left = a4;
        a3.right = a5;
        a5.left = a6;
        a5.right = a7;
        a7.left = a8;
        a7.right = a9;
        System.out.println(sll.sumOfLeftLeaves(a1));
    }

//    public int sumOfLeftLeaves(TreeNode root) {
//        if(root == null) return 0;
//        int ans = 0;
//        if(root.left != null) {
//            if(root.left.left == null && root.left.right == null) ans += root.left.val;
//            else ans += sumOfLeftLeaves(root.left);
//        }
//        ans += sumOfLeftLeaves(root.right);
//
//        return ans;
//    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    stack.push(node.left);
            }
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}
