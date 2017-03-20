package leetcode;

/**
 * Created by lyk on 2017/3/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn8 = new TreeNode(8);
        TreeNode tn9 = new TreeNode(9);

        tn1.left = tn2;
        tn1.right = tn3;
        tn3.left = tn4;
        tn3.right = tn5;
        tn4.left = tn6;
        tn4.right = tn7;
        tn7.left = tn8;
        tn7.right = tn9;
        System.out.println(vbst.isValidBST(tn1));
        System.out.println(vbst.isValidBST(tn8));

    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST(TreeNode p, double min, double max){
        if(p==null)
            return true;

        if(p.val <= min || p.val >= max)
            return false;

        return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
    }
}
