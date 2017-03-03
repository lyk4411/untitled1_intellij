package leetcode;

/**
 * Created by lyk on 2017/3/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BalancedBinaryTree {
    public  static  void main(String[] args) {
        BalancedBinaryTree bdt = new BalancedBinaryTree();
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
        System.out.println("a1:" + bdt.isBalanced(a1));
        System.out.println("a7:" + bdt.isBalanced(a7));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if(Math.abs(depth(root.left) - depth(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left)  && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(depth(root.left),depth(root.right));
    }
}
