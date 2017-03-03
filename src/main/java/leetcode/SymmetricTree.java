package leetcode;

/**
 * Created by lyk on 2017/3/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SymmetricTree {
    public  static  void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
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

        System.out.println("a1:" + st.isSymmetric(a1));


        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(2);
        TreeNode b4 = new TreeNode(3);
        TreeNode b5 = new TreeNode(4);
        TreeNode b6 = new TreeNode(4);
        TreeNode b7 = new TreeNode(3);

        b1.left  = b2;
        b1.right = b3;
        b2.left  = b4;
        b2.right = b5;
        b3.left  = b6;
        b3.right = b7;
        System.out.println("b1:" + st.isSymmetric(b1));

    }

    public boolean isSymmetric(TreeNode root) {
    if(root ==null){
        return true;
    }
        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
    if(left == null && right == null){
        return true;
    } else if(
            (left != null && right == null)||
                    (left == null && right != null)||
                    left.val != right.val ||
                    !isMirror(left.left,right.right)||
                    !isMirror(left.right,right.left)
            ){
            return false;
        } else {
            return true;
        }
    }
}
