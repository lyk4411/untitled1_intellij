package leetcode;

/**
 * Created by lyk on 2017/4/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        RecoverBinarySearchTree rbst = new RecoverBinarySearchTree();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(2);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(6);
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

        System.out.println(a1);
        rbst.recoverTree(a1);
        System.out.println(a1);
    }
    TreeNode first;
    TreeNode second;
    TreeNode pre;

    public void inorder(TreeNode root){
        if(root==null)
            return;

        inorder(root.left);

        if(pre==null){
            pre=root;
        }else{
            if(root.val<pre.val){
                if(first==null){
                    first=pre;
                }

                second=root;
            }
            pre=root;
        }

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        if(root==null)
            return;

        inorder(root);
        if(second!=null && first !=null){
            int val = second.val;
            second.val = first.val;
            first.val = val;
        }

    }
}



