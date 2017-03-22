package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lyk on 2017/3/22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        BinaryTreePreorderTraversal btpt = new BinaryTreePreorderTraversal();
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

        System.out.println(btpt.preorderTraversal(a1));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        if(root==null) {
            return ls;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);

        while(!st.isEmpty()) {
            TreeNode temp = st.pop();
            ls.add(temp.val);
            if(temp.right!=null) {
                st.push(temp.right);
            }
            if(temp.left!=null) {
                st.push(temp.left);
            }
        }
        return ls;
    }
}
