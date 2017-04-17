package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2017/4/17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KthSmallestElementinaBST {
    public static void main(String[] args) {
        KthSmallestElementinaBST kebst = new KthSmallestElementinaBST();
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
        System.out.println(kebst.kthSmallest(a1,3));
    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode p = root;
        int result = 0;

        while(!stack.isEmpty() || p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode t = stack.pop();
                k--;
                if(k==0)
                    result = t.val;
                p = t.right;
            }
        }

        return result;
    }
}
