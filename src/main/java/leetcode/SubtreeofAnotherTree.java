package leetcode;

/**
 * Created by lyk on 2017/5/16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SubtreeofAnotherTree {
    public static void main(String[] args) {
        SubtreeofAnotherTree sat = new SubtreeofAnotherTree();
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

        TreeNode b1 = new TreeNode(4);
        TreeNode b2 = new TreeNode(4);
        TreeNode b3 = new TreeNode(5);
        b1.left = b2;
        b1.right = b3;
        System.out.println(sat.isSubtree(a1,b1));
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
